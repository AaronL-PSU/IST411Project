/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472, alder
 */
public class Supplier {
    private final int supplierID;
    private String supplierName;
    private String contactNumber;

    public Supplier(int supplierID, String supplierName, String contactNumber) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public boolean saveSupplier(){
        return true; //TODO: JDBC SQL connection goes here.
    }
    public static Supplier getSupplier(int id) {
         Supplier supplier = null;
         return supplier; //TODO: JDBC SQL connection goes here.
     }
}
