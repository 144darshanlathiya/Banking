package com.example.banking.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String acNo;

    private String generateRandomNumber(){
        long min = 1000000000L;
        long max = 10000000000L;
        long randomNumer = min + (long) (Math.random() * (max - min));
        return  String.valueOf(randomNumer);
    }

    @PrePersist
    public  void generateNumber(){
        this.acNo = generateRandomNumber();
    }
    private String acHolderName;
    private String address;
    private String email;
    private String phoneNo;
    private String postalZip;
    private String region;
    private Double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getAcHolderName() {
        return acHolderName;
    }

    public void setAcHolderName(String acHolderName) {
        this.acHolderName = acHolderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
