package com.mvctask.controller;

import com.mvctask.model.Client;
import com.mvctask.model.Doctor;
import com.mvctask.model.Speciality;
import com.mvctask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register/client", method= RequestMethod.GET)
    public String getClientRegistrationPage(Model model) {
        return "client/clientRegistration";
    }

    @RequestMapping(value="/register/register-new-client", method=RequestMethod.POST)
    public String addNewClient(@RequestParam(value="fullName") String fullName,
                               @RequestParam(value="phoneNumber") String phoneNumber,
                               @RequestParam(value="email") String email,
                               @RequestParam(value="login") String login,
                               @RequestParam(value="password") String password) throws Exception {
        Client client = new Client(fullName, phoneNumber, email, login, password);
        userService.registerUser(client, false);
        return "redirect:/client/clientMainPage";
    }

    @RequestMapping(value="/register/doctor", method= RequestMethod.GET)
    public String getDoctorRegistrationPage(Model model) {
        return "doctor/doctorRegistration";
    }

    @RequestMapping(value="/register/register-new-doctor", method=RequestMethod.POST)
    public String addNewDoctor(@RequestParam(value="fullName") String fullName,
                               @RequestParam(value="phoneNumber") String phoneNumber,
                               @RequestParam(value="email") String email,
                               @RequestParam(value="login") String login,
                               @RequestParam(value="password") String password,
                               @RequestParam(value="speciality") String speciality) throws Exception {
        Speciality doctorSpeciality = Speciality.valueOf(speciality);
        Doctor doctor = new Doctor(fullName,phoneNumber,email,login,password,doctorSpeciality);
        userService.registerUser(doctor,false);
        return "redirect:/doctor/doctorMainPage";
    }

    @RequestMapping(value="/register/administrator", method= RequestMethod.GET)
    public String getAdminRegistrationPage(Model model) {
        return "administrator/adminRegistration";
    }

    @RequestMapping(value="/register/register-new-admin", method=RequestMethod.POST)
    public String addNewAdmin(@RequestParam(value="fullName") String fullName,
                               @RequestParam(value="phoneNumber") String phoneNumber,
                               @RequestParam(value="email") String email,
                               @RequestParam(value="login") String login,
                               @RequestParam(value="password") String password) throws Exception {
        Client client = new Client(fullName, phoneNumber, email, login, password);
        userService.registerUser(client, true);
        return "redirect:/administrator/adminMainPage";
    }
}
