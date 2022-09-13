package com.training.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Payment;
import com.training.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {

		payment.setPaymentStatus(paymentProcessStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessStatus()
	{
		return new Random().nextBoolean()?"Success":"failure";
	}
	
	
	
}
