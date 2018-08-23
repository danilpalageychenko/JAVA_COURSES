package PZ3;

/**
 * Created by gaara on 12.08.16.
 */
public class User {
    Rights right;
    String Login;
    static int id = 0;
    String passHash;
    String email;
    String name;
    String surname;
    String lastname;

    public User(String login, String passHash, String email,Rights right) {
        id++;
        setRight(right);
        setLogin(login);
        setPassHash(passHash);
        setEmail(email);
    }

    public Rights getRight() {
        return right;
    }

    public void setRight(Rights right) {
        this.right = right;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public int getId() {
        return id;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
