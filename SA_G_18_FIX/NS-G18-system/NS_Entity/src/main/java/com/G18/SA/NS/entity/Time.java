package com.G18.SA.NS.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="Time")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Time {
    @Id
    @SequenceGenerator(name="time_seq",sequenceName="time_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="time_seq")
    @Column(name="time_Id",unique = true, nullable = false)

    private @NonNull Long idTime;
    private @NonNull String time;

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
