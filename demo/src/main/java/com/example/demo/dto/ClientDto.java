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

public class ClientDto {

    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public Long getBankid() {
        return bankid;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getRegistrationaddress() {
        return registrationaddress;
    }

    public String getResidentionaddress() {
        return residentionaddress;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setRegistrationaddress(String registrationaddress) {
        this.registrationaddress = registrationaddress;
    }

    public void setResidentionaddress(String residentionaddress) {
        this.residentionaddress = residentionaddress;
    }
    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", bankid=" + bankid +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passport='" + passport + '\'' +
                ", phone='" + phone + '\'' +
                ", placeofbirth='" + placeofbirth + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", registrationaddress='" + registrationaddress + '\'' +
                ", residentionaddress='" + residentionaddress + '\'' +
                '}';
    }
}
