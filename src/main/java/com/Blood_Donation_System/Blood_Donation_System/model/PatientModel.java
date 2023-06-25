package com.Blood_Donation_System.Blood_Donation_System.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
public class PatientModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="patient_id", nullable=false, updatable=false)
    private Long id;
    private String patient_name,patient_email,patient_mobile,patient_address,patient_gender,patient_bloodgroup;

    private int patient_age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }


    public String getPatient_mobile() {
        return patient_mobile;
    }

    public void setPatient_mobile(String patient_mobile) {
        this.patient_mobile = patient_mobile;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getPatient_gender() {
        return patient_gender;
    }

    public void setPatient_gender(String patient_gender) {
        this.patient_gender = patient_gender;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_bloodgroup() {
        return patient_bloodgroup;
    }

    public void setPatient_bloodgroup(String patient_bloodgroup) {
        this.patient_bloodgroup = patient_bloodgroup;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "patient_id=" + id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_email='" + patient_email + '\'' +

                ", patient_mobile='" + patient_mobile + '\'' +
                ", patient_address='" + patient_address + '\'' +
                ", patient_gender='" + patient_gender + '\'' +
                ", patient_bloodgroup='" + patient_bloodgroup + '\'' +
                ", patient_age=" + patient_age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientModel that = (PatientModel) o;
        return patient_age == that.patient_age && Objects.equals(id, that.id) && Objects.equals(patient_name, that.patient_name) && Objects.equals(patient_email, that.patient_email) && Objects.equals(patient_mobile, that.patient_mobile) && Objects.equals(patient_address, that.patient_address) && Objects.equals(patient_gender, that.patient_gender) && Objects.equals(patient_bloodgroup, that.patient_bloodgroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient_name, patient_email, patient_mobile, patient_address, patient_gender, patient_bloodgroup, patient_age);
    }
}
