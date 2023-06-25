package com.Blood_Donation_System.Blood_Donation_System.service;

import com.Blood_Donation_System.Blood_Donation_System.model.DonorModel;
import com.Blood_Donation_System.Blood_Donation_System.model.PatientModel;
import com.Blood_Donation_System.Blood_Donation_System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientModel becomePatient(String name, String mobileNumber, int age, String gender, String bloodGroup, String address) {

        if (name == null || mobileNumber == null || bloodGroup == null || address == null) {
            return null;
        } else {
            /*if(donorRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Dublicate login");
                return null;
            }*/
            PatientModel patientModel =new PatientModel();
            patientModel.setPatient_name(name);
            patientModel.setPatient_mobile(mobileNumber);
            patientModel.setPatient_address(address);
            patientModel.setPatient_gender(gender);
            patientModel.setPatient_bloodgroup(bloodGroup);
            patientModel.setPatient_age(age);
            //donorModel.setDonor_email(usersRepository.);//donorün e maili userdan alınabilir mi
            return patientRepository.save(patientModel);
        }

    }



    public List<PatientModel> findAllPatients(){
        return patientRepository.findAll();
    }


    public PatientModel findById(Long id){
        return  patientRepository.findById(id).orElse(null);
    }

    public PatientModel updatePatient(PatientModel existingPatient) {
        return patientRepository.save(existingPatient);
    }

    public void deletePatientById(Long id){
        patientRepository.deleteById(id);}


}
