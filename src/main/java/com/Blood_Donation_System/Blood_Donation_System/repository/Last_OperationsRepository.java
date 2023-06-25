package com.Blood_Donation_System.Blood_Donation_System.repository;

import com.Blood_Donation_System.Blood_Donation_System.model.LastOperationsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface Last_OperationsRepository  extends JpaRepository<LastOperationsModel, Date> {
    List<LastOperationsModel> findAllByOrderByIdDesc();
}
