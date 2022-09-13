package com.training.service;

import com.training.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRespone {
 private Order order;
 private double amount;
 private String transactionId;
 private String message;
 
 public TransactionRespone(String message)
 {
	 this.message=message;
 }
}
