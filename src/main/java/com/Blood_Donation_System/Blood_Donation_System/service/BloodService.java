package com.Blood_Donation_System.Blood_Donation_System.service;

import com.Blood_Donation_System.Blood_Donation_System.model.BloodModel;
import com.Blood_Donation_System.Blood_Donation_System.repository.BloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodService {
    @Autowired
    private final BloodRepository bloodRepository;


    public BloodService(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }

    public void delete(BloodModel blood) {
        bloodRepository.delete(blood);
    }


    public List<BloodModel> getAllBloods(){
        return bloodRepository.findAll();
    }


    public BloodModel findById(Long id){

        return  bloodRepository.findById(id).orElse(null);
    }

    public BloodModel updateBlood(BloodModel existingBlood) {
        return bloodRepository.save(existingBlood);
    }

    public void deleteBloodById(Long id){
        bloodRepository.deleteById(id);
    }


    public BloodModel becomeBlood(String bloodGroup, String bloodDsc, String bloodDate,String bloodBank) {

        if (bloodGroup == null || bloodDsc == null || bloodDate == null|| bloodBank==null ) {
            return null;
        } else {

            BloodModel bloodModel = new BloodModel();
            bloodModel.setBloodGroup(bloodGroup);
            bloodModel.setBloodDsc(bloodDsc);
            bloodModel.setBloodDate(bloodDate);
            bloodModel.setBloodBank(bloodBank);
            return bloodRepository.save(bloodModel);
        }

    }
}
