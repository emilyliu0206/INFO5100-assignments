package Assignment4.Assignment4_Q3;

class IceCream extends DessertItem{
    public int iceCreamCost;
    IceCream(String name, int cost){
        super(name);
        this.iceCreamCost = cost;
    }


    public int getCost() {
        return iceCreamCost;
    }


    public int getCostOfIceCream(){
        return iceCreamCost;
    }


    @Override
    public String toString(){
        String cost = DessertShop.cents2dollarsAndCents(getCost());
        return getName()+ DessertShop.numberOfSpace(name, cost)+ cost +"\n";
    }

}
