package com.G18.SA.NS.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table ( name = "Elder")

public class  Elder {

    public Long getElderId() {
        return elderId;
    }

    public void setElderId(Long elderId) {
        this.elderId = elderId;
    }

    public String getElderName() {
        return elderName;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public String getElderLastName() {
        return elderLastName;
    }

    public void setElderLastName(String elderLastName) {
        this.elderLastName = elderLastName;
    }

    public Long getElderPersonalId() {
        return elderPersonalId;
    }

    public void setElderPersonalId(Long elderPersonalId) {
        this.elderPersonalId = elderPersonalId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCongenitalDisease() {
        return congenitalDisease;
    }

    public void setCongenitalDisease(String congenitalDisease) {
        this.congenitalDisease = congenitalDisease;
    }

    public StatusMarital getStatusMarital() {
        return statusMarital;
    }

    public void setStatusMarital(StatusMarital statusMarital) {
        this.statusMarital = statusMarital;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Id
    @SequenceGenerator(name="elder_seq",sequenceName="elder_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="elder_seq")  
    @Column(name="elderId",unique = true, nullable = false)
    private @NonNull Long elderId;
    private @NonNull String elderName;
    private @NonNull String elderLastName;
    private @NonNull Long elderPersonalId;
    private @NonNull Date birthDate;
    private @NonNull String congenitalDisease;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = StatusMarital.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "statusMaritalId")      // join colume video_id จาก video กับ entity comment
    private StatusMarital statusMarital;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Gender.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "genderId")      // join colume video_id จาก video กับ entity comment
    private Gender gender;
    public Elder(){
    }
    public Elder(String elderName, String elderLastName, Gender gender, Long elderPersonalId, Date birthDate, String congenitalDisease,StatusMarital statusMarital){
        this.elderName = elderName;
        this.elderLastName = elderLastName;
        this.gender = gender;
        this.elderPersonalId = elderPersonalId;
        this.birthDate = birthDate;
        this.congenitalDisease = congenitalDisease;
        this.statusMarital = statusMarital;

    }
}
