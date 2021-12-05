package com.beautysaloon;

import java.math.BigDecimal;

public class MySaloon {

    public static void main(String[] args) {
        Saloon saloon = new Saloon();

        Customer normal = new Customer("test");

        Customer vip = new Customer("vip");
        vip.setMembershipType(MembershipType.PREMIUM);

        Product shampoo = new Product("shampoo", BigDecimal.TEN);
        Product conditioner = new Product("conditioner", BigDecimal.valueOf(12.5));

        Visit visit = normal.createVisit();
        visit.addProduct(shampoo, 2);
        visit.addProduct(conditioner, 1);

        Service cutting = new Service("man cutting", BigDecimal.valueOf(25));
        Service washing = new Service("man washing", BigDecimal.valueOf(15));
        visit.addService(cutting);
        visit.addService(washing);

        System.out.println(visit.calculatePrice());

        Visit vipVisit = vip.createVisit();
        vipVisit.addProduct(shampoo, 2);
        vipVisit.addProduct(conditioner, 1);

        vipVisit.addService(cutting);
        vipVisit.addService(washing);

        System.out.println(vipVisit.calculatePrice());


    }

}
