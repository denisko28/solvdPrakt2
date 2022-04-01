package com.company.Classes;

import com.company.Exceptions.NegativeBalanceException;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class Address {
    private static final Logger LOGGER = Logger.getLogger(Address.class);

    private String building;
    private String street;
    private String city;
    private String region;
    private String postCode;
    private String country;

    public Address() {}

    public Address(String building, String street, String city, String region, String postCode, String country) {
        this.building = building;
        this.street = street;
        this.city = city;
        this.region = region;
        this.postCode = postCode;
        this.country = country;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        try {
            if (Pattern.matches("^[A-Z][a-zA-Z\\s-]+[a-z]$", street))
                this.street = street;
            else
                throw new IllegalArgumentException("Street should begin with capital letter and contain only " +
                        "letters, spaces and '-' symbols");
        } catch (IllegalArgumentException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        try {
            if (Pattern.matches("^[A-Z][a-zA-Z\\s-]+[a-z]$", city))
                this.city = city;
            else
                throw new IllegalArgumentException("City should begin with capital letter and contain only " +
                        "letters, spaces and '-' symbols");
        } catch (IllegalArgumentException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        try {
            if (Pattern.matches("^[A-Z][a-zA-Z\\s-]+[a-z]$", region))
                this.region = region;
            else
                throw new IllegalArgumentException("Region should begin with capital letter and contain only " +
                        "letters, spaces and '-' symbols");
        } catch (IllegalArgumentException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        try {
            if (Pattern.matches("^\\d{5}$", country))
                this.postCode = postCode;
            else
                throw new IllegalArgumentException("Postal code should consist of 5 digits");
        } catch (IllegalArgumentException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        try {
            if (Pattern.matches("^[A-Z][a-zA-Z\\s-]+[a-z]$", country))
                this.country = country;
            else
                throw new IllegalArgumentException("Country should begin with capital letter and contain only " +
                        "letters, spaces and '-' symbols");
        } catch (IllegalArgumentException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "building='" + building + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
