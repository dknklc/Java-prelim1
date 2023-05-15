package product;

public class Food extends Product{
    private static final String productType = "Food";

    public Food(int sellingPrice, int stockAmount){
        super(productType, sellingPrice, stockAmount);
    }

    public char getAbbreviation(){
        return 'F';
    }
}
