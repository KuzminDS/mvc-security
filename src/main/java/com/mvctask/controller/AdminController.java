package com.mvctask.controller;

import com.mvctask.model.Client;
import com.mvctask.model.Doctor;
import com.mvctask.model.Speciality;
import com.mvctask.service.AppointmentService;
import com.mvctask.service.ClientService;
import com.mvctask.service.DoctorService;
import com.mvctask.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ClientService clientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    RecordService recordService;

    @RequestMapping(value="/administrator/adminMainPage", method= RequestMethod.GET)
    public String getAdminMainPage(Model model) {
        return "administrator/adminMainPage";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients", method=RequestMethod.GET)
    public String getClientsPage(Model model) {
        model.addAttribute("clientList",clientService.getAll());
        return "administrator/clients";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors", method=RequestMethod.GET)
    public String getDoctorsPage(Model model) {
        model.addAttribute("doctorList",doctorService.getAll());
        return "administrator/doctors";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients/delete/{id}", method=RequestMethod.GET)
    public String deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return "redirect:/administrator/clients";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients/update/{id}", method=RequestMethod.GET)
    public String getUpdateClientView(@PathVariable Integer id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client",client);
        return "administrator/updateClient";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients/update/update-client", method=RequestMethod.POST)
    public String updateClient(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "fullName") String fullName,
                               @RequestParam(value = "phoneNumber") String phoneNumber,
                               @RequestParam(value = "email") String email) {
        Client client = clientService.getById(id);
        client.setFullName(fullName);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        clientService.update(client);
        return "redirect:/administrator/clients";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors/update/update-doctor", method=RequestMethod.POST)
    public String updateDoctor(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "fullName") String fullName,
                               @RequestParam(value = "phoneNumber") String phoneNumber,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value="speciality") String speciality) {
        Speciality specialityDoctor = Speciality.valueOf(speciality);
        Doctor doctor = doctorService.getById(id);
        doctor.setFullName(fullName);
        doctor.setEmail(email);
        doctor.setPhoneNumber(phoneNumber);
        doctor.setSpeciality(specialityDoctor);
        doctorService.update(doctor);
        return "redirect:/administrator/adminMainPage";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors/update/{id}", method=RequestMethod.GET)
    public String getUpdateDoctorView(@PathVariable Integer id, Model model) {
        Doctor doctor = doctorService.getById(id);
        model.addAttribute("doctor",doctor);
        return "administrator/updateDoctor";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors/delete/{id}", method=RequestMethod.GET)
    public String deleteDoctor(@PathVariable Integer id) {
        doctorService.delete(id);
        return "redirect:/administrator/doctors";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors/records/{id}", method=RequestMethod.GET)
    public String getRecordsByDoctor(@PathVariable Integer id, Model model) {
        Doctor doctor = doctorService.getById(id);
        model.addAttribute("records",recordService.getRecordsByDoctor(doctor));
        return "administrator/getRecordsByDoctor";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients/records/{id}", method=RequestMethod.GET)
    public String getRecordsByClient(@PathVariable Integer id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("records",recordService.getRecordsByClient(client));
        return "administrator/getRecordsByClient";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/clients/appointments/{id}", method=RequestMethod.GET)
    public String getAppointmentsByClient(@PathVariable Integer id, Model model) {
        model.addAttribute("appointments",appointmentService.getByClientId(id));
        return "administrator/getAppointmentsByClient";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/administrator/doctors/appointments/{id}", method=RequestMethod.GET)
    public String getAppointmentsByDoctor(@PathVariable Integer id, Model model) {
        model.addAttribute("appointments",appointmentService.getByDoctorId(id));
        return "administrator/getAppointmentsByDoctor";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public String updateItem(@PathVariable Integer id, Model model) {
        Client client = clientService.getById(id);
        Client _client = new Client(client.getFullName(),client.getPhoneNumber(),client.getEmail(),client.getLogin(),client.getPassword());
        _client.setId(client.getId());
        model.addAttribute("client",_client);
        return "client/clientUpdate";
    }
}
