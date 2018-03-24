package com.fiipractic.health.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Victor Manoliu on 21-Mar-18
 */
public class Pacient {

    private int pacientId;
    private String pacientFirstName;
    private String pacientLastName;
    private String dateArrived;
    private String pacientDisease;
    private String pacientSex;
    private float pacientHeight;
    private float pacientWeight;
    private String pacientState;

    public void setPacientId(int pacientId) {
        this.pacientId = pacientId;
    }

    public void setPacientFirstName(String pacientFirstName) {
        this.pacientFirstName = pacientFirstName;
    }

    public void setPacientLastName(String pacientLastName) {
        this.pacientLastName = pacientLastName;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    public void setPacientState(String pacientState) {
        this.pacientState = pacientState;
    }

    public void setPacientDisease(String pacientDisease) {
        this.pacientDisease = pacientDisease;
    }

    public void setPacientSex(String pacientSex) {
        this.pacientSex = pacientSex;
    }

    public void setPacientHeight(float pacientHeight) {
        this.pacientHeight = pacientHeight;
    }

    public void setPacientWeight(float pacientWeight) {
        this.pacientWeight = pacientWeight;
    }

    public int getPacientId() {
        return pacientId;
    }

    public String getPacientFirstName() {
        return pacientFirstName;
    }

    public String getPacientLastName() {
        return pacientLastName;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public String getPacientState() {
        return pacientState;
    }

    public String getPacientDisease() {
        return pacientDisease;
    }

    public String getPacientSex() {
        return pacientSex;
    }

    public float getPacientHeight() {
        return pacientHeight;
    }

    public float getPacientWeight() {
        return pacientWeight;
    }
}
