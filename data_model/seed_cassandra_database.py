"""
This script creates & populates the users & the trips cassandra tables
"""
# !/usr/bin/env python3

import os
import csv
from utilities.cassandra_utilities import createCassandraConnection, createKeySpace


def populate_products_table(csv_file):
    insert_trip_data_point = """INSERT INTO products(vendor, name, image_url, price, category, inventory) VALUES(%s,%s,%s,%s, %s, %s);"""

    with open(csv_file, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['vendor'], row['name'], row['image_url'], float(row['price']),row['category'], 3])

if __name__ == '__main__':
    dbsession = createCassandraConnection()
    createKeySpace("ks1", dbsession)
    try:
        dbsession.set_keyspace('ks1')
    except Exception as e:
        print(e)

    create_trip_data_point_table = """CREATE TABLE IF NOT EXISTS products(
        vendor text,
        name text, 
        image_url text,
        price float,
        category text,
        inventory int,
        PRIMARY KEY((vendor, name)));

    """
    dbsession.execute(create_trip_data_point_table)

    CSV_DIRECTORY = 'data/products'
    csv_files = []
    for file in os.listdir(CSV_DIRECTORY):
        file_path = '{}/{}'.format(CSV_DIRECTORY, file)
        if file_path.split('.')[-1] == 'csv':
            csv_files.append(file_path)
    for file in csv_files:
        populate_products_table(file)

