package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.model.Order;
import com.training.model.Payment;
import com.training.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	public static final String Order_Service="orderService";

	@CircuitBreaker(name=Order_Service,fallbackMethod = "getPaymentInfo")
	public TransactionRespone BookOrder(TransactionRequest request) {
		
		
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentrespone=restTemplate.postForObject("http://localhost:8282/payment/doPayment", payment, Payment.class);
		
		String message=paymentrespone.getPaymentStatus().equals("Success")?"Payment processing succesfully and order placed":"Payment Failure order not placed";
		
		return new TransactionRespone(order, paymentrespone.getAmount(), paymentrespone.getTransactionId(), message);
	}

	public TransactionRespone getPaymentInfo(TransactionRequest request,Exception e)
	{
		//System.out.println("Order service is taking too much time");
		
		Order order=request.getOrder();
		
		return new TransactionRespone(order,1000.00d,"txOrder12344","Order service is taking too much time");
	}
}
