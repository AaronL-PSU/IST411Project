public abstract class User {

    private int intID;

    private String strFirstName;

    private String strLastName;

    private String strUsername;

    private String strPassword;

    public int getIntID() {
        return intID;
    }

    @Override
    public String toString() {
        return "User{" + "intID=" + intID + ", strFirstName=" + strFirstName + ", strLastName=" + strLastName + ", strUsername=" + strUsername + ", strPassword=" + strPassword + '}';
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
}
