package com.chainsys.mavenlessons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;
import org.springframework.web.servlet.view.RedirectView;
@RestController
public class AppointmentControl {
    @Autowired
    private AppointmentRepository appRepo;
//	@GetMapping(value = "/fetchdoctorbyappointmentid")
//	public String getDoctorByAppointmentId(int id) {
//		Appointment app = appRepo.findById(id);
//		Doctor doc = app.getDoctor();
//		return doc.toString();
//	}
    @GetMapping(value = "/getappointmentbyid")
    public Appointment getAppointmentById(int id) {
        return appRepo.findById(id);
    }

//    @GetMapping(value = "/getappointmentbydoctor")
//    public List<Appointment> getAppointmentByDocId(int id) {
//        return appRepo.findAllByDoctorId(id);
//    }

    @GetMapping(value = "/getallappointments")
    public List<Appointment> getAllAppointments() {
        return appRepo.findAll();
    }

    @PostMapping(value = "/newappointment", consumes = "application/json")
    public RedirectView addAppointment(@RequestBody Appointment apt) {
        appRepo.save(apt);
        return new RedirectView( "/getallappointments");
    }

    @PostMapping(value = "/modifyappointment", consumes = "application/json")
    public RedirectView updateAppointment(@RequestBody Appointment apt) {
        appRepo.save(apt);
        return new RedirectView( "/getallappointments");
    }

    @DeleteMapping(value = "/removeappointment")
    public RedirectView deleteAppointment(int id) {
        appRepo.deleteById(id);
        return new RedirectView( "/getallappointments");
    }
}