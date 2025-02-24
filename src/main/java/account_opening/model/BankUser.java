package account_opening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankUser {
    @Id
    @GeneratedValue
    @Column(name = "account_number")
    long id;
    String name;
    String current_address;
    String perm_address;
    String pan_number;
    String email;

    public BankUser() {
    }

    public BankUser(long id, String name, String current_address, String perm_address, String PAN_number, String email) {
        this.id = id;
        this.name = name;
        this.current_address = current_address;
        this.perm_address = perm_address;
        this.pan_number = PAN_number;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getPerm_address() {
        return perm_address;
    }

    public void setPerm_address(String perm_address) {
        this.perm_address = perm_address;
    }

    public String getPan_number() {
        return pan_number;
    }

    public void setPan_number(String pan_number) {
        this.pan_number = pan_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}