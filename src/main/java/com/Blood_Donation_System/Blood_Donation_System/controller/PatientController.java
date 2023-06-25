package com.Blood_Donation_System.Blood_Donation_System.controller;
import com.Blood_Donation_System.Blood_Donation_System.model.PatientModel;
import com.Blood_Donation_System.Blood_Donation_System.service.Last_OperationsService;
import com.Blood_Donation_System.Blood_Donation_System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private Last_OperationsService lastOperationsService;



    /* to save a patient */
    @PostMapping("/patient")
    public String createPatient(@ModelAttribute PatientModel patient) {


            System.out.println("Patient request: "+ patient);
            PatientModel registeredPatient=patientService.becomePatient(patient.getPatient_name(), patient.getPatient_mobile(), patient.getPatient_age(),
                    patient.getPatient_gender(), patient.getPatient_bloodgroup(), patient.getPatient_address());
            if (registeredPatient == null) {
                return "login_error_page";
            }else{
                lastOperationsService.createLOG(patient.getPatient_name(),"has registered as a patient.", Date.valueOf(LocalDate.now()));
                return "home_page";
            }

    }

    /* get all patients */
    @GetMapping("/patient")
    public String getBecomePatientPage(Model model){
        model.addAttribute("PatientRequest", new PatientModel());
        return "patient_page";
    }
    /* Delete a product */
    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patientsReq", patientService.findAllPatients());
        return "pList_page";
    }

    @GetMapping("/addnewPatient")
    public String newPatientForm(Model model) {
        model.addAttribute("newPatientReq", new PatientModel());
        return "new_patient_page";
    }
    @PostMapping("/adminNewPat")
    public String adminCreatePatient(@ModelAttribute PatientModel patient) {
        System.out.println("Patient request: "+ patient);
        PatientModel registeredPatient=patientService.becomePatient(patient.getPatient_name(), patient.getPatient_mobile(), patient.getPatient_age(),
                patient.getPatient_gender(), patient.getPatient_bloodgroup(), patient.getPatient_address());
        if (registeredPatient == null) {
            return "error_page";
        }else{
            lastOperationsService.createLOG(patient.getPatient_name(),"was created by admin as a patient.", Date.valueOf(LocalDate.now()));
            return "redirect:patients";
        }
    }



    @GetMapping("/patients/edit/{id}")
    public String editPatientForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.findById(id));
        return "edit_patient";
    }

    @PostMapping("/patients/{id}")
    public String updatePatient(@PathVariable Long id,
                              @ModelAttribute("patient") PatientModel patientModel,
                              Model model) {

        PatientModel existingPatient = patientService.findById(id);
        //existingPatient.setId(id);
        existingPatient.setPatient_name(patientModel.getPatient_name());
        existingPatient.setId(patientModel.getId());
        existingPatient.setPatient_address(patientModel.getPatient_address());
        existingPatient.setPatient_age(patientModel.getPatient_age());
        existingPatient.setPatient_gender(patientModel.getPatient_gender());
        existingPatient.setPatient_bloodgroup(patientModel.getPatient_bloodgroup());
        existingPatient.setPatient_mobile(patientModel.getPatient_mobile());
        lastOperationsService.createLOG("Patient "+existingPatient.getPatient_name()," has updated by admin.", Date.valueOf(LocalDate.now()));
        patientService.updatePatient(existingPatient);
        return "redirect:/patients";
    }
    @GetMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id) {
        lastOperationsService.createLOG("Patient "+patientService.findById(id).getPatient_name()," has deleted by admin.", Date.valueOf(LocalDate.now()));
        patientService.deletePatientById(id);

        return "redirect:/patients";
    }



}
