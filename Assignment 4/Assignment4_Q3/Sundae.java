package Assignment4.Assignment4_Q3;

class Sundae extends IceCream{
    int toppingCost;
    String toppingName;

    Sundae(String iceCreamName, int iceCreamCost,String toppingName, int toppingCost){
        super(iceCreamName,iceCreamCost);
        this.toppingName = toppingName;
        this.toppingCost =toppingCost;
    }

    public int getCostOfTheTopping(){
        return toppingCost;
    }

    public String getToppingName(){
        return toppingName;

    }

    @Override
    public String toString(){
        String cost = DessertShop.cents2dollarsAndCents(getCost());
        return getToppingName()+" Sundae With"+"\n" + getName() + DessertShop.numberOfSpace(name, cost) + cost +"\n";
    }

    public int getCost() {
        return (iceCreamCost+toppingCost);
    }
}
