package com.Blood_Donation_System.Blood_Donation_System.controller;
import com.Blood_Donation_System.Blood_Donation_System.model.DonorModel;
import com.Blood_Donation_System.Blood_Donation_System.model.UsersModel;
import com.Blood_Donation_System.Blood_Donation_System.service.DonorService;
import com.Blood_Donation_System.Blood_Donation_System.service.Last_OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class DonorController {
    @Autowired
    private DonorService donorService;
    @Autowired
    private Last_OperationsService lastOperationsService;

    @GetMapping("/donor")
    public String getBecomeDonorPage(Model model){
        model.addAttribute("DonorRequest", new DonorModel());
        return "becomeDonor_page";
    }
    /* to save a donor */
    @PostMapping("/donor")
    public String createDonor(@ModelAttribute DonorModel donor) {
        System.out.println("Donor request: "+ donor);
        DonorModel registeredDonor=donorService.becomeDonor(donor.getDonor_name(), donor.getDonor_mobile(), donor.getDonor_age(), donor.getDonor_gender(), donor.getDonor_bloodGroup(), donor.getDonor_address());
        if (registeredDonor == null) {
            return "login_error_page";
        }else{
            lastOperationsService.createLOG(donor.getDonor_name(),"registered as a donor.", Date.valueOf(LocalDate.now()));
            return "home_page";
        }

    }


    /* get all donors */
    @GetMapping("/donorList")
    public String listDonors(Model model) {
        model.addAttribute("donorList", donorService.getAllDonors());
        return "donorList";
    }

    @GetMapping("/addnewDonor")
    public String newDonorForm(Model model) {
        model.addAttribute("newDonor", new DonorModel());
        return "newDonor_page";

    }
    @PostMapping("/donorList/newDonor")
    public String adminCreateDonor(@ModelAttribute DonorModel donor) {
        System.out.println("Donor request: "+ donor);
        DonorModel registeredDonor=donorService.becomeDonor(donor.getDonor_name(), donor.getDonor_mobile(), donor.getDonor_age(), donor.getDonor_gender(), donor.getDonor_bloodGroup(), donor.getDonor_address());
        if (registeredDonor == null) {
            return "error_page";
        }else{
            lastOperationsService.createLOG(donor.getDonor_name(),"was created by admin as a donor.", Date.valueOf(LocalDate.now()));
            return "redirect:/donorList";
        }
    }



    @GetMapping("/donorList/edit/{id}")
    public String editDonorForm(@PathVariable Long id, Model model) {
        model.addAttribute("donor", donorService.findById(id));
        return "edit_donor";
    }

    @PostMapping("/donorList/{id}")
    public String updateDonor(@PathVariable Long id,
                              @ModelAttribute("donor") DonorModel donorModel,
                              Model model) {

        DonorModel existingDonor = donorService.findById(id);
        //  existingDonor.setId(id);
        existingDonor.setDonor_name(donorModel.getDonor_name());
        existingDonor.setId(donorModel.getDonor_id());
        existingDonor.setDonor_address(donorModel.getDonor_address());
        existingDonor.setDonor_age(donorModel.getDonor_age());
        existingDonor.setDonor_gender(donorModel.getDonor_gender());
        existingDonor.setDonor_bloodGroup(donorModel.getDonor_bloodGroup());
        existingDonor.setDonor_mobile(donorModel.getDonor_mobile());
        lastOperationsService.createLOG("Donor "+ existingDonor.getDonor_name()," was updated by admin.", Date.valueOf(LocalDate.now()));

        donorService.updateDonor(existingDonor);
        return "redirect:/donorList";
    }
    @GetMapping("/donorList/{id}")
    public String deleteDonor(@PathVariable Long id) {
        lastOperationsService.createLOG("Donor "+donorService.findById(id).getDonor_name()," was deleted by admin.", Date.valueOf(LocalDate.now()));
        donorService.deleteDonorById(id);

        return "redirect:/donorList";
    }



}
