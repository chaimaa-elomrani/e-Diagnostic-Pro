package com.hospital.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "file_dattente")
public class FileAttente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id" , nullable = false)

    private Patient patient;

    public Long getId() {
        return id;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
