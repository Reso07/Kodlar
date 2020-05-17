package com.wizard;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantity, reserved = 0;

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity - reserved;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    protected void adjustQuantity(int amount) {
        int newQuantity = quantity + amount;
        if(newQuantity >= 0) {
            quantity = newQuantity;
        }
    }

    protected int available() { return quantity - reserved; }

    public int getReserved() { return reserved; }

    protected boolean reserve(int amount) {
        if(amount <= getQuantity()) {
            reserved += amount;
            return true;
        }
        return false;
    }

    protected boolean unreserve(int amount) {
        if(reserved >= amount) {
            reserved -= amount;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return name.equals(((StockItem) obj).getName());
    }

    @Override
    public int compareTo(StockItem o) {
        if(o == this) {
            return 0;
        }
        if(o != null) {
            return name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + " - Price: " + String.format("%.2f",price) + " - Quantity in stock: "+ quantity + " - Available: "+available();
    }
}
