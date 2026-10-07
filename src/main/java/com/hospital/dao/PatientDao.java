package com.hospital.dao;

import com.hospital.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PatientDao {

    private final EntityManager entityManager;

    public PatientDao(EntityManager entityManager) {
        this.entityManager = Objects.requireNonNull(entityManager);
    }

    public boolean save(Patient patient) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(patient);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Optional<Patient> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Patient.class, id));
    }

    public Optional<Patient> findBySocialSecurityNumber(String socialSecurityNumber) {
        List<Patient> patients = entityManager
                .createQuery(
                        "SELECT p FROM Patient p WHERE p.socialSecurityNumber = :number",
                        Patient.class)
                .setParameter("number", socialSecurityNumber)
                .getResultList();

        if (patients.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(patients.get(0));
    }


    public List<Patient> findAll() {
        return entityManager
                .createQuery("SELECT p FROM Patient p", Patient.class)
                .getResultList();
    }


    public List<Patient> findTodayPatients() {
        return entityManager
                .createQuery(
                        "SELECT p FROM Patient p WHERE p.createdAt >= :today",
                        Patient.class)
                .setParameter("today", LocalDate.now().atStartOfDay())
                .getResultList();
    }
}
