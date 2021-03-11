package com.chuhelan.domain;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 14:38
 **/

public class Phone {
    private String brand;
    private Integer price;

    public Phone() {
    }

    public Phone(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}