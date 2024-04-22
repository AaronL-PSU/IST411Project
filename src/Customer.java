public class Customer extends User {

    private String placeholder;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String toString() {
        // Utilize the inherited fields from the User class in the toString method
        return "Customer{" +
                "intID=" + getIntID() +
                ", strFirstName='" + getStrFirstName() + '\'' +
                ", strLastName='" + getStrLastName() + '\'' +
                ", strUsername='" + getStrUsername() + '\'' +
                ", strPassword='" + getStrPassword() + '\'' +
                ", placeholder='" + placeholder + '\'' +
                '}';
    }
}
