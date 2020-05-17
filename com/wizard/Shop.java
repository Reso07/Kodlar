package com.wizard;

import java.util.Scanner;

public class Shop {

    private static StockList stockList = new StockList();
    private static Scanner scanner = new Scanner(System.in);
    private static StockItem stockItem;

    public static void main(String[] args) throws InterruptedException {
        StockItem stockItem = new StockItem("bread", 1.75, 60);
        stockList.addStock(stockItem);

        stockItem = new StockItem("cookies", 3.20, 55);
        stockList.addStock(stockItem);

        stockItem = new StockItem("potato", 5.55, 107);
        stockList.addStock(stockItem);
        stockItem = new StockItem("cup", 5.55, 4);
        stockList.addStock(stockItem);

        stockItem = new StockItem("onion", 6.7, 58);
        stockList.addStock(stockItem);

        System.out.println("WELCOME TO SHOPPING BASKET 1.0");
        System.out.println("Enter your name: ");
        Basket basket = new Basket(scanner.nextLine());
        basket.setStockList(stockList);
        instructions();
        boolean quit = false;
        while(!quit) {
            System.out.print("Enter action: "); int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    instructions(); break;
                case 1:
                    System.out.println(stockList); break;
                case 2:
                    System.out.print("Enter the name of the product: ");
                    stockItem = stockList.get(scanner.nextLine());
                    System.out.print("Enter amount: ");
                    basket.addToBasket(stockItem,scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter the name of the product:");
                    stockItem = stockList.get(scanner.nextLine());
                    System.out.print("Enter amount: ");
                    basket.unreserve(stockItem,scanner.nextInt());
                    break;
                case 4:
                    System.out.println(basket); break;
                default:
                    System.out.println(basket);
                    basket.finish();
                    quit = true;
                    break;
            }
        }
    }

    private static void instructions() {
        System.out.println("\nINSTRUCTIONS\n"+
                "0 - Instructions\n"+
                "1 - View items in stock\n"+
                "2 - Add item to your basket\n"+
                "3 - Remove an item from the basket\n"+
                "4 - View basket\n"+
                "5 - End shopping\n");
    }

    private static StockItem nameAndAmount() {
        System.out.print("Enter the name of the product: ");
        stockItem = stockList.get(scanner.nextLine());
        System.out.print("Enter amount: ");
        stockItem.reserve(scanner.nextInt());
        scanner.nextLine();
        return stockItem;
    }
}
