package PZ7;

/**
 * Created by gaara on 4/24/17.
 */
public class Role extends Entity {
    String role;


    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
