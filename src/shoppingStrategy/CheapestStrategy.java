package shoppingStrategy;

import runner.Common;
import entity.Customer;
import entity.Store;

import java.util.ArrayList;
import java.util.List;

public class CheapestStrategy implements IShoppingStrategy {
    public void doShopping(Customer customer, List<Store> stores) {
        if (customer.getShoppingList().getAllProducts().isEmpty()) {
            if (customer.getPosition().getIntX() < Common.getWindowWidth() - customer.getPosition().getIntX()) {
                customer.getPosition().setX(customer.getPosition().getX() - Common.getCustomerMovementSpeed());
            } else {
                customer.getPosition().setX(customer.getPosition().getX() + Common.getCustomerMovementSpeed());
            }
        } else if (customer.getTarget() == null) {
            int cheapest = Integer.MAX_VALUE;
            double dist;
            for (Store s : Common.getStoreList()) {
                if (s.getProduct().getProductType().equals(customer.getShoppingList().getAllProducts().get(0).getProductType()) && s.getProduct().getSellingPrice() < cheapest) {
                    cheapest = s.getProduct().getSellingPrice();
                    customer.setTarget(s);
                }
            }
        } else {
            double targetX = customer.getTarget().getPosition().getX();
            double targetY = customer.getTarget().getPosition().getY();
            double dist = customer.getPosition().distanceTo(targetX, targetY);
            if (dist <= 2 * Common.getEntityDiameter()) {
                try {
                    customer.getTarget().sell();
                    customer.getShoppingList().getAllProducts().remove(0);
                    customer.setTarget(null);
                } catch (IllegalStateException e) {

                }
            } else {
                double x = targetX - customer.getPosition().getX();
                double y = targetY - customer.getPosition().getY();
                if (dist > Common.getCustomerMovementSpeed()) {
                    double vx = x / dist * Common.getCustomerMovementSpeed();
                    double vy = y / dist * Common.getCustomerMovementSpeed();
                    customer.getPosition().setX(customer.getPosition().getX() + vx);
                    customer.getPosition().setY(customer.getPosition().getY() + vy);
                } else {
                    customer.getPosition().setX(x);
                    customer.getPosition().setY(y);
                }
            }


        }
    }
    public String getAbbreviation() {
        return "Ch";
    }
}
