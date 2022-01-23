package com.ani.project.projectmodule.repository;

import com.ani.project.projectmodule.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Modifying
    @Query(value = "update patient set id,name,mobile,age,status,last_visited where id= :id", nativeQuery = true)
    void updatePatientInfo(@Param("id") int id);

    @Modifying
    @Query(value = "delete from patient where id = :id", nativeQuery = true)
    void deletePatient(@Param("id") int id);


    void deleteById(int id);


     @Query(value = "select * from patient where status = :stats", nativeQuery = true)
     void allActivePatient(@Param("stats")boolean stats);


    List<Patient> findByStatusTrue();
}

