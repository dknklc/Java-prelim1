package entity;

import product.Product;

import java.awt.*;

public class Store extends Entity{
    private Product product;
    private int mainStock;

    public Store(Position position, Product product, int mainStock){
        super(position.getX(), position.getY());
        this.product = product;
        this.mainStock = mainStock;
    }

    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public int getMainStock(){
        return mainStock;
    }
    public void setMainStock(int mainStock){
        this.mainStock = mainStock;
    }

    @Override
    public void draw(Graphics2D g2d) {
        String text = getProduct().getAbbreviation() + ","+String.valueOf(getProduct().getStockAmount())+","+String.valueOf(getProduct().getSellingPrice());
        drawHelper(g2d,text,Color.ORANGE);
    }

    @Override
    public void step() {

    }

    public void sell() throws IllegalStateException{
        if(product.getStockAmount() == 0){
            throw new IllegalStateException("Out of Stock");
        }
        getProduct().setStockAmount(getProduct().getStockAmount() - 1);
    }

    public void replenish() {
        product.setStockAmount(mainStock);
    }
}
