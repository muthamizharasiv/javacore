package com.ani.project.projectmodule.repository;


import com.ani.project.projectmodule.domain.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientRepositoryTests {
    @Autowired
    private PatientRepository repository;

    @DisplayName("Patient Repo: Creating Patient")
    @Test
    public void testCreatePatient(){
        var patient = new Patient();
        patient.setId(10);
        patient.setName("patient");
        repository.save(patient);
    }
}
