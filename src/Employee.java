public class Employee extends User {

    private String strRole;

    @Override
    public String toString() {
        return "Employee{" + "strRole=" + strRole + '}';
    }

    public String getStrRole() {
        return strRole;
    }

    public void setStrRole(String strRole) {
        this.strRole = strRole;
    }
}
