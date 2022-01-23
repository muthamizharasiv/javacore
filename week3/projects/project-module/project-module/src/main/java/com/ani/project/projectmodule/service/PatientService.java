package com.ani.project.projectmodule.service;

import com.ani.project.projectmodule.domain.Patient;
import com.ani.project.projectmodule.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto dto);

    PatientDto updatePatientInfo(PatientDto dto);

    void deletePatient(int id);

    List<Patient> findAllRegisteredPatient();

    List<PatientDto>findAllActivePatient(boolean stats);


}
