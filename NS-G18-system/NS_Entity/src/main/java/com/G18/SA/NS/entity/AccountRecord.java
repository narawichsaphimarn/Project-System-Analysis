
package com.G18.SA.NS.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountRecord {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="account_seq",sequenceName="account_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
    @Column(name="idaccount",unique = true, nullable = false)
    private @NonNull Long idaccount;
    @Temporal(TemporalType.DATE)
    private @NonNull Date Savedate;
    private @NonNull String Title;
    private @NonNull String Incomeexpense;
    private @NonNull String Department;
    private @NonNull String giveTo;
    private @NonNull String amount;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Departments.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "iddepartment",insertable = true)      // join colume video_id จาก video กับ entity comment
    private Departments Departments;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = IncomeExpenses.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idIncomeExpenses",insertable = true)      // join colume video_id จาก video กับ entity comment
    private IncomeExpenses IncomeExpenses;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = GiveTo.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idGiveTo",insertable = true)      // join colume video_id จาก video กับ entity comment
    private GiveTo GiveTo;

    public Long getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Long id_account) {
        this.idaccount = id_account;
    }

    public Date getSavedate() {
        return Savedate;
    }

    public void setSavedate(Date savedate) {
        this.Savedate = savedate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getIncomeexpenses() {
        return Incomeexpense;
    }

    public void setIncomeexpenses(String incomeexpenses) {
        this.Incomeexpense = incomeexpenses;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getGiveto() {
        return giveTo;
    }

    public void setGiveto(String giveto) {
        this.giveTo = giveto;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Departments getDepartments() {
        return Departments;
    }

    public void setDepartments(Departments departments) {
        this.Departments = departments;
    }

    public IncomeExpenses getIncomeExpenses() {
        return IncomeExpenses;
    }

    public void setIncomeExpenses(IncomeExpenses incomeExpenses) {
        this.IncomeExpenses = incomeExpenses;
    }

    public GiveTo getGiveTo() {
        return GiveTo;
    }

    public void setGiveTo(GiveTo giveTo) {
        this.GiveTo = giveTo;
    }
}

