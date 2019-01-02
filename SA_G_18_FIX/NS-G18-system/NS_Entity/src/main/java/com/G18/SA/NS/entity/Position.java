package com.G18.SA.NS.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.*;

@Entity
// @Data
@Table(name="Position")

public class Position {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long positionId;
    private String position;


    public Position (){}
    public Position(String position){
        this.position=position;
    }
    public Position(Long  positionId){
        this.positionId=positionId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
