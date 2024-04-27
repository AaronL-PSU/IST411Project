public class Employee extends User {
    private int employeeID;
    private Role role; 
    private double salary;

    public Employee(int intID, String strFirstName, String strLastName, String strUsername, String strPassword, Address address, Email email, int employeeID, Role role, double salary) {
        super(intID, strFirstName, strLastName, strUsername, strPassword, address, email);
        this.employeeID = employeeID;
        this.role = role;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", role=" + role +
                ", salary=" + salary +
                ", intID=" + getIntID() +
                ", strFirstName='" + getStrFirstName() + '\'' +
                ", strLastName='" + getStrLastName() + '\'' +
                ", strUsername='" + getStrUsername() + '\'' +
                ", strPassword='" + getStrPassword() + '\'' +
                ", address=" + getAddress().toString() +
                ", email=" + getEmail().toString() +
                '}';
    }
}
