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

    public String getSurname() {
        return surname;
    }

    public Long getBank_id() {
        return bank_id;
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

    public String getPlaceOfBitrh() {
        return placeOfBitrh;
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

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public String getResidentionAddress() {
        return residentionAddress;
    }
}