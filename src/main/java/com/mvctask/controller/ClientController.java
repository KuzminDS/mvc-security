package com.mvctask.controller;

import com.mvctask.model.*;
import com.mvctask.model.Record;
import com.mvctask.model.*;
import com.mvctask.service.AppointmentService;
import com.mvctask.service.ClientService;
import com.mvctask.service.DoctorService;
import com.mvctask.service.RecordService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private RecordService recordService;


    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value="/client/clientMainPage", method=RequestMethod.GET)
    public String getClientMainPage(Model model) {
        return "client/clientMainPage";
    }


    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value="/client/makeAppointment", method=RequestMethod.GET)
    public String getClientMakeAppointmentPage(Model model) throws NotFoundException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Client client = clientService.getClientByUsername(username);
        if(client!=null){
            model.addAttribute("client",client);
        }else{
            throw new NotFoundException("Client not founded");
        }
        GregorianCalendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_YEAR,1);
        model.addAttribute("doctors", doctorService.getAll());
        List<GregorianCalendar> gaps = recordService
                .GetFreeGapsByDoctorOnDay(doctorService.getAll()
                        .stream().
                        findFirst().
                        orElse(null),date);
        HashMap<Long, String> gapsDict = new HashMap<Long, String>();

        for (GregorianCalendar gap:gaps) {
            Date day = gap.getTime();
            gapsDict.put(gap.getTimeInMillis(),day.toString());
        }
        model.addAttribute("gaps",gapsDict);
        return "client/makeAppointment";
    }

    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value="/client/get-timetable",method=RequestMethod.GET)
    public String getTimetable(@RequestParam Integer id, Model model) throws NotFoundException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Client client = clientService.getClientByUsername(username);
        if(client!=null){
            model.addAttribute("client",client);
        }else{
            throw new NotFoundException("Client not founded");
        }
        Doctor doctor = doctorService.getById(id);
        GregorianCalendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_YEAR,1);
        model.addAttribute("doctors", doctorService.getAll());
        List<GregorianCalendar> gaps = recordService
                .GetFreeGapsByDoctorOnDay(doctor,date);
        HashMap<Long, String> gapsDict = new HashMap<Long, String>();
        for (GregorianCalendar gap:gaps) {
            Date day = gap.getTime();
            gapsDict.put(gap.getTimeInMillis(),day.toString());
        }
        model.addAttribute("gaps",gapsDict);
        return "client/makeAppointment";
    }

    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value="/client/viewDoctors", method=RequestMethod.GET)
    public String viewDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        return "client/viewDoctors";
    }


    @RequestMapping(value="update/update-client", method=RequestMethod.POST)
    public String updateClient(@RequestParam(value="id") Integer id,
                               @RequestParam(value="fullName") String fullName,
                               @RequestParam(value="phoneNumber") String phoneNumber,
                               @RequestParam(value="email") String email,
                               @RequestParam(value="login") String login,
                               @RequestParam(value="password") String password) {
        Client clientToUpdate = new Client(fullName,phoneNumber,email,login,password);
        clientToUpdate.setId(id);
        clientService.update(clientToUpdate);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value = "/client/clientAppointments",method = RequestMethod.GET)
    public String viewAppointments(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Client client = clientService.getClientByUsername(username);
        List<Appointment> currentAppointments = appointmentService.
                getByClientId(client.getId()).stream().
                filter(a -> a.getDescription().length()!=0).
                collect(Collectors.toList());
        model.addAttribute("appointments",currentAppointments);
        return  "client/clientAppointments";
    }

    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value = "/client/clientRecords", method = RequestMethod.GET)
    public String viewRecords(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Client client = clientService.getClientByUsername(username);
        List<Record> records = recordService.getRecordsByClient(client);
        model.addAttribute("records",records);
        return "client/clientRecords";
    }

    @PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value = "client/add-record",method = RequestMethod.POST)
    public String addRecord(@RequestParam(value="doctorId") Integer doctorId,
                            @RequestParam(value= "gap") Long gap,
                            @RequestParam(value="clientId") Integer clientId){
        Record record = new Record();
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(gap);
        record.setRecordDateTime(date);
        record.setClient(clientService.getById(clientId));
        record.setDoctor(doctorService.getById(doctorId));
        Appointment appointment = new Appointment();
        appointment.setDescription("");
        appointment.setRecord(record);
        appointment.setExecutionStatus(ExecutionStatus.IN_PROGRESS);
        record.setAppointment(appointmentService.add(appointment));
        recordService.add(record);
        return "redirect:/client/clientMainPage";
    }

}
