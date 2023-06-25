package com.Blood_Donation_System.Blood_Donation_System.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="donor_table")

public class DonorModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    private String donor_name;
    private String donor_email;
    private String donor_mobile;
    private String donor_address;
    private String donor_gender;
    private String donor_bloodGroup;
    private int donor_age;



    public Long getDonor_id() {
        return id;
    }

    public void setDonor_id(Long donor_id) {
        this.id = id;
    }

    public String getDonor_email() {
        return donor_email;
    }

    public void setDonor_email(String donor_email) {
        this.donor_email = donor_email;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }


    public String getDonor_mobile() {
        return donor_mobile;
    }

    public void setDonor_mobile(String donor_mobile) {
        this.donor_mobile = donor_mobile;
    }

    public String getDonor_address() {
        return donor_address;
    }

    public void setDonor_address(String donor_address) {
        this.donor_address = donor_address;
    }

    public String getDonor_gender() {
        return donor_gender;
    }

    public void setDonor_gender(String donor_gender) {
        this.donor_gender = donor_gender;
    }

    public int getDonor_age() {
        return donor_age;
    }

    public void setDonor_age(int donor_age) {
        this.donor_age = donor_age;
    }

    public String getDonor_bloodGroup() {
        return donor_bloodGroup;
    }

    public void setDonor_bloodGroup(String donor_bloodGroup) {
        this.donor_bloodGroup = donor_bloodGroup;
    }

    @Override
    public String toString() {
        return "DonorModel{" +
                "id=" + id +
                ", donor_name='" + donor_name + '\'' +
                ", donor_email='" + donor_email + '\'' +
                ", donor_mobile='" + donor_mobile + '\'' +
                ", donor_address='" + donor_address + '\'' +
                ", donor_gender='" + donor_gender + '\'' +
                ", donor_bloodGroup='" + donor_bloodGroup + '\'' +
                ", donor_age=" + donor_age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonorModel that = (DonorModel) o;
        return donor_age == that.donor_age && Objects.equals(id, that.id) && Objects.equals(donor_name, that.donor_name) && Objects.equals(donor_email, that.donor_email) && Objects.equals(donor_mobile, that.donor_mobile) && Objects.equals(donor_address, that.donor_address) && Objects.equals(donor_gender, that.donor_gender) && Objects.equals(donor_bloodGroup, that.donor_bloodGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, donor_name, donor_email, donor_mobile, donor_address, donor_gender, donor_bloodGroup, donor_age);
    }

}