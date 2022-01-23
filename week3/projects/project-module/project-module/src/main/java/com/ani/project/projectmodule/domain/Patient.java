package com.ani.project.projectmodule.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @NotNull
    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = true)
    private String mobile;

    @Column(unique = false, nullable = false)
    private Integer age;

    @NotNull
    @Column(unique = false, nullable = false)
    private Boolean status;

    @Column(unique = false, nullable = true)
    private LocalDate lastVisited;

}
