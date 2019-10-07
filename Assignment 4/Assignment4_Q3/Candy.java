package Assignment4.Assignment4_Q3;

class Candy extends DessertItem{
    double weight;
    int pricePerPound;

    public Candy(String name,double weight,int pricePerPound){
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public double getWeight(){
        return weight;
    }


    public int getAPricePerPound(){
        return pricePerPound;
    }

    public int getCost() {
       return (int)Math.round(weight * pricePerPound);
    }

    @Override
    public String toString(){
        String cost = DessertShop.cents2dollarsAndCents(getCost());
        String perPound=DessertShop.cents2dollarsAndCents(getAPricePerPound());
        return getWeight() + " lbs. @ " + perPound + " /lb.\n" + getName()+DessertShop.numberOfSpace(name, cost)+ cost + "\n";

    }
}

