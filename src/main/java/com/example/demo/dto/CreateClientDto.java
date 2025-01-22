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
    private Long bankid;
    private String surname;
    private String name;
    private String patronymic;
    private String passport;
    private String phone;
    private String placeofbirth;
    private Date birthday;
    private String email;
    private String registrationaddress;
    private String residentionaddress;

    public String getSurname() {
        return surname;
    }

    public Long getbankid() {
        return bankid;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public String getplaceofbirth() {
        return placeofbirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getregistrationaddress() {
        return registrationaddress;
    }

    public String getresidentionaddress() {
        return residentionaddress;
    }
}