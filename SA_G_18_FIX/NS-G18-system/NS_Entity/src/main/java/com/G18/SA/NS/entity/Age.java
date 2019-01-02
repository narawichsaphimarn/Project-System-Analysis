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
@Table(name="Age")
@ToString
@Getter @Setter
@EqualsAndHashCode

public class Age {
    @Id
    @SequenceGenerator(name="age_seq",sequenceName="age_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="age_seq")
    @Column(name="age_Id",unique = true, nullable = false)

    private @NonNull Long idAge;
    private @NonNull String age;

    public Long getIdAge() {
        return idAge;
    }

    public void setIdAge(Long idAge) {
        this.idAge = idAge;
    }

    public String getAge() {
        return age;
    }
    public Age(){}
    public void setAge(String age) {
        this.age = age;
    }
}

