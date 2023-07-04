package com.nuline.ms.admin.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "products")
public class Product {
    /*
        - id
        - name
        - images < List>
        - category
        - attributes <Map>
            - flavour
            - size kg/ml
            - MRP
            - offer
            - actual price
            - main desc <String>
            - usp desc Map<String, Object>
            - nutrivalue - > image link
     */
    @Id
    private String id;
    private String name;
    private String category;
    private List<String> images;
    private Double price;
    private Integer offerPercentage;
    private Map<String, Object> attributes;
    private Float rating;

}
