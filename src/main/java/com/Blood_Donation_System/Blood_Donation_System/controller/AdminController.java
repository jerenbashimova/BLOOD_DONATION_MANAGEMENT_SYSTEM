package com.Blood_Donation_System.Blood_Donation_System.controller;

import com.Blood_Donation_System.Blood_Donation_System.model.AdminModel;
import com.Blood_Donation_System.Blood_Donation_System.model.UsersModel;
import com.Blood_Donation_System.Blood_Donation_System.service.AdminService;
import com.Blood_Donation_System.Blood_Donation_System.service.DonorService;
import com.Blood_Donation_System.Blood_Donation_System.service.Last_OperationsService;
import com.Blood_Donation_System.Blood_Donation_System.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private Last_OperationsService lastOperationsService;


    @GetMapping("/admin")
    public String getLoginPage(Model model){
        model.addAttribute("adminloginRequest", new AdminModel());
        ///
        return "admin_login_page";

    }
    @GetMapping("/admin-error")
    public String getHomePage(Model model){
        model.addAttribute("adminhomeRequest", new AdminModel());
        ///
        return "home_page";

    }
    @GetMapping("/return-home")
    public String getReturnHomePage(Model model){
        model.addAttribute("returnHomeRequest", new AdminModel());
        ///
        return "home_page";

    }
    @GetMapping("/admin-home")
    public String getAdminHomePage(Model model){
        model.addAttribute("adminHomeRequest", new AdminModel());
        ///
        return "admin_home_page";

    }

    @PostMapping("/admin")
    public String login(@ModelAttribute AdminModel adminModel, Model model){
        System.out.println("login request: "+ adminModel);
        AdminModel authenticated=adminService.authenticate(adminModel.getLogin(),adminModel.getPassword());
        if(authenticated != null){
            model.addAttribute("adminLogin",authenticated.getLogin());
            lastOperationsService.createLOG(adminModel.getLogin(),"logged in as an admin", Date.valueOf(LocalDate.now()));
            return "admin_home_page";
        } else {
            return "admin_error_page";
        }
    }


}
