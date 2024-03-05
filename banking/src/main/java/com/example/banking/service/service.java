package com.example.banking.service;
import com.example.banking.modal.data;
import com.example.banking.modal.dto.*;
import com.example.banking.repo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
    @Autowired
    private dao dao;

    public List<data> addDetails(List<data> data){
        return dao.saveAll(data);
    }

    public List<data> getDetails(){
        return dao.findAll();
    }

    public AfterWithdrawBalance withdraw(Integer withdrawAmount, String accountNo) {
        data currentAccount = dao.findByAcNo(accountNo);

        if (currentAccount == null) {
            // Handle the case where the account is not found
            return AfterWithdrawBalance.builder().withdraw(0).currentBalance((double) 0).build();
        }

        double currentBalance = currentAccount.getBalance();

        if (currentBalance < withdrawAmount) {
            // Handle the case where there are insufficient funds
            return AfterWithdrawBalance.builder().withdraw(0).currentBalance(currentBalance).build();
        }

        currentBalance -= withdrawAmount;

        currentAccount.setBalance(currentBalance);
        dao.save(currentAccount);

        return AfterWithdrawBalance.builder()
        .withdraw(withdrawAmount)
        .currentBalance(currentAccount.getBalance())
        .build();
    }

    public AfterDepositBalance deposit(Integer depositBalance, String accountNo) {
        data currentAccount = dao.findByAcNo(accountNo);
        double currentBalance = currentAccount.getBalance();
        currentBalance += depositBalance;
        data updateAccount = new data();
        updateAccount.setId(currentAccount.getId());
        updateAccount.setBalance(currentBalance);
        updateAccount.setAcNo(currentAccount.getAcNo());
        updateAccount.setAcHolderName(currentAccount.getAcHolderName());
        updateAccount.setEmail(currentAccount.getEmail());
        updateAccount.setAddress(currentAccount.getAddress());
        updateAccount.setPhoneNo(currentAccount.getPhoneNo());
        updateAccount.setRegion(currentAccount.getRegion());
        updateAccount.setPostalZip(currentAccount.getPostalZip());
        dao.save(updateAccount);
        return AfterDepositBalance.builder()
                .depositBalance(depositBalance)
                .currentBalance(updateAccount.getBalance())
                .build();
    }



}

