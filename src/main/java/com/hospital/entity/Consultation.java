package com.hospital.entity;

import com.hospital.enums.ConsultationStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;


    private String motif;

    private String observations;

    private String diagnostic;

    private String traitement;

    private BigDecimal cout;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ConsultationStatus status ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id" , nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generaliste_id" , nullable = false)
    private User  generaliste;

    public Long getId() {
        return id;
    }

    public String getMotif() {
        return motif;
    }

    public String getObservations() {
        return observations;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public BigDecimal getCout() {
        return cout;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ConsultationStatus getStatus() {
        return status;
    }

    public Patient getPatient() {
        return patient;
    }

    public User getGeneraliste() {
        return generaliste;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public void setCout(BigDecimal cout) {
        this.cout = cout;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(ConsultationStatus status) {
        this.status = status;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setGeneraliste(User generaliste) {
        this.generaliste = generaliste;
    }
}
