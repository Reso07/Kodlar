package com.wizard;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> items;
    private double profit;

    public StockList() {
        items = new HashMap<>();
        profit = 0.0;
    }

    public void addStock(StockItem item) {
        if(item != null) {
            StockItem inStock = items.getOrDefault(item.getName(),item);
            if(inStock != item) {
                item.adjustQuantity(item.available());
            }
            profit += (item.getPrice() * item.getQuantity());
            items.put(item.getName(),item);
        }
    }

    public int sellStock(String name, int amount) {
        StockItem inStock = items.getOrDefault(name,null);
        if(inStock != null && inStock.available() >= amount && amount > 0) {
            inStock.adjustQuantity(-amount);
            profit -= (inStock.getPrice() * amount);
            return amount;
        }
        return -1;
    }

    public StockItem get(String key) {
        return items.get(key);
    }

    public Map<String, StockItem> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public  Map<String, Double> pricelist() {
        Map<String,Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item : items.entrySet()) {
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return prices;
    }

    @Override
    public String toString() {
        String string = "Items in stock\n";
        for(Map.Entry<String,StockItem> i : items.entrySet()) {
            StockItem item = i.getValue();
            string += item + "\n";
        }
        return string + "Total price = " + String.format("%.2f",profit);
    }
}
