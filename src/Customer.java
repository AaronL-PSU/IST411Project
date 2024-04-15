public class Customer extends User{

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String toString() {
        return "Customer{" + "placeholder=" + placeholder + '}';
    }

    private String placeholder;
}
