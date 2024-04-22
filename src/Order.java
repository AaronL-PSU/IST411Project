
import java.util.List;

public class Order {
    private int intOrderID;
    private List<Item> listItems;
    private int intCustomerID;
    
      public Order(int intOrderID, List<Item> listItems, int intCustomerID) {
      this.intOrderID = intOrderID;
      this.listItems = listItems;
      this.intCustomerID = intCustomerID;
      }

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
    
    public boolean createOrder(){
        return true; //JDBC SQL connection goes here
    }
    public static Order getOrder(int id){
        Order order = null; //JDBC SQL connection goes here
        return order;
    }
}
