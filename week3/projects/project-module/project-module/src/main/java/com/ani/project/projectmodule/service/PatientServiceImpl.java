package com.ani.project.projectmodule.service;

import com.ani.project.projectmodule.domain.Patient;
import com.ani.project.projectmodule.dto.PatientDto;
import com.ani.project.projectmodule.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
@Transactional
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository repository;


    @Override
    public PatientDto createPatient(PatientDto dto) {
        var patient = new Patient();
        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setMobile(dto.getMobile());
        patient.setAge(dto.getAge());
        patient.setStatus(dto.getStatus());
        patient.setLastVisited(dto.getLastVisited());
        repository.save(patient);

        return dto;
    }

    @Override
    public PatientDto updatePatientInfo(PatientDto dto){
        Patient pa1 = new Patient();
        pa1.setId(dto.getId());
        pa1.setName(dto.getName());
        pa1.setMobile(dto.getMobile());
        pa1.setAge(dto.getAge());
        pa1.setStatus(dto.getStatus());
        pa1.setLastVisited(dto.getLastVisited());

        Patient update = repository.save(pa1);
        return new PatientDto(update.getId(), update.getName(), update.getMobile(), update.getAge(), update.getStatus(),update.getLastVisited());

    }

    @Override
    public void deletePatient(int id) {
        repository.deleteById(id);

    }

    @Override
    public List<Patient> findAllRegisteredPatient() {
        return repository.findAll();

    }

    @Override
    public List<PatientDto> findAllActivePatient(boolean stats)throws IllegalArgumentException {

        List<Patient> patients = repository.findByStatusTrue();
        List<PatientDto>  dtos = new ArrayList<>();
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            PatientDto dto = new PatientDto(
                    patient.getId(),
                    patient.getName(),
                    patient.getMobile(),
                    patient.getAge(),
                    patient.getStatus(),
                    patient.getLastVisited()
            );
            dtos.add(dto);
        }
        return dtos;
    }


}

