package com.fiipractic.health.entity.model;

import javax.persistence.*;

/**
 * @author Victor Manoliu on 10-Apr-18
 */
@Entity
@Table(name = "Email")
public class Email {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @Column(name = "email")
    @javax.validation.constraints.Email
    private String emailAdress;

    public Long getEmailId() {
        return emailId;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }
}
