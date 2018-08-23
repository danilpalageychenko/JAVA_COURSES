package PZ7;

/**
 * Created by gaara on 4/24/17.
 */
public class Address extends Entity {
    private String Address;

    public Address() {
    }

    public Address(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
