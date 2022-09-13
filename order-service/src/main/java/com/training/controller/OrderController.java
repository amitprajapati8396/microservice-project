package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.service.OrderService;
import com.training.service.TransactionRequest;
import com.training.service.TransactionRespone;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionRespone bookOrder(@RequestBody TransactionRequest request)
	{
		return orderService.BookOrder(request);
	}
}
