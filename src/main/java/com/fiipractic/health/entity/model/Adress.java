package com.fiipractic.health.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Victor Manoliu on 10-Apr-18
 */
@Entity
@Table(name = "adresses")
public class Adress {

    @Id
    @Column(name = "id")
    private Long adressId;

    @Column(name = "street")
    private String streetName;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "country")
    private String country;

    @Column(name =  "city")
    private String city;

    public int getStreetNumber() {
        return streetNumber;
    }

    public Long getAdressId() {
        return adressId;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
