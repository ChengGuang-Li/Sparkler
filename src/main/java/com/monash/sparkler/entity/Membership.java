package com.monash.sparkler.entity;


import javax.persistence.*;

@Entity(name = "Membership")
@Table(name = "membership")
public class Membership {

    @Id
    @SequenceGenerator(
            name = "membership_sequence",
            sequenceName = "membership_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private int m_id;
    private Double m_price;
    @Column(
            name = "membershipName",
            nullable = false
    )
    private String m_name;
    //default constructor
    public Membership() {
    }
    //Constructor
    public Membership(int m_id, Double m_price, String m_name) {
        this.m_id = m_id;
        this.m_price = m_price;
        this.m_name = m_name;
    }

    //getter methods
    public int getM_id() {
        return m_id;
    }

    public Double getM_price() {
        return m_price;
    }

    public String getM_name() {
        return m_name;
    }

    //setter methods
    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public void setM_price(Double m_price) {
        this.m_price = m_price;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    //toString method
    @Override
    public String toString() {
        return "Membership{" +
                "m_id=" + m_id +
                ", m_price=" + m_price +
                ", m_name='" + m_name + '\'' +
                '}';
    }
}
