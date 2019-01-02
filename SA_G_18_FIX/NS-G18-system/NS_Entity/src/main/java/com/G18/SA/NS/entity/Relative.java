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
@Table ( name = "Relative")

public class Relative {
    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeLastName() {
        return relativeLastName;
    }

    public void setRelativeLastName(String relativeLastName) {
        this.relativeLastName = relativeLastName;
    }

    public String getRelativeStatus() {
        return relativeStatus;
    }

    public void setRelativeStatus(String relativeStatus) {
        this.relativeStatus = relativeStatus;
    }

    public Long getRelativePersonalId() {
        return relativePersonalId;
    }

    public void setRelativePersonalId(Long relativePersonalId) {
        this.relativePersonalId = relativePersonalId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getRoadLane() {
        return roadLane;
    }

    public void setRoadLane(String roadLane) {
        this.roadLane = roadLane;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Id
    @GeneratedValue
    private @NonNull Long relativeId;
    private @NonNull String relativeName;
    private @NonNull String relativeLastName;
    private @NonNull String relativeStatus;
    private @NonNull Long relativePersonalId;
    private @NonNull String houseNo;
    private @NonNull String roadLane;
    private @NonNull String subDistrict;
    private @NonNull String district;
    private @NonNull int postalCode;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ProvinceEntity.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "provinceId")      // join colume video_id จาก video กับ entity comment
    private ProvinceEntity province;

    public Relative(){
    }

    public Relative(String relativeName, String relativeLastName, String relativeStatus, Long relativePersonalId,
                    String houseNo,String roadLane, String subDistrict, String district, ProvinceEntity province, int postalCode){
        this.relativeName = relativeName;
        this.relativeLastName = relativeLastName;
        this.relativeStatus = relativeStatus;
        this.relativePersonalId = relativePersonalId;
        this.houseNo = houseNo;
        this.roadLane = roadLane;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
        this.postalCode = postalCode;
    }
}
