package com.Blood_Donation_System.Blood_Donation_System.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="blood_table")
public class BloodModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    private String bloodGroup;
    private String bloodDsc;
    private String bloodDate;

    private String bloodBank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodDsc() {
        return bloodDsc;
    }

    public void setBloodDsc(String bloodDsc) {
        this.bloodDsc = bloodDsc;
    }

    public String getBloodDate() {
        return bloodDate;
    }

    public void setBloodDate(String bloodDate) {
        this.bloodDate = bloodDate;
    }

    public String getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(String bloodBank) {
        this.bloodBank = bloodBank;
    }
}
