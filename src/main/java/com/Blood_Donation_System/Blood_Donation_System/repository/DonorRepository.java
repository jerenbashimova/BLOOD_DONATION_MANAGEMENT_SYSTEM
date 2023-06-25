package com.Blood_Donation_System.Blood_Donation_System.repository;

import com.Blood_Donation_System.Blood_Donation_System.model.DonorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface  DonorRepository extends JpaRepository<DonorModel,Long> {



}
