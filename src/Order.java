import java.util.List;

public class Order {
    private int intOrderID;
    private List<Item> listItems;
    private int intCustomerID;
    private String orderStatus;
    
    public Order(int intOrderID, List<Item> listItems, int intCustomerID, String orderStatus) {
        this.intOrderID = intOrderID;
        this.listItems = listItems;
        this.intCustomerID = intCustomerID;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "intOrderID=" + intOrderID +
                ", listItems=" + listItems +
                ", intCustomerID=" + intCustomerID +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean createOrder(){
        return true; //JDBC SQL connection goes here
    }

    public static Order getOrder(int id){
        Order order = null; //JDBC SQL connection goes here
        return order;
    }
}
