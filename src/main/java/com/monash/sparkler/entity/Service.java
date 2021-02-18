package com.monash.sparkler.entity;


import javax.persistence.*;

@Entity(name = "Service")
@Table(name = "service")
public class Service {

    @Id
    @SequenceGenerator(
            name = "service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )

    private String s_id;
    private String sp_id;
    private String s_description;
    private String c_id;
    private double s_price;
    private String s_name;

    //default constructor
    public Service() {
    }

    //Constructor
    public Service(String s_id, String sp_id, String s_description, String c_id, double s_price, String s_name) {
        this.s_id = s_id;
        this.sp_id = sp_id;
        this.s_description = s_description;
        this.c_id = c_id;
        this.s_price = s_price;
        this.s_name = s_name;
    }

    //Getters and Setters

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public String getS_description() {
        return s_description;
    }

    public void setS_description(String s_description) {
        this.s_description = s_description;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public double getS_price() {
        return s_price;
    }

    public void setS_price(double s_price) {
        this.s_price = s_price;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    // toString method
    @Override
    public String toString() {
        return "Service{" +
                "s_id='" + s_id + '\'' +
                ", sp_id='" + sp_id + '\'' +
                ", s_description='" + s_description + '\'' +
                ", c_id='" + c_id + '\'' +
                ", s_price=" + s_price +
                ", s_name='" + s_name + '\'' +
                '}';
    }

}
