package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "client")
public class ClientEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private Integer id;


        private Long bankid;
        private String surname;
        private String name;
        private String patronymic;
        //маска
        private String passport;
        //маска
        private String phone;
        private String placeofbirth;
        @Temporal(TemporalType.DATE)
        private Date birthday;
        private String email;
        private String registrationaddress;
        private String residentionaddress;

        public ClientEntity() {
        }

        public ClientEntity(Integer id, String surname, Long bankid, String name, String patronymic, String phone, String passport, String placeofbirth, String email, Date birthday, String registrationaddress, String residentionaddress) {
                this.id = id;
                this.surname = surname;
                this.bankid = bankid;
                this.name = name;
                this.patronymic = patronymic;
                this.phone = phone;
                this.passport = passport;
                this.placeofbirth = placeofbirth;
                this.email = email;
                this.birthday = birthday;
                this.registrationaddress = registrationaddress;
                this.residentionaddress = residentionaddress;
        }

        public Integer getId() {
                return id;
        }

        public String getSurname() {
                return surname;
        }

        public Long getbankid() {
                return bankid;
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

        public String getplaceofbirth() {
                return placeofbirth;
        }

        public Date getBirthday() {
                return birthday;
        }

        public String getEmail() {
                return email;
        }

        public String getregistrationaddress() {
                return registrationaddress;
        }

        public String getresidentionaddress() {
                return residentionaddress;
        }
        public void setId(Integer id) {
                this.id = id;
        }

        public void setResidentionaddress(String residentionaddress) {
                this.residentionaddress = residentionaddress;
        }

        public void setRegistrationaddress(String registrationaddress) {
                this.registrationaddress = registrationaddress;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        public void setPlaceofbirth(String placeofbirth) {
                this.placeofbirth = placeofbirth;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public void setPassport(String passport) {
                this.passport = passport;
        }

        public void setPatronymic(String patronymic) {
                this.patronymic = patronymic;
        }

        public void setName(String name) {
                this.name = name;
        }
        public void setBankid(Long bankid) {
                this.bankid = bankid;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }


}
