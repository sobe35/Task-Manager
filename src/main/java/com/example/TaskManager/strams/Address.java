package com.example.TaskManager.strams;

public class Address {
    private int pincode;
    private String street;

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(int pincode, String street) {
        this.pincode = pincode;
        this.street = street;
    }

    @Override
    public String  toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", street='" + street + '\'' +
                '}';
    }
}
