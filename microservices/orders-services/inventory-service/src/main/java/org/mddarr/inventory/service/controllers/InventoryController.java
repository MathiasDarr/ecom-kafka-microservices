package org.mddarr.inventory.service.controllers;


import org.mddarr.inventory.service.services.AvroProductProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    @Autowired
    AvroProductProducer avroProductProducer;

    @PutMapping(value="inventory/post")
    public void activateDriver(){
        avroProductProducer.postAvroProduct();
    }
}
