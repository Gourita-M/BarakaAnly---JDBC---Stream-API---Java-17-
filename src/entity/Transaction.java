package src.entity;

import java.util.Date;
import src.Enum.TransactionType;

public class Transaction {
    private int id;
    private Date date;
    private Double amount;
    private TransactionType type;
    private String location;
    private int accountId;

    public Transaction(Date date, Double amount, TransactionType type, String location, int accountId) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.location = location;
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
