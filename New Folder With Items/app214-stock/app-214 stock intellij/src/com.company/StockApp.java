package com.company;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;

    private StockList stock;

    //public Product product;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();

        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getString("Please enter your choice > ");

            finished = executeChoice(choice.toLowerCase());
        }
    }

    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals("buy"))
        {
            buyProducts();
        }
        else if(choice.equals("sell"))
        {
            sellProducts();
        }
        else if(choice.equals("search"))
        {
            searchProducts();
        }
        else if(choice.equals("low stock"))
        {
            System.out.println("Printing the list of products with low stock ( <5) ");
            stock.lowstock();
        }
        else if(choice.equals("re-stock"))
        {
            System.out.println("Re-stocking a Product(s) whose stock is low ");
            int qty  = reader.getInt("Please enter the amount you want to re-stock >");
            stock.restock(qty);
        }

        return false;
    }

    private void addProduct()
    {
        System.out.println("Adding a new Product");
        System.out.println();

        int id = reader.getInt("Please enter a product ID: > ");
        String name = reader.getString("Please enter a product name: > ");

        Product product = new Product(id,name);
        stock.add(product);
        System.out.println("Product " + product.getID() + " --- " + product.getName()
                + " has been added to the list ");
        stock.print();
    }

    private void removeProduct()
    {
        System.out.println("Removing an old Product");
        System.out.println();

        int id = reader.getInt("Please enter a product ID > ");
        Product product = stock.findProduct(id);

        if(product != null)
        {
            stock.removeproduct(id);
            System.out.println("Product has been removed from the list ");
        }
        else
        {
            System.out.println ("This product number not exist !");
        }
        stock.print();
    }

    private void buyProducts()
    {
        System.out.println("Buying a Product(s)");
        System.out.println();
        stock.print();

        int id = reader.getInt("Please enter a product ID that you want to buy: > ");
        int amount = reader.getInt("Please enter the amount that you want to buy: > ");
        Product product = stock.findProduct(id);
        stock.buyProduct(id,amount);
        System.out.println ("Product " + product.getID() + " --- " + product.getName()
                + "has been bought -- Quantity: " + amount );
        stock.print();
    }

    private void sellProducts()
    {
        System.out.println("Buying a Product(s)");
        System.out.println();
        stock.print();

        int id = reader.getInt("Please enter a product ID that you want to sell: > ");
        int amount = reader.getInt("Please enter the amount that you want to sell: > ");
        Product product = stock.findProduct(id);
        stock.sellProduct(id,amount);
        System.out.println ("Product " + product.getID() + " --- " + product.getName()
                + "has been sold -- Quantity: " + amount );
        stock.print();
    }

    private void searchProducts()
    {
        System.out.println("Searching a Product(s) by name or phrase");
        System.out.println();
        System.out.println ("Here is product(s) contains this phrase");

        String phrase = reader.getString("Please enter a phrase,the products you are looking for  > ");

        stock.search(phrase);

    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println("    Buy:        Buy the product(s)");
        System.out.println("    Sell:       Sell the product(s)");
        System.out.println("    Search:     Search the product(s) by name ");
        System.out.println("    Low Stock:  Print the list of products whose stock are low");
        System.out.println("    Re-Stock:   Re-Stock the product(s) whose stock are low");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("           by Samuel          ");
        System.out.println("********************************");
    }
}