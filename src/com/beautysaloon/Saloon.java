package com.beautysaloon;

import java.util.HashMap;
import java.util.Map;

public class Saloon {

    private Map<Product, Integer> stock = new HashMap<>();

    protected static double productDiscount = 0.1;

    public Integer getStockForProduct(Product product) {
        return stock.get(product);
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }


}
