package entity;

import runner.Common;
import shoppingList.IShoppingList;
import shoppingStrategy.IShoppingStrategy;

import java.awt.*;
import java.util.ArrayList;

public class Customer extends Entity {
    private IShoppingList shoppingList;
    private IShoppingStrategy shoppingStrategy;
    private Store target;
    private ArrayList<Store> visited;

    public Customer(Position position, IShoppingList shoppingList, IShoppingStrategy shoppingStrategy){
        super(position.getX(), position.getY());
        this.shoppingList = shoppingList;
        this.shoppingStrategy = shoppingStrategy;
        target = null;
        visited = new ArrayList<Store>();
    }

    public IShoppingList getShoppingList(){
        return shoppingList;
    }

    public IShoppingStrategy getShoppingStrategy(){
        return shoppingStrategy;
    }

    public Store getTarget(){
        return target;
    }

    public void setTarget(Store target){
        this.target = target;
    }

    public ArrayList<Store> getVisited(){
        return visited;
    }

    public void setVisited(ArrayList<Store> visited){
        this.visited = visited;
    }

    @Override
    public void draw(Graphics2D g2d) {
        String text = shoppingStrategy.getAbbreviation();

        for (int i = 0; i < 3; i++) {
            try {
                text += "," + shoppingList.getAllProducts().get(i).getAbbreviation();
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        drawHelper(g2d,text,Color.GRAY);
    }

    @Override
    public void step() {
        shoppingStrategy.doShopping(this, Common.getStoreList());
    }
}
