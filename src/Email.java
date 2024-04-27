public class Email {
    private int intID;
    private String address;

    @Override
    public String toString() {
        return "Email{" + "intID=" + intID + ", address=" + address + '}';
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
