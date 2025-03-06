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
    String created_date;
    String name;
    String dob;
    String current_address;
    String perm_address;
    String pan_number;
    String email;
    String mobile_number;
    String updated_date;

    public BankUser() {
    }

    public BankUser(long id, String created_date, String name, String dob, String current_address, String perm_address, String pan_number, String email, String mobile_number, String updated_date) {
        this.id = id;
        this.created_date = created_date;
        this.name = name;
        this.dob = dob;
        this.current_address = current_address;
        this.perm_address = perm_address;
        this.pan_number = pan_number;
        this.email = email;
        this.mobile_number = mobile_number;
        this.updated_date = updated_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }
}