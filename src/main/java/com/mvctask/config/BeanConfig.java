package com.mvctask.config;

import com.mvctask.service.AppointmentService;
import com.mvctask.service.ClientService;
import com.mvctask.service.DoctorService;
import com.mvctask.service.RecordService;
import com.mvctask.service.impl.AppointmentServiceImpl;
import com.mvctask.service.impl.ClientServiceImpl;
import com.mvctask.service.impl.DoctorServiceImpl;
import com.mvctask.service.impl.RecordServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ClientService clientService(){
        return new ClientServiceImpl();
    }

    /*
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
     */

    @Bean
    public DoctorService doctorService(){
        return new DoctorServiceImpl();

    }

    @Bean
    public AppointmentService appointmentService(){
        return new AppointmentServiceImpl();
    }

    @Bean
    public RecordService recordService(){
        return new RecordServiceImpl();
    }
}
