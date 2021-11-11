package com.mvctask.service;

import com.mvctask.model.Client;
import com.mvctask.model.Doctor;
import com.mvctask.model.Record;
import com.mvctask.model.Speciality;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Service
public interface RecordService {

    List<GregorianCalendar> GetFreeGapsByDoctorOnDay(Doctor doctor, GregorianCalendar date);

    List<GregorianCalendar> GetFreeGapsByDoctorOnWeek(Doctor doctor, GregorianCalendar dateFrom);

    Map<Doctor,List<GregorianCalendar>> GetFreeGapsByDoctorTypeOnDay(Speciality speciality, GregorianCalendar date);

    Map<Doctor,List<GregorianCalendar>> GetFreeGapsByDoctorTypeOnWeek(Speciality speciality, GregorianCalendar dateFrom);

    List<Record> GetFutureRecordsByClient(Client client);

    Record add(Record record);

    void delete(Record record);

    List<Record> getRecordsByClient(Client client);

    List<Record> getRecordsByDoctor(Doctor doctor);

}
