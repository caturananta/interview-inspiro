package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		VendingMachine vendingMachine = new VendingMachine();

		vendingMachine.addItem(new Product("Biskuit", 6000, 1));
		vendingMachine.addItem(new Product("Chips", 8000, 1));
		vendingMachine.addItem(new Product("Oreo", 10000, 1));
		vendingMachine.addItem(new Product("Tango", 12000, 1));
		vendingMachine.addItem(new Product("Cokelat", 15000, 1));

		vendingMachine.displayItems();

		vendingMachine.buyItem("Biskuit", 10000);
		vendingMachine.buyItem("Biskuit", 10000);
		vendingMachine.buyItem("Chips", 10000);
		vendingMachine.buyItem("Tango", 20000);
		vendingMachine.buyItem("Oreo", 15000);
		vendingMachine.buyItem("Oreo", 10000);

//		vendingMachine.displayRemainingBalance();
//		vendingMachine.displayPurchasedItems();
//		vendingMachine.displayStock();
	}



}
