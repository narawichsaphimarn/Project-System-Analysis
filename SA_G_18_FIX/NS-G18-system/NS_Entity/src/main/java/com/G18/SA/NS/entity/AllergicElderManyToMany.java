package com.G18.SA.NS.entity;
import javax.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "AllergicElder")
public class AllergicElderManyToMany {
    @Id
    @SequenceGenerator(name="allergicElder_seq",sequenceName="allergicElder_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="allergicElder_seq")  
    @Column(name="allergicElderManyToManyId",unique = true, nullable = false)
    private long allergicElderManyToManyId;

    public long getAllergicElderManyToManyId() {
        return allergicElderManyToManyId;
    }

    public void setAllergicElderManyToManyId(long allergicElderManyToManyId) {
        this.allergicElderManyToManyId = allergicElderManyToManyId;
    }

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }

    public Allergic getAllergic() {
        return allergic;
    }

    public void setAllergic(Allergic allergic) {
        this.allergic = allergic;
    }

    //Many To One With Elder
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Elder.class)
    @JoinColumn(name = "elderId")
    private Elder elder;

    //Many To One with Allergic
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Allergic.class)
    @JoinColumn(name = "allergicId")
    private Allergic allergic;

    public AllergicElderManyToMany(){}
    public AllergicElderManyToMany(Elder elder,  Allergic allergic){
        this.allergic = allergic;
        this.elder = elder;
    }


}
