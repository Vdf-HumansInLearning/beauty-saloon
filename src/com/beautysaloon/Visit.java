package com.beautysaloon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visit {

    private List<Service> services  = new ArrayList<>();

    private Map<Product, Integer> products = new HashMap<>();

    private MembershipType membershipType;

//    private List<SoldProduct> soldProducts = new ArrayList<>();


    public Visit(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public void addService(Service service) {
        services.add(service);
    }


    public void addProduct(Product product, int quantity) {
        products.merge(product, quantity, Integer::sum);
    }


    public BigDecimal calculatePrice() {
        BigDecimal totalProductsPrice = MembershipType.NONE.equals(membershipType)? getTotalProductsPrice() :
            getTotalProductsPrice().multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(Saloon.productDiscount)));
        BigDecimal totalServicePrice = getTotalServicePrice().multiply(BigDecimal.ONE.subtract(
            BigDecimal.valueOf(membershipType.getDiscount())));
        return totalProductsPrice.add(totalServicePrice);
    }

    private BigDecimal getTotalServicePrice() {
        BigDecimal totalServicePrice = BigDecimal.ZERO;
        for(Service service: services) {
            totalServicePrice = totalServicePrice.add(service.getPrice());
        }
        return totalServicePrice;
    }

    private BigDecimal getTotalProductsPrice() {
        BigDecimal totalProductsPrice = BigDecimal.ZERO;
        for(Product product: products.keySet()) {
            totalProductsPrice = totalProductsPrice.add(product.getPrice().multiply(BigDecimal.valueOf(products.get(product))));
        }
        return totalProductsPrice;
    }


}
