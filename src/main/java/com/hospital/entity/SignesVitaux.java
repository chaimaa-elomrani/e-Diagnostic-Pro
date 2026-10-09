package com.hospital.entity;


import jakarta.persistence.*;

@Entity
    @Table(name = "signe_vitaux")
    public class SignesVitaux {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

        private Double tensionSystolique;
        private Double tensionDiastolique;
        private Integer frequenceCardiaque;
        private Double temperature;
        private Integer frequenceRespiratoire;
        private Double poids;
        private Double taille;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", nullable = false)

        private Patient patient ;

    public Long getId() {
        return id;
    }

    public Double getTensionSystolique() {
        return tensionSystolique;
    }

    public Double getTensionDiastolique() {
        return tensionDiastolique;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Integer getFrequenceCardiaque() {
        return frequenceCardiaque;
    }

    public Integer getFrequenceRespiratoire() {
        return frequenceRespiratoire;
    }

    public Double getPoids() {
        return poids;
    }

    public Double getTaille() {
        return taille;
    }


    public void setTensionSystolique(Double tensionSystolique) {
        this.tensionSystolique = tensionSystolique;
    }

    public void setTensionDiastolique(Double tensionDiastolique) {
        this.tensionDiastolique = tensionDiastolique;
    }

    public void setFrequenceCardiaque(Integer frequenceCardiaque) {
        this.frequenceCardiaque = frequenceCardiaque;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setFrequenceRespiratoire(Integer frequenceRespiratoire) {
        this.frequenceRespiratoire = frequenceRespiratoire;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }



    }
