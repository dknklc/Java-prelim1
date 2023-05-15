package product;

public class Electronics extends Product{
    public static final String productType = "Electronics";

    public Electronics(int sellingPrice, int stockAmount){
        super(productType, sellingPrice, stockAmount);
    }

    public char getAbbreviation(){
        return 'E';
    }
}
