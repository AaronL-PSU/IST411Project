/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472
 */
public class Item {
    private int intID;
    private String strItemName;
    private int intQty;
    private int intPrice;
    private int intReorderQty;

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
}
