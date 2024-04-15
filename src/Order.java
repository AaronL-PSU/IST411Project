
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472
 */
public class Order {
    private int intOrderID;
    private List<Item> listItems;
    private int intCustomerID;

    @Override
    public String toString() {
        return "Order{" + "intOrderID=" + intOrderID + ", listItems=" + listItems + ", intCustomerID=" + intCustomerID + '}';
    }

    public int getIntOrderID() {
        return intOrderID;
    }

    public void setIntOrderID(int intOrderID) {
        this.intOrderID = intOrderID;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public int getIntCustomerID() {
        return intCustomerID;
    }

    public void setIntCustomerID(int intCustomerID) {
        this.intCustomerID = intCustomerID;
    }
}
