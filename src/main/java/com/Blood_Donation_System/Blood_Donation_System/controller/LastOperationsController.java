package com.Blood_Donation_System.Blood_Donation_System.controller;
import com.Blood_Donation_System.Blood_Donation_System.service.Last_OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LastOperationsController {
    @Autowired
    private Last_OperationsService lastOperationsService;

    /* get all admins */

    @GetMapping("/logs")
    public String logs(Model model) {
        model.addAttribute("Logs", lastOperationsService.findAll());
        return "logs_page";
    }

}
