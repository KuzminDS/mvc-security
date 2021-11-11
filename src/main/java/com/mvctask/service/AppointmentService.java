package com.mvctask.service;

import com.mvctask.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService{

    Appointment add(Appointment appointment);

    Appointment update(Appointment appointment);

    Appointment getById(int id);

    List<Appointment> getByClientId(int id);

    List<Appointment> getByDoctorId(int id);

}
