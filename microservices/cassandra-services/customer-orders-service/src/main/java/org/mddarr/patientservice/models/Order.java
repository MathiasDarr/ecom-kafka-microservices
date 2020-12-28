package org.mddarr.patientservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @PrimaryKeyColumn(name = "orderid",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String orderID;

    @PrimaryKeyColumn(name="customerid",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private String customerid;




//    @Column("last_name") private String last_name;
//
//    public Order(String id) {
//        this.setId(id);
//    }
//
//    public String getId() {
//        return patient_id;
//    }
//
//    public void setId(String id) {
//        this.patient_id = id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
}

