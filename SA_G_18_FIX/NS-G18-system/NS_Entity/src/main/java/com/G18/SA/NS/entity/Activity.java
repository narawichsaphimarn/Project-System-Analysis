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
@Table(name="Activity")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Activity {
    @Id
    @SequenceGenerator(name="Activity_seq",sequenceName="Activity_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Activity_seq")
    @Column(name="Activity_Id",unique = true, nullable = false)

    private @NonNull Long idActivity;
    private @NonNull String nameActivity;
    private @NonNull Integer people;
    private @NonNull Date day;


  /*  @OneToMany(
            mappedBy="activity", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Gender> Gender = new ArrayList<>();
*/


    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "genderId")      // join colume video_id จาก video กับ entity comment
    private Gender gender;

    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idKind")      // join colume video_id จาก video กับ entity comment
    private KindActivity kindActivity;

    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idRoom")      // join colume video_id จาก video กับ entity comment
    private Room room;

    @ManyToOne
    @JoinColumn(name= "idAge")
    private  Age age;

    @ManyToOne
    @JoinColumn(name= "idTime")
    private  Time time;



    public Long getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Long idActivity) {
        this.idActivity = idActivity;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity)
    {
        this.nameActivity = nameActivity;
    }


    public Integer getPeople() {

        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public KindActivity getKindActivity() {
        return kindActivity;
    }

    public void setKindActivity(KindActivity kindActivity) {
        this.kindActivity = kindActivity;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}

