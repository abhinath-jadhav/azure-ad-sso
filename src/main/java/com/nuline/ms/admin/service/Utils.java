package com.nuline.ms.admin.service;

import com.nuline.ms.admin.models.Product;

public class Utils {

    static Integer availableTicket = 500;
    Integer availableTicket1 = 500;

    public static Product getProducts(Product pr){

        availableTicket = availableTicket - 10;

        return pr;
    }

    public Product getAll(Product pr){
        availableTicket1 = availableTicket1 - 10;
        return pr;
    }
}
