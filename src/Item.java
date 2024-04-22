
public class Item {
    private int intID;
    private String strItemName;
    private int intQty;
    private int intPrice;
    private int intReorderQty;
    
    public Item(int intID, String strItemName, int intQty, int intPrice, int intReorderQty) {
        this.intID = intID;
        this.strItemName = strItemName;
        this.intQty = intQty;
        this.intPrice = intPrice;
        this.intReorderQty = intReorderQty;
    }

    @Override
    public String toString() {
        return "Item{" + "intID=" + intID + ", strItemName=" + strItemName + ", intQty=" + intQty + ", intPrice=" + intPrice + ", intReorderQty=" + intReorderQty + '}';
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStrItemName() {
        return strItemName;
    }

    public void setStrItemName(String strItemName) {
        this.strItemName = strItemName;
    }

    public int getIntQty() {
        return intQty;
    }

    public void setIntQty(int intQty) {
        this.intQty = intQty;
    }

    public int getIntPrice() {
        return intPrice;
    }

    public void setIntPrice(int intPrice) {
        this.intPrice = intPrice;
    }

    public int getIntReorderQty() {
        return intReorderQty;
    }

    public void setIntReorderQty(int intReorderQty) {
        this.intReorderQty = intReorderQty;
    }
    public boolean saveItem(){
        return true; //JDBC SQL connection goes here.
    }
     public static Item getItem(int id) {
         Item item = null;
         return item; //JDBC SQL connection goes here.
     }
}
