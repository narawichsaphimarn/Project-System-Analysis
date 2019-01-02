package com.G18.SA.NS.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "Login")
public class Login {
    @Id
    @SequenceGenerator(name="login_seq",sequenceName="login_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login_seq")
    @Column(name="loginID",unique = true, nullable = false)

    private @NonNull Long loginID;
    private String  loginName;
    private Long  loginPassword;

    public Login(){}
    public Login(String loginName,Long loginPassword){
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(Long loginPassword) {
        this.loginPassword = loginPassword;
    }
}
