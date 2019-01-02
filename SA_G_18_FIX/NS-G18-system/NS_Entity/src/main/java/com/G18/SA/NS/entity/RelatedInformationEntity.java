package com.G18.SA.NS.entity;

import javax.persistence.*;
// import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "RelatedInformation")
public class RelatedInformationEntity {
    @Id
    @SequenceGenerator(name="related_seq",sequenceName="related_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="related_seq")
    @Column(name="RELATED_ID",unique = true, nullable = false)
    private @NonNull Long relatedinformationID;
    private @NonNull String relatedinformationName;
    private @NonNull String relatedinformationAddress;
    private @NonNull String relatedinformationTime;
    private @NonNull String relatedinformationDay;
    private @NonNull String relatedinformationPhone;
    private @NonNull String relatedinformationEmail;
    private String relatedinformationFacebook;
    private String relatedinformationLine;


    //Many To One with AgencyType
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = AgencyTypeEntity.class)*/
    @JoinColumn(name = "agencyID")
    private AgencyTypeEntity agencyTypeEntity;

    //Many To One with ContactTime
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = ContactTimeEntity.class)*/
    @JoinColumn(name = "contactTimeID")
    private ContactTimeEntity contactTimeEntity;

    //Many To One with Country
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = CountryEntity.class)*/
    @JoinColumn(name = "countryID")
    private CountryEntity countryEntity;

    //Many To One with Province
    @ManyToOne /*(fetch = FetchType.EAGER, targetEntity = ProvinceEntity.class)*/
    @JoinColumn(name = "provinceID")
    private ProvinceEntity provinceEntity;

    public Long getRelatedinformationID() {
        return relatedinformationID;
    }

    public void setRelatedinformationID(Long relatedinformationID) {
        this.relatedinformationID = relatedinformationID;
    }

    public String getRelatedinformationName() {
        return relatedinformationName;
    }

    public void setRelatedinformationName(String relatedinformationName) {
        this.relatedinformationName = relatedinformationName;
    }

    public String getRelatedinformationAddress() {
        return relatedinformationAddress;
    }

    public void setRelatedinformationAddress(String relatedinformationAddress) {
        this.relatedinformationAddress = relatedinformationAddress;
    }

    public String getRelatedinformationTime() {
        return relatedinformationTime;
    }

    public void setRelatedinformationTime(String relatedinformationTime) {
        this.relatedinformationTime = relatedinformationTime;
    }

    public String getRelatedinformationDay() {
        return relatedinformationDay;
    }

    public void setRelatedinformationDay(String relatedinformationDay) {
        this.relatedinformationDay = relatedinformationDay;
    }

    public String getRelatedinformationPhone() {
        return relatedinformationPhone;
    }

    public void setRelatedinformationPhone(String relatedinformationPhone) {
        this.relatedinformationPhone = relatedinformationPhone;
    }

    public String getRelatedinformationEmail() {
        return relatedinformationEmail;
    }

    public void setRelatedinformationEmail(String relatedinformationEmail) {
        this.relatedinformationEmail = relatedinformationEmail;
    }

    public String getRelatedinformationFacebook() {
        return relatedinformationFacebook;
    }

    public void setRelatedinformationFacebook(String relatedinformationFacebook) {
        this.relatedinformationFacebook = relatedinformationFacebook;
    }

    public String getRelatedinformationLine() {
        return relatedinformationLine;
    }

    public void setRelatedinformationLine(String relatedinformationLine) {
        this.relatedinformationLine = relatedinformationLine;
    }

    public AgencyTypeEntity getAgencyTypeEntity() {
        return agencyTypeEntity;
    }

    public void setAgencyTypeEntity(AgencyTypeEntity agencyTypeEntity) {
        this.agencyTypeEntity = agencyTypeEntity;
    }

    public ContactTimeEntity getContactTimeEntity() {
        return contactTimeEntity;
    }

    public void setContactTimeEntity(ContactTimeEntity contactTimeEntity) {
        this.contactTimeEntity = contactTimeEntity;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }

	public Object map(Object object) {
		return null;
	}
}
