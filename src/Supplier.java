/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472
 */
public class Supplier {
    private int intSupplierID;
    private String strSupplierName;
    private int intContactNum;

    @Override
    public String toString() {
        return "Supplier{" + "intSupplierID=" + intSupplierID + ", strSupplierName=" + strSupplierName + ", intContactNum=" + intContactNum + '}';
    }

    public int getIntSupplierID() {
        return intSupplierID;
    }

    public void setIntSupplierID(int intSupplierID) {
        this.intSupplierID = intSupplierID;
    }

    public String getStrSupplierName() {
        return strSupplierName;
    }

    public void setStrSupplierName(String strSupplierName) {
        this.strSupplierName = strSupplierName;
    }

    public int getIntContactNum() {
        return intContactNum;
    }

    public void setIntContactNum(int intContactNum) {
        this.intContactNum = intContactNum;
    }
}
