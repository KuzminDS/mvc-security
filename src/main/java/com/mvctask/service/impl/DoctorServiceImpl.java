package com.mvctask.service.impl;

import com.mvctask.repository.DoctorRepository;
import com.mvctask.model.Doctor;
import com.mvctask.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor add(Doctor doctor) {
         return doctorRepository.save(doctor);
    }

    @Override
    public void delete(int id) {
        doctorRepository.delete(id);
    }

    @Override
    public Doctor update(Doctor doctor) {
       return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorByUsername(String username) {
        return  doctorRepository.findAll().stream().filter(d->d.getLogin().equals(username)).findFirst().orElse(null);
    }
}
