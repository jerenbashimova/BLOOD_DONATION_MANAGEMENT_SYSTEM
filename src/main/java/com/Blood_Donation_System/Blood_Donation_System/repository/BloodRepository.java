package com.Blood_Donation_System.Blood_Donation_System.repository;

import com.Blood_Donation_System.Blood_Donation_System.model.BloodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepository extends JpaRepository<BloodModel,Long> {
}
