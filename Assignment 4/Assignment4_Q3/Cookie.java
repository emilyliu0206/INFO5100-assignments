package Assignment4.Assignment4_Q3;

class Cookie extends DessertItem {
    int number;
    int pricePerDozen;

    Cookie(String name,int number,int pricePerDozen){
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getNumber(){
        return number;
    }

    public int getAPricePerDozen(){
        return pricePerDozen;
    }

    @Override
    public String toString(){
        String cost = DessertShop.cents2dollarsAndCents(getCost());
        String perDozen=DessertShop.cents2dollarsAndCents(getAPricePerDozen());
        return getNumber()+" @ "+ perDozen+ " /dz. \n" + getName()+ DessertShop.numberOfSpace(name, cost)+ cost +"\n";
    }

    public int getCost() {
        return (int)Math.round(number * pricePerDozen / 12);

    }

}
