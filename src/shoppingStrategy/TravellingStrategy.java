package shoppingStrategy;

import entity.Customer;
import entity.Store;
import runner.Common;

import java.util.ArrayList;
import java.util.List;

public class TravellingStrategy implements IShoppingStrategy{

    public void doShopping(Customer customer, List<Store> stores) {
        if (customer.getShoppingList().getAllProducts().isEmpty()) {
            if (customer.getPosition().getIntX() < Common.getWindowWidth() - customer.getPosition().getIntX()) {
                customer.getPosition().setX(customer.getPosition().getX() - Common.getCustomerMovementSpeed());
            } else {
                customer.getPosition().setX(customer.getPosition().getX() + Common.getCustomerMovementSpeed());
            }
        } else if (customer.getTarget() == null) {
            int cheapest = Integer.MAX_VALUE;
            double closest = Double.POSITIVE_INFINITY;
            double dist;

            for (Store s : Common.getStoreList()) {
                if (!customer.getVisited().contains(s)) {
                    dist = customer.getPosition().distanceTo(s.getPosition().getX(), s.getPosition().getY());
                    if (dist < closest) {
                        closest = dist;
                        customer.setTarget(s);
                    }
                }
            }
            if (closest == Double.POSITIVE_INFINITY) {
                customer.setVisited(new ArrayList<Store>());
            }
        } else {
            double targetX = customer.getTarget().getPosition().getX();
            double targetY = customer.getTarget().getPosition().getY();
            double dist = customer.getPosition().distanceTo(targetX, targetY);
            if (dist <= 2 * Common.getEntityDiameter()) {
                int index = customer.getShoppingList().getAllProducts().indexOf(customer.getTarget().getProduct());
                if (index != -1) {
                    try {
                        customer.getTarget().sell();
                        customer.getShoppingList().getAllProducts().remove(index);
                    } catch (IllegalStateException e) {
                        customer.getVisited().add(customer.getTarget());
                        customer.setTarget(null);
                    }
                } else {
                    customer.getVisited().add(customer.getTarget());
                    customer.setTarget(null);
                }
            }
            else {
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

    public String getAbbreviation(){
        return "Tr";
    }
}
