package com.G18.SA.NS.entity;
import javax.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Getter @Setter
// @NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Departments {
    @Id
    @SequenceGenerator(name="depart_seq",sequenceName="depart_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="depart_seq")
    @Column(name="iddepartment",unique = true, nullable = false)
    private @NonNull Long idDepartment;
    private @NonNull String nameDepartment;



   /* @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "id_account")      // join colume video_id จาก video กับ entity comment
    private AccountRecord accountrecord;*/

    public Departments(){}
    public  Departments(String NameDepartment){
        this.nameDepartment = NameDepartment;
    }

    public Long getIddepartment() {
        return idDepartment;
    }
    public void setIddepartment(Long iddepartment) {
        this.idDepartment = iddepartment;
    }

    public String getNamedepartment() {
        return nameDepartment;
    }

    public void setNamedepartment(String namedepartment) {
        this.nameDepartment = namedepartment;
    }


}

