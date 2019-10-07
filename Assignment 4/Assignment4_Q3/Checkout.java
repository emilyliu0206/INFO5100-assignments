package Assignment4.Assignment4_Q3;
import java.util.*;

public class Checkout{
    LinkedList<DessertItem> DessertItemList;
    int totalCost;
    int totalTax;

    public Checkout(){
        this.DessertItemList = new LinkedList<DessertItem>();
    }

    public int numberOfItems(){
        return this.DessertItemList.size();
    }


    public void enterItem(DessertItem item){
        DessertItemList.add(item);
    }


    public void clear(){
        DessertItemList.clear();
    }


    public int totalCost(){
        totalCost = 0;
        for (DessertItem dessertItem : DessertItemList){
            int cost = dessertItem.getCost();
            totalCost = totalCost + cost;
        }
        return totalCost;
    }


    public int totalTax(){
        totalTax = (int)Math.round(DessertShop.taxRate*totalCost);
        return totalTax;
    }

    @Override
    public String toString(){

        String shopName= DessertShop.storeName;
        String line="-------------------";
        int costWithTax= totalCost()+totalTax();
        String totalTax= DessertShop.cents2dollarsAndCents(totalTax());
        String totalCost= DessertShop.cents2dollarsAndCents(costWithTax);
        String itemsPurchased = "";
        for (DessertItem eachItem:DessertItemList){
            itemsPurchased += eachItem.toString();
        }
        String receipt= shopName + "\n"+ line + "\n"+ itemsPurchased + "tax" +
                DessertShop.numberOfSpace("tax", totalTax)+totalTax + "\n" +
                "Total Cost"+DessertShop.numberOfSpace("Total Cost", totalCost)+totalCost + "\n";
        return receipt;
    }

}




