package com.Blood_Donation_System.Blood_Donation_System.controller;


import com.Blood_Donation_System.Blood_Donation_System.model.BloodModel;
import com.Blood_Donation_System.Blood_Donation_System.service.BloodService;
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

@Controller
public class BloodController {
    @Autowired
    private BloodService bloodService;
    @Autowired
    private Last_OperationsService lastOperationsService;

    @GetMapping("bloodList")
    public String listBloods(Model model) {
        model.addAttribute("bloodList", bloodService.getAllBloods());
        return "bloodList";
    }

    @GetMapping("/addBlood")
    public String newBloodForm(Model model) {
        model.addAttribute("newBloodReq", new BloodModel());
        return "newBlood_page";

    }
    @PostMapping("/bloodList/newBlood")
    public String adminCreateBlood(@ModelAttribute BloodModel blood) {
        System.out.println("Donor request: "+ blood);
        BloodModel registeredBlood=bloodService.becomeBlood(blood.getBloodGroup(), blood.getBloodDsc(), blood.getBloodDate(),blood.getBloodBank());
        if (registeredBlood == null) {
            return "error_page";
        }else {
            lastOperationsService.createLOG(blood.getBloodGroup(),"was created", Date.valueOf(LocalDate.now()));
            return "redirect:/bloodList";
        }
    }

    @GetMapping("/bloodList/edit/{id}")
    public String editBloodForm(@PathVariable Long id, Model model) {
        model.addAttribute("blood", bloodService.findById(id));
        return "edit_blood";
    }

    @PostMapping("/bloodList/{id}")
    public String updateBlood(@PathVariable Long id,
                              @ModelAttribute("blood") BloodModel bloodModel,
                              Model model) {

        BloodModel existingBlood = bloodService.findById(id);
        existingBlood.setId(id);
        existingBlood.setBloodGroup(bloodModel.getBloodGroup());
        existingBlood.setId(bloodModel.getId());
        existingBlood.setBloodDsc(bloodModel.getBloodDsc());
        existingBlood.setBloodDate(bloodModel.getBloodDate());
        lastOperationsService.createLOG("Blood "+bloodModel.getBloodGroup(),"was updated", Date.valueOf(LocalDate.now()));
        bloodService.updateBlood(existingBlood);
        return "redirect:/bloodList";
    }
    @GetMapping("/bloodList/{id}")
    public String deleteDonor(@PathVariable Long id) {
        lastOperationsService.createLOG("Blood "+bloodService.findById(id).getBloodGroup(),"was deleted", Date.valueOf(LocalDate.now()));
        bloodService.deleteBloodById(id);

        return "redirect:/bloodList";
    }

}
