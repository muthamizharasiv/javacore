package com.ani.project.projectmodule.controller;

import com.ani.project.projectmodule.domain.Patient;
import com.ani.project.projectmodule.dto.AppResponse;
import com.ani.project.projectmodule.dto.PatientDto;
import com.ani.project.projectmodule.service.PatientService;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/patient")
@RestController
public class PatientController {


    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<AppResponse<PatientDto>> createPatient(@Valid @RequestBody PatientDto dto) {
        var svObj = service.createPatient(dto);
        var response = new AppResponse<PatientDto>();
        response.setStatus("success");
        response.setMessage("Patient saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<PatientDto>> updatePatientInfo(@RequestBody PatientDto dto) {
        PatientDto svObj1 = service.updatePatientInfo(dto);
        var response = new AppResponse<PatientDto>();
        response.setStatus("success");
        response.setMessage("patient updated");
        response.setBody(svObj1);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppResponse<Integer>> deletePatient(@PathVariable int id) {
        service.deletePatient(id);
        var response = new AppResponse<Integer>();
        response.setStatus("success");
        response.setMessage("Deleted patient successfully");
        response.setBody(1);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findall")
    public ResponseEntity<AppResponse<List<Patient>>> findAll() {
        var response = new AppResponse<List<Patient>>();
        response.setStatus("success");
        response.setMessage("List of all registered patient");
        response.setBody(service.findAllRegisteredPatient());

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{stats}")
    public ResponseEntity<AppResponse<List>> allActivePatient(@PathVariable boolean stats) throws UnsatisfiedDependencyException {
        service.findAllActivePatient(true);
        var response = new AppResponse<List>();
        response.setStatus("success");
        response.setMessage("list of active patient");
        response.setBody(service.findAllActivePatient(true));

        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for(ObjectError oe : errors) {
            FieldError fe = (FieldError) oe;

            String errorField = fe.getField();
            String errorMessage = fe.getDefaultMessage();

            messages.put(errorField, errorMessage);
        }

        return messages;
    }
}


