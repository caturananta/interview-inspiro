package com.example.demo;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

class VendingMachine {
    private Product[] products;
    private double balance;
    private Product[] purchasedItems;
    private int purchasedItemCount;
    private Set<Double> validDenominations = new HashSet<>();

    public VendingMachine() {
        products = new Product[100];
        balance = 0.0;
        purchasedItems = new Product[100];
        purchasedItemCount = 0;
        validDenominations = new HashSet<>();
        validDenominations.add(2000.0);
        validDenominations.add(5000.0);
        validDenominations.add(10000.0);
        validDenominations.add(20000.0);
        validDenominations.add(50000.0);
    }

    public void addItem(Product product) {
        products[purchasedItemCount] = product;
        purchasedItemCount++;
    }

    public void displayItems() {
        System.out.println("Barang yang dijual:");
        DecimalFormat df = new DecimalFormat("#,###");
        for (int i = 0; i < purchasedItemCount; i++) {
            Product product = products[i];
            System.out.println(product.getName() + " - Rp " + df.format(product.getPrice()) + " - Stock: " + product.getStock());
        }
    }


    public void buyItem(String itemName, double amount) {
        System.out.println("---------------------------------------");
        if(!validDenominations.contains(amount)){
            System.out.println("Beli = "+itemName+", uang = "+amount);
            System.out.println("Pecahan uang salah! "+amount);
        }
        else {
            Product product = getProductByName(itemName);
            System.out.println("Beli = "+itemName+", harga ="+product.getPrice()+", uang = "+amount);
            if (product != null) {
                if (product.getStock() > 0) {
                    if (amount >= product.getPrice() ) {
                        balance = amount - product.getPrice();
                        purchasedItems[purchasedItemCount] = product;
                        purchasedItemCount++;
                        product.setStock(product.getStock() - 1);
                        System.out.println("Sisa stock = "+product.getStock()+", Uang kembalian anda: " + balance);
                    } else {
                        System.out.println("Insufficient amount to purchase " + product.getName());
                    }
                } else {
                    System.out.println("Stock habis: " + product.getName());
                }
            } else {
                System.out.println("Produk tidak ditemukan: " + itemName);
            }
        }

        System.out.println("---------------------------------------");
    }

    private Product getProductByName(String itemName) {
        for (int i = 0; i < purchasedItemCount; i++) {
            Product product = products[i];
            if (product.getName().equals(itemName)) {
                return product;
            }
        }
        return null;
    }
}