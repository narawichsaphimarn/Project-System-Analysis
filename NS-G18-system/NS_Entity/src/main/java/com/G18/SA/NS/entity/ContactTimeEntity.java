package com.G18.SA.NS.entity;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ContactTime")
public class ContactTimeEntity {
    @Id
    @SequenceGenerator(name="contact_seq",sequenceName="contact_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contact_seq")
    @Column(name="CONTACT_ID",unique = true, nullable = false)

    private @NonNull Long contactTimeID;
    private @NonNull String contactTimeName;

    public ContactTimeEntity(){}

    public Long getContactTimeID() {
        return contactTimeID;
    }

    public void setContactTimeID(Long contactTimeID) {
        this.contactTimeID = contactTimeID;
    }

    public String getContactTimeName() {
        return contactTimeName;
    }

    public void setContactTimeName(String contactTimeName) {
        this.contactTimeName = contactTimeName;
    }
}
