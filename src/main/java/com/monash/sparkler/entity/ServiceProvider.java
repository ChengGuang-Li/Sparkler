package com.monash.sparkler.entity;


import javax.persistence.*;

@Entity(name = "ServiceProvider")
@Table(
        name = "ServiceProvider"
)
public class ServiceProvider {

    @Id
    @SequenceGenerator(
            name = "service_provider_sequence",
            sequenceName = "service_provider_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "service_provider_sequence"
    )
    @Column(name="sp_id")
    private Long spId;

    @Column(name = "sp_name", nullable = false)
    private String spName;

    @Column(name = "sp_phone_number", nullable = false)
    private String spPhoneNumber;

    @Column(name = "sp_introduction")
    private String spIntroduction;

    @Column(name = "sp_address")
    private String spAddress;  //seperate?


    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpPhoneNumber() {
        return spPhoneNumber;
    }

    public void setSpPhoneNumber(String spPhoneNumber) {
        this.spPhoneNumber = spPhoneNumber;
    }

    public String getSpIntroduction() {
        return spIntroduction;
    }

    public void setSpIntroduction(String spIntroduction) {
        this.spIntroduction = spIntroduction;
    }

    public String getSpAddress() {
        return spAddress;
    }

    public void setSpAddress(String spAddress) {
        this.spAddress = spAddress;
    }
}
