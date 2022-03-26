package com.company.Classes;

import java.util.Date;

public class License {
    private String id;
    private Date signDate;
    private Date expireDate;
    private Person signedBy;
    private final String nationalBankLink = "https://bank.gov.ua/";

    public License() {}

    public License(String id, Date signDate, Date expireDate, Person signedBy) {
        this.id = id;
        this.signDate = signDate;
        this.expireDate = expireDate;
        this.signedBy = signedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Person getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(Person signedBy) {
        this.signedBy = signedBy;
    }

    public String getNationalBankLink() {
        return nationalBankLink;
    }

    @Override
    public String toString() {
        return "License{" +
                "id='" + id + '\'' +
                ", signDate=" + signDate.toString() +
                ", expireDate=" + expireDate.toString() +
                ", signedBy=" + signedBy.toString() +
                '}';
    }
}
