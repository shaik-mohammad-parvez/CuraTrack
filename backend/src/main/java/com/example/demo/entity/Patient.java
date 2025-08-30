package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.example.demo.entity.enums.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor   // Required by JPA & Jackson
@AllArgsConstructor  // Full constructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Entity
@Table(name = "aapatient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AA_PATIENT_SEQ")
    @SequenceGenerator(sequenceName = "AA_PATIENT_SEQ", allocationSize = 1, name = "AA_PATIENT_SEQ")
    @Column(name = "patientid")
    private Long patientid;

    private String name;
    private String lastname;
    private String phoneNo;
    private Date bornDate;
    private String gender;

    @Enumerated(EnumType.ORDINAL)
    private City city;

    @Column(name = "email", unique = true)
    private String email;

    private int status;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Problem> problems;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Admission> admissions;

    // ⚡ Remove weird "String age" constructor
    // If you want a custom partial constructor, define only valid fields, e.g.:
    public Patient(String name, String lastname, String gender, City city, String email, int status) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.status = status;
    }
}
