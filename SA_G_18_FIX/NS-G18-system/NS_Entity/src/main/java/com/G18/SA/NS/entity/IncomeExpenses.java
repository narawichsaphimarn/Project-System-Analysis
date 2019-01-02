package com.G18.SA.NS.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class IncomeExpenses {
    @Id
    @SequenceGenerator(name="IncomeExpenses_seq",sequenceName="IncomeExpenses_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IncomeExpenses_seq")
    @Column(name="idIncomeExpenses",unique = true, nullable = false)
    private @NonNull Long idIncomeExpenses;
    private @NonNull String incomeExpenses;

    /*@ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "id_account")      // join colume video_id จาก video กับ entity comment
    private AccountRecord accountrecord;*/

    public Long getIdIncomeExpenses() {
        return idIncomeExpenses;
    }

    public void setIdIncomeExpenses(Long idIncomeExpenses) {
        this.idIncomeExpenses = idIncomeExpenses;
    }

    public String getIncomeExpenses() {
        return incomeExpenses;
    }

    public void setIncomeExpenses(String incomeExpenses) {
        this.incomeExpenses = incomeExpenses;
    }


}
