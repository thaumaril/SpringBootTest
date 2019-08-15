package com.example.helloworld;

public class Car {

    private final String brand;
    private final String color;
    private final int power;
    

    public Car(String brand, String color, int power) {
        this.brand = brand;
        this.color = color;
        this.power = power;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }


    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }


}