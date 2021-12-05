package com.beautysaloon;

import java.math.BigDecimal;
import java.util.Objects;

public class Service {

    private String name;

    private BigDecimal price;

    public Service(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException("Price can't be zore or less");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Service)) {
            return false;
        }
        Service service = (Service) o;
        return name.equals(service.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Service{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
