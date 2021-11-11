package com.mvctask.controller;


import com.mvctask.model.Appointment;
import com.mvctask.model.Doctor;
import com.mvctask.service.AppointmentService;
import com.mvctask.service.DoctorService;
import com.mvctask.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="/doctors", method=RequestMethod.GET)
    public String getOrderPage(Model model) {
        model.addAttribute("doctorsList",doctorService.getAll());
        return "admin/doctors";
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(value="/doctor/doctorMainPage", method=RequestMethod.GET)
    public String getDoctorMainPage(Model model) {
        return "doctor/doctorMainPage";
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(value="/doctor/viewAppointments", method=RequestMethod.GET)
    public String getViewAppointmentsPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Doctor doctor = doctorService.getDoctorByUsername(username);
        model.addAttribute("appointments",appointmentService.getByDoctorId(doctor.getId()));
        return "doctor/viewAppointments";
    }

    @RequestMapping(value="/doctor/viewAppointments/update/{id}", method=RequestMethod.GET)
    public String getViewUpdateAppointmentPage(@PathVariable Integer id, Model model) {
        Appointment appointment = appointmentService.getById(id);
        model.addAttribute("appointment",appointment);
        return "doctor/updateAppointment";
    }

    @RequestMapping(value="/doctor/viewAppointments/update/update-appointment", method=RequestMethod.POST)
    public String updateAppointment(@RequestParam(value = "appointmentId") Integer id,
                                    @RequestParam(value = "description") String description) {
        Appointment appointment = appointmentService.getById(id);
        appointment.setDescription(description);
        appointmentService.update(appointment);
        return "redirect:/doctor/doctorMainPage";
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(value="/doctor/viewRecords", method=RequestMethod.GET)
    public String getViewRecordsPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Doctor doctor = doctorService.getDoctorByUsername(username);
        model.addAttribute("records",recordService.getRecordsByDoctor(doctor));
        return "doctor/viewRecords";
    }


}
