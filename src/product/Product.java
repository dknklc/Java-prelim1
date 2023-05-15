package product;

public abstract class Product {
    protected String productType;
    protected int sellingPrice;
    protected int stockAmount;

    public Product(String productType, int sellingPrice, int stockAmount){
        this.productType = productType;
        this.sellingPrice = sellingPrice;
        this.stockAmount = stockAmount;
    }

    public String getProductType(){
        return productType;
    }
    public void setProductType(String productType){
        this.productType = productType;
    }
    public int getSellingPrice(){
        return sellingPrice;
    }
    public void setSellingPrice(int sellingPrice){
        this.sellingPrice = sellingPrice;
    }
    public int getStockAmount(){
        return stockAmount;
    }
    public void setStockAmount(int stockAmount){
        this.stockAmount = stockAmount;
    }

    public abstract char getAbbreviation();



}
