package Assignment4.Assignment4_Q3;

class DessertShop {
    final static double taxRate = 0.101;
    final static String storeName = "M & M Dessert Shop";
    private int maximumSizeOfAnItemName;
    public static final int width = 10;

    public static String cents2dollarsAndCents(int cost) {
        int cents = cost % 100;
        int dollars = (cost - cents) / 100;

        String result = "";
        if (dollars > 0) {
            result += dollars;
        }
        if (cents <= 9) {
            result += ".0" + cents;
        } else {
            result += "." + cents;
        }
        return result;
    }

    public static String numberOfSpace(String name, String cost) {
        int numberSpace = width - name.length() - cost.length();
        String space = "";
        for (int i = 0; i < numberSpace; i++) {
            space += " ";
        }

        return space;
    }
}
