package com.G18.SA.NS.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table ( name = "Allergic")

public class Allergic {

    public Long getAllergicId() {
        return allergicId;
    }

    public void setAllergicId(Long allergicId) {
        this.allergicId = allergicId;
    }

    public String getAllergicName() {
        return allergicName;
    }

    public void setAllergicName(String allergicName) {
        this.allergicName = allergicName;
    }

    @Id
    @SequenceGenerator(name="allergic_seq",sequenceName="allergic_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="allergic_seq")  
    @Column(name="allergicId",unique = true, nullable = false)
    private @NonNull Long allergicId;
    private @NonNull String allergicName;

    public Allergic(){

    }

    public Allergic(String allergicName ){
        this.allergicName = allergicName;
    }
}
