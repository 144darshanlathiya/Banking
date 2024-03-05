package com.example.banking.controller;
import com.example.banking.modal.data;
import com.example.banking.modal.dto.TransferMoney;
import com.example.banking.service.service;
import com.example.banking.modal.dto.AfterWithdrawBalance;
import com.example.banking.modal.dto.AfterDepositBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank")
public class controller {
    @Autowired
    private service service;

    @PostMapping("/add")
    private List<data> addDetails(@RequestBody List<data> data){
        return service.addDetails(data);
    }

    @GetMapping("/getDetails")
    private List<data> getDetails(){
        List<data> dataa=service.getDetails();
        return dataa;
    }

    @PostMapping("withdraw")
    private AfterWithdrawBalance withdraw(@RequestParam Integer withdraw , @RequestParam String accountNo){
        return service.withdraw(withdraw,accountNo);
    }


    @PostMapping("deposit")  // Make sure to provide a complete path for the endpoint
    private AfterDepositBalance deposit(@RequestParam Integer deposit, @RequestParam String accountNo) {
        return service.deposit(deposit, accountNo);
    }



}
