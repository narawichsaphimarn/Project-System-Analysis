package com.G18.SA.NS.entity;
import javax.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "RelativeElder")
public class RelativeElderToMany {
    @Id
    @SequenceGenerator(name="relativeElder_seq",sequenceName="relativeElder_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="relativeElder_seq")  
    @Column(name="relativeElderManyToManyId",unique = true, nullable = false)
    private long relativeElderToManyId;


    public long getRelativeElderToManyId() {
        return relativeElderToManyId;
    }

    public void setRelativeElderToManyId(long relativeElderToManyId) {
        this.relativeElderToManyId = relativeElderToManyId;
    }

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    //Many To One With Elder
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Elder.class)
    @JoinColumn(name = "elderId")
    private Elder elder;

    //Many To One with Relative
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Relative.class)
    @JoinColumn(name = "relativeId")
    private Relative relative;

    public RelativeElderToMany(){}
    public RelativeElderToMany(Elder elder,  Relative relative){
        this.relative = relative;
        this.elder = elder;
    }


}