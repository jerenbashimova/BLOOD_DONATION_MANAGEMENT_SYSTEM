package com.Blood_Donation_System.Blood_Donation_System.service;

import com.Blood_Donation_System.Blood_Donation_System.model.DonorModel;
import com.Blood_Donation_System.Blood_Donation_System.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DonorService {
    @Autowired
    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;

    }

    public DonorModel becomeDonor(String name, String mobileNumber, int age, String gender, String bloodGroup, String address) {

        if (name == null || mobileNumber == null || bloodGroup == null || address == null) {
            return null;
        } else {
            /*if(donorRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Dublicate login");
                return null;
            }*/
            DonorModel donorModel = new DonorModel();
            donorModel.setDonor_name(name);
            donorModel.setDonor_mobile(mobileNumber);
            donorModel.setDonor_address(address);
            donorModel.setDonor_gender(gender);
            donorModel.setDonor_bloodGroup(bloodGroup);
            donorModel.setDonor_age(age);
            //donorModel.setDonor_email(usersRepository.);//donorün e maili userdan alınabilir mi
            return donorRepository.save(donorModel);
        }

    }


    public  List<DonorModel> getAllDonors(){
        return donorRepository.findAll();
    }

    public DonorModel findById(Long id){
        return  donorRepository.findById(id).orElse(null);
    }

    public DonorModel updateDonor(DonorModel existingDonor) {
        return donorRepository.save(existingDonor);
    }

    public void deleteDonorById(Long id){
        donorRepository.deleteById(id);}
}
