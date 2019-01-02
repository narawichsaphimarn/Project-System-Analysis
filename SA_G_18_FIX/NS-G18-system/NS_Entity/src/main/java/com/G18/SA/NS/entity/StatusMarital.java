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
@Table ( name = "StatusMarital")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusMarital {
    public Long getStatusMaritalId() {
        return statusMaritalId;
    }

    public void setStatusMaritalId(Long statusMaritalId) {
        this.statusMaritalId = statusMaritalId;
    }

    public String getStatusMaritalName() {
        return statusMaritalName;
    }

    public void setStatusMaritalName(String statusMaritalName) {
        this.statusMaritalName = statusMaritalName;
    }

    @Id
    @SequenceGenerator(name="statusMarital_seq",sequenceName="statusMarital_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="statusMarital_seq")  
    @Column(name="statusMaritalId",unique = true, nullable = false)
    private @NonNull Long statusMaritalId;
    private @NonNull String statusMaritalName;


    public StatusMarital (){

    }
    public StatusMarital (String statusMaritalName){
        this.statusMaritalName = statusMaritalName;
    }
    
}
