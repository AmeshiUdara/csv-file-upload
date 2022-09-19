package com.ameshi.csvupload.csvupload.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @CsvBindByName(column = "Index_No")
    private String Index_No;
    @CsvBindByName(column = "mobile_phone")
    private String mobile_phone;
    @CsvBindByName(column = "message")
    private String identifierExists;
    @CsvBindByName(column = "email")
    private String email;

}
