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
@Table(name="KindActivity")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class KindActivity {
    @Id
    @SequenceGenerator(name="KindActivity_seq",sequenceName="KindActivity_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KindActivity_seq")
    @Column(name="KindActivity_Id",unique = true, nullable = false)

    private @NonNull Long idKind;
    private @NonNull String kindActivity;


 /*   @OneToMany(
            mappedBy="kindActivity", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Activity> Activity = new ArrayList<>();
    */



    public Long getIdKind() {

        return idKind;
    }

    public void setIdKind(Long idKind) {

        this.idKind = idKind;
    }

    public String getKindActivity() {

        return kindActivity;
    }

    public void setKindActivity(String kindActivity) {
        this.kindActivity = kindActivity;
    }
}
