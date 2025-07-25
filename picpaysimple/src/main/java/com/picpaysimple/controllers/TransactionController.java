package com.picpaysimple.controllers;

import com.picpaysimple.dtos.TransactionDTO;
import com.picpaysimple.models.transaction.Transaction;
import com.picpaysimple.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransacion = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransacion,HttpStatus.CREATED);
    }
}