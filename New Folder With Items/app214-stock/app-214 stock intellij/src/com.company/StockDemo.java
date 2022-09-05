package com.company;

import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    private Random generator = new Random();


    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */

    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Gears of War"));
        stock.add(new Product(102, "Battlefield 2042"));
        stock.add(new Product(104, "Fifa 22"));
        stock.add(new Product(105, "Farcry 6"));
        stock.add(new Product(106, "God of War Ragnarök"));
        stock.add(new Product(107, "Grand theft Auto:The Triolgy"));
        stock.add(new Product(108, "Elden Ring"));
        stock.add(new Product(109, "Call of Duty: Vanguard"));
        stock.add(new Product(110, "Final Fantasy XIV: Endwalker"));


        runDemo();
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.

        stock.print();

        buyProducts();
        stock.print();

        sellProducts();
        stock.print();
    }

    /**
     * This method will buy different quqntities of each of the product
     * in the stock list
     */
    private void buyProducts()
    {
        Product product;
        int quantity =1;

        for (int id= 100;  id <= 109; id++)
        {
            product= stock.findProduct(id);
            if(product == null)
            {
                System.out.println ("Product" + id + "Not Found");
            }
            else
            {
                quantity = generator.nextInt(10);
                stock.buyProduct(id,quantity);
            }
        }
    }

    /**
     * This method will sell different quqntities of each of the product
     * in the stock list
     */private void sellProducts()
    {
        Product product;
        int quantity =1;

        for (int id= 100;  id <= 109; id++)
        {
            product= stock.findProduct(id);
            if(product == null)
            {
                System.out.println ("Product" + id + "Not Found");
            }
            else
            {
                quantity = generator.nextInt(10);
                stock.sellProduct(id,quantity);
            }
        }
    }
}