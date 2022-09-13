package com.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderProcessing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quatity;
	private double price;

}
