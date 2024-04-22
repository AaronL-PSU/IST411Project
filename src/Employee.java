public class Employee extends User {

    private int employeeID;
    private String position;
    private double salary;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", intID=" + getIntID() +
                ", strFirstName='" + getStrFirstName() + '\'' +
                ", strLastName='" + getStrLastName() + '\'' +
                ", strUsername='" + getStrUsername() + '\'' +
                ", strPassword='" + getStrPassword() + '\'' +
                '}';
    }
}
