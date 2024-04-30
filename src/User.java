public abstract class User {
    
    private int intID;
    private String strFirstName;
    private String strLastName;
    private String strUsername;
    private String strPassword;
    private Address address; //using address and email classes
    private Email email; 
    private String phoneNumber;

    public User(int intID, String strFirstName, String strLastName, String strUsername, String strPassword, Address address, Email email, String phoneNumber) {
        this.intID = intID;
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strUsername = strUsername;
        this.strPassword = strPassword;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone number;
    }
    //getters and setters for everything
    
    public static User getUser(int userId) {
    //TODO: JDBC connection goes here to get user by ID
    return null;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public void getPhoneNumber(String phoneNumber) {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        this.phoneNumber = phoneNumber;
    
    //tostring
    @Override
    public String toString() {
        return "User{" +
               "intID=" + intID +
               ", strFirstName='" + strFirstName + '\'' +
               ", strLastName='" + strLastName + '\'' +
               ", strUsername='" + strUsername + '\'' +
               ", strPassword='" + strPassword + '\'' +
               ", address=" + address +
               ", email=" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
               '}';
    }
}
