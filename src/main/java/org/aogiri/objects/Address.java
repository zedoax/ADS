package org.aogiri.objects;

public class Address {
    private String city;
    private String street;
    private String number;
    private String zipcode;

    public Address(String city, String street, String number, String zipcode){
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }

    public String getCity(){
        return city;
    }

    public String getStreet(){
        return street;
    }

    public String getNumber(){
        return number;
    }

    public String getZip(){
        return zipcode;
    }
}
