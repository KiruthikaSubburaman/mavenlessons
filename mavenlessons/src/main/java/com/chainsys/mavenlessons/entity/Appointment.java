package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name = "app_id")
	private int app_id;
	private Date app_date;
	private int doctor_id;
	private String patient_name;
	private int fees_collected;
	private String fees_nature;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false, 
	insertable = false, updatable = false)
	@JsonIgnore
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doc) {
		this.doctor = doc;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public Date getApp_date() {
		return app_date;
	}

	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public int getFees_collected() {
		return fees_collected;
	}

	public void setFees_collected(int fees_collected) {
		this.fees_collected = fees_collected;
	}

	public String getFees_nature() {
		return fees_nature;
	}

	public void setFees_nature(String fees_nature) {
		this.fees_nature = fees_nature;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %d, %s, %d, %s",app_id,app_date,doctor_id,patient_name,fees_collected,fees_nature);
	}

}
