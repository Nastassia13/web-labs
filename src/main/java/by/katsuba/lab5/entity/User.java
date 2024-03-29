package by.katsuba.lab5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;

    public User() {

    }

    public User(String login, String password, String type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
