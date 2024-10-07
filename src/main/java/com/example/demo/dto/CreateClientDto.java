package com.example.demo.dto;

import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientDto {
    private Long bank_id;
    private String surname;
    private String name;
    private String patronymic;
    private String passport;
    private String phone;
    private String placeOfBitrh;
    private Date birthday;
    private String email;
    private String registrationAddress;
    private String residentionAddress;

}