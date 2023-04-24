package com._42talents.spring_boot_karate_example.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("sales")
public class Sales {
    private Date saleDate;
    private String storeLocation;
    private String purchaseMethod;

}
