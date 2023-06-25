package com.Blood_Donation_System.Blood_Donation_System.service;

import com.Blood_Donation_System.Blood_Donation_System.model.AdminModel;

import com.Blood_Donation_System.Blood_Donation_System.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminModel authenticate(String login, String password){
        return adminRepository.findByLoginAndPassword(login,password).orElse( null);
    }

}
