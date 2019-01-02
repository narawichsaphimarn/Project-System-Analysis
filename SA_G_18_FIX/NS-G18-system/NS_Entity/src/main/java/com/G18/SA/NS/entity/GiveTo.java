package com.G18.SA.NS.entity;
import javax.persistence.*;
// import javax.persistence.*;
// import javax.persistence.GenerationType;
import java.util.*;
import lombok.*;

@Entity
@Getter @Setter
// @NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class  GiveTo{
    @Id
    @SequenceGenerator(name="giveto_seq",sequenceName="giveto_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="giveto_seq")
    @Column(name="idgiveto",unique = true, nullable = false)
    private @NonNull Long idGiveTo;
    private @NonNull String giveTo;

    public GiveTo(){}
    public  GiveTo(String GiveTo){ this.giveTo = GiveTo;    }

    public Long getIdGiveTo() {
        return idGiveTo;
    }

    public void setIdGiveTo(Long idgiveto) {
        this.idGiveTo = idgiveto;
    }

    public String getGiveTo() {
        return giveTo;
    }

    public void setGiveTo(String giveTo) {
       this.giveTo = giveTo;
    }


}
