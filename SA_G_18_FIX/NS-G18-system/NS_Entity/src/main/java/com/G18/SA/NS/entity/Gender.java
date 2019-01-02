package com.G18.SA.NS.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
// @Data
@Table ( name = "Gender")
@CrossOrigin(origins = "http://localhost:4200")
public class Gender {
    public Long getGenderId() {
        return genderId;
    }

    public void setGenderd(Long genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")  
    @Column(name="genderId",unique = true, nullable = false)
    private @NonNull Long genderId;
    private @NonNull String genderName;

    public Gender (){

    }
    public Gender (String gender){
        this.genderName = gender;
    }
}
