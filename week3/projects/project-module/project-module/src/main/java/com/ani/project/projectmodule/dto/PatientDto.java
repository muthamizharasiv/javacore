package com.ani.project.projectmodule.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class PatientDto {
    private int id;

    @NotBlank
    @NotNull
    private  String name;
    private String mobile;
    private Integer age;

    @NotNull
    private Boolean status;
    private LocalDate lastVisited;



    }


