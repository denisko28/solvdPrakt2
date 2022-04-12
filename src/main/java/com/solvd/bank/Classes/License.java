package com.solvd.bank.Classes;

import com.solvd.bank.Exceptions.EarlierDateException;
import com.solvd.bank.Exceptions.FutureDateException;
import org.apache.log4j.Logger;

import java.util.Date;

public class License {
    private static final Logger LOGGER = Logger.getLogger(License.class);

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
        try {
            Date currentDate = new Date();
            if (!signDate.after(currentDate))
                this.signDate = signDate;
            else
                throw new FutureDateException();
        } catch(FutureDateException ex) {
            LOGGER.debug(ex.getMessage());
        }
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        try {
            if(signDate == null)
                throw new NullPointerException("The sign date has to be set before setting expiration date");
            else if(!expireDate.after(signDate))
                this.expireDate = expireDate;
            else
                throw new EarlierDateException(signDate);
        } catch (Exception ex) {
            LOGGER.debug(ex.getMessage());
        }
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
