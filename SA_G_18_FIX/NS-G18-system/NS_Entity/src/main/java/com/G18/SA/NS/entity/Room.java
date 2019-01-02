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
@Table(name="Room")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Room {
    @Id
    @SequenceGenerator(name="Room_seq",sequenceName="Room_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Room_seq")
    @Column(name="Room_Id",unique = true, nullable = false)
    private @NonNull Long idRoom;
    private @NonNull Integer nameRoom;

  /*  @OneToMany(
            mappedBy="room", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Activity> Activity = new ArrayList<>();
*/

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(Integer nameRoom) {
        this.nameRoom = nameRoom;
    }

}
