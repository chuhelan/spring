package com.chuhelan.domain;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 14:38
 **/

public class Phone {
    private String brand;
    private Integer price;
    private String color;

    public Phone() {
    }

    public Phone(String brand, Integer price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public void setColor(String color){
        this.color = color;
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
                ", color='" + color + '\'' +
                '}';
    }
}