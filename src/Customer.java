public class Customer extends User {
    private String customerCardNumber; //store brand credit card, like a Target red card or something

    public Customer(int intID, String strFirstName, String strLastName, String strUsername, String strPassword, Address address, Email email, String customerCardNumber) {
        super(intID, strFirstName, strLastName, strUsername, strPassword, address, email);
        this.customerCardNumber = customerCardNumber;
    }

    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public void setAddress(Address address) {
        super.setAddress(address);
    }
}
