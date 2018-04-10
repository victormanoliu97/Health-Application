package com.fiipractic.health.entity.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * @author Victor Manoliu on 10-Apr-18
 */
@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneNumberId;

    @Column(name = "number")
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$" , message = "You must enter a valid phone number")
    private String phoneNumber;

    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }
}
