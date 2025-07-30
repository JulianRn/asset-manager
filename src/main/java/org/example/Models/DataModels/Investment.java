package org.example.Models.DataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "investments")
public class Investment {
    @Id
    private String id;

    @DBRef
    private final Asset asset;

    private final String userId;

    private double amount;
    private final Date date;

    public Investment(Asset asset, String userId, double amount, Date date) {
        this.asset = asset;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Asset getInvestmentAsset() {
        return asset;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
