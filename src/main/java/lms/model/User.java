package lms.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "User")
public class User {

    @Id
    @Column(name="regNo", nullable = false)
    private String regNo;

    @Column(name="emailId", nullable = false)
    private String emailId;

    @Column(name="password", nullable = false)
    private String password;

    public User() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
