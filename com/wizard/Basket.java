package com.wizard;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private final Map<StockItem,Integer> basket;
    private final String name;
    private double cost;
    private boolean isFinished = false;
    private StockList stockList;

    public void setStockList(StockList stockList) {
        this.stockList = stockList;
    }

    public Basket(String name) {
        this.basket = new LinkedHashMap<>();
        this.name = name;
    }

    protected void addToBasket(StockItem item, int quantity) {
        if(item != null && quantity > 0 && item.reserve(quantity)) {
            basket.put(item, basket.getOrDefault(item,0)+quantity);
            cost += item.getPrice() * quantity;
        } else {
            System.out.println("Unsuccessful attempt");
        }
    }

    protected void unreserve(StockItem item, int quantity) {
        if(basket.get(item) != null) {
            item.unreserve(quantity);
            cost -= item.getPrice() * quantity;
            if(quantity < item.getReserved()) {
                basket.replace(item, basket.getOrDefault(item, item.getQuantity()) - quantity);
            } else {
                basket.remove(item,quantity);
            }
        }
    }

    protected Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    protected void finish() {
        for(Map.Entry<StockItem,Integer> i: basket.entrySet()) {
            StockItem item = i.getKey();
            item.unreserve(item.getReserved());
            stockList.sellStock(item.getName(),i.getValue());
        }
        isFinished = true;
        basket.clear();
        System.out.println("Shopping ended.");
        cost = 0.0;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public String toString() {
        if(basket.size() > 0) {
            String s = "Your basket" + ((basket.size() == 1) ? " item" : " items") + ":\n";
            for (Map.Entry<StockItem, Integer> item : basket.entrySet()) {
                s += item.getKey() + ", " + item.getValue() + " purchased.\n";
            }
            return s + "Total cost: " + String.format("%.2f",cost);
        }
        return "No items in the basket";
    }
}
