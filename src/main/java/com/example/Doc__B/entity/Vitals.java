package com.example.Doc__B.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Vitals {
    private String bp;
    private String hr;
    private String temp;
    private String weight;

    public Vitals() {}

    public Vitals(String bp, String hr, String temp, String weight) {
        this.bp = bp;
        this.hr = hr;
        this.temp = temp;
        this.weight = weight;
    }

    public String getBp() { return bp; }
    public void setBp(String bp) { this.bp = bp; }
    public String getHr() { return hr; }
    public void setHr(String hr) { this.hr = hr; }
    public String getTemp() { return temp; }
    public void setTemp(String temp) { this.temp = temp; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }
}
