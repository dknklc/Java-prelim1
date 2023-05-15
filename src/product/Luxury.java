package product;

public class Luxury extends Product{
    public static final String productType = "Luxury";

    public Luxury(int sellingPrice, int stockAmount){
        super(productType, sellingPrice, stockAmount);
    }

    public char getAbbreviation(){
        return 'L';
    }
}
