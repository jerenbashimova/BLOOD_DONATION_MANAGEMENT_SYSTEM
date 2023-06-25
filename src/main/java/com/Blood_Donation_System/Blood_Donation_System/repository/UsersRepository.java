package com.Blood_Donation_System.Blood_Donation_System.repository;

import com.Blood_Donation_System.Blood_Donation_System.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<UsersModel,Long> {
    Optional<UsersModel> findByLoginAndPassword(String login , String password);
    Optional<UsersModel> findFirstByLogin(String login);

}
