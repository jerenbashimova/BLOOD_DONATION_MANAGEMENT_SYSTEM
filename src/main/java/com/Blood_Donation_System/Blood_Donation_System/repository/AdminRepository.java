package com.Blood_Donation_System.Blood_Donation_System.repository;


import com.Blood_Donation_System.Blood_Donation_System.model.AdminModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Long> {
    Optional<AdminModel> findByLoginAndPassword(String login , String password);
}
