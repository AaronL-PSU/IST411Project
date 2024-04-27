public class Role {

    private int intID;         
    private String strShortName; 
    private String strLongName; 

    public Role(int intID, String strShortName, String strLongName) {
        this.intID = intID;
        this.strShortName = strShortName;
        this.strLongName = strLongName;
    }

    @Override
    public String toString() {
        return "Role{" +
               "intID=" + intID +
               ", strShortName='" + strShortName + '\'' +
               ", strLongName='" + strLongName + '\'' +
               '}';
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStrShortName() {
        return strShortName;
    }

    public void setStrShortName(String strShortName) {
        this.strShortName = strShortName;
    }

    public String getStrLongName() {
        return strLongName;
    }

    public void setStrLongName(String strLongName) {
        this.strLongName = strLongName;
    }
}
