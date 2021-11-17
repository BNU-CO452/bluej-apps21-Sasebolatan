
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
    
    private void buyProducts()
    {
        stock.buyProduct(101,800);
        stock.buyProduct(102,900);
        stock.buyProduct(103,1000);
        stock.buyProduct(104,400);
        stock.buyProduct(105,300);
        stock.buyProduct(106,1400);
        stock.buyProduct(107,2500);
        stock.buyProduct(108,400);
        stock.buyProduct(109,2000);
        stock.buyProduct(110,300);
    }

    private void sellProducts()
    {
        stock.sellProduct(101,700);
        stock.sellProduct(102,200);
        stock.sellProduct(103,200);
        stock.sellProduct(104,100);
        stock.sellProduct(105,300);
        stock.sellProduct(106,200);
        stock.sellProduct(107,100);
        stock.sellProduct(108,150);
        stock.sellProduct(109,150);
        stock.sellProduct(110,150);
    }    
}