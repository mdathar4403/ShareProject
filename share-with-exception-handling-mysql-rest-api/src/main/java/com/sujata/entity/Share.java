package com.sujata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Share")
public class Share {

    @Id
    @Column(name = "SHARE_ID")
    private int shareId;

    @Column(name = "SHARE_NAME")
    private String shareName;

    private int market_price;

    private LocalDate issueDate;

    public Share(){

    }

    public Share(int shareId, String shareName, int market_price, LocalDate issueDate) {
        this.shareId = shareId;
        this.shareName = shareName;
        this.market_price = market_price;
        this.issueDate = issueDate;
    }

    public int getShareId() {
        return shareId;
    }

    public void setShareId(int shareId) {
        this.shareId = shareId;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public int getMarket_price() {
        return market_price;
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Share{" +
                "shareId=" + shareId +
                ", shareName='" + shareName + '\'' +
                ", market_price=" + market_price +
                ", issueDate=" + issueDate +
                '}';
    }
}
