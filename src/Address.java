/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472
 */
public class Address {
    private int intID;
    private String strStreet;
    private int intZip;
    private String strCity;
    private String strState;
    private String strCountry;

    @Override
    public String toString() {
        return "Address{" + "intID=" + intID + ", strStreet=" + strStreet + ", intZip=" + intZip + ", strCity=" + strCity + ", strState=" + strState + ", strCountry=" + strCountry + '}';
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStrStreet() {
        return strStreet;
    }

    public void setStrStreet(String strStreet) {
        this.strStreet = strStreet;
    }

    public int getIntZip() {
        return intZip;
    }

    public void setIntZip(int intZip) {
        this.intZip = intZip;
    }

    public String getStrCity() {
        return strCity;
    }

    public void setStrCity(String strCity) {
        this.strCity = strCity;
    }

    public String getStrState() {
        return strState;
    }

    public void setStrState(String strState) {
        this.strState = strState;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }
}
