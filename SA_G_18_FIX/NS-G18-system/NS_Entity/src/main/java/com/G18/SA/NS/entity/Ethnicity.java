package com.G18.SA.NS.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.*;
@Entity
// @Data
@Table(name="Ethnicity")
public class Ethnicity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long ethnicityId;
    private String ethnicity;
    

    public  Ethnicity(){}
    public Ethnicity(String ethnicity) {
        this.ethnicity=ethnicity;
    }
    public Ethnicity(Long  ethnicityId){
        this.ethnicityId=ethnicityId;
    }

    public Long getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Long ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
}

 