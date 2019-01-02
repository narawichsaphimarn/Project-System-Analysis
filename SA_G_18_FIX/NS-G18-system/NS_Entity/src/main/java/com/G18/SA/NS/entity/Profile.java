package com.G18.SA.NS.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
// @Data
@EqualsAndHashCode
@Table(name="Profile")
public class Profile{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long   profileId;

    private  String firstName;
    private  String lastName; 
    
    private   String identificationNumber;
    private   String email;
    private   String phone;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationnumber() {
        return identificationNumber;
    }

    public void setIdentificationnumber(String identificationnumber) {
        this.identificationNumber = identificationnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Titlename getTitlename() {
        return titlename;
    }

    public void setTitlename(Titlename titlename) {
        this.titlename = titlename;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public StatusMarital getStatusMarital() {
        return statusMarital;
    }

    public void setStatusMarital(StatusMarital statusMarital) {
        this.statusMarital = statusMarital;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne()
    @JoinColumn(name= "titlenameId")
    private Titlename titlename;

    @ManyToOne()
    @JoinColumn(name= "genderId")
    private Gender gender ;
    
    @ManyToOne()
    @JoinColumn(name= "statusMaritalId")
    private StatusMarital statusMarital;
    
    @ManyToOne()
    @JoinColumn(name= "nationalityId")
    private Nationality nationality;

    @ManyToOne()
    @JoinColumn(name= "ethnicityId")
    private Ethnicity ethnicity;

    @ManyToOne()
    @JoinColumn(name= "religionId")
    private Religion religion;

    @ManyToOne()
    @JoinColumn(name= "positionId")
    private Position position;


    public  Profile(){ }
}
