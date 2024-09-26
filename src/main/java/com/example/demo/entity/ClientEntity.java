package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
        private Integer id;
        private Long bank_id;
        private String surname;
        private String name;
        private String patronymic;
        //маска
        private String passport;
        //маска
        private String phone;
        private String placeOfBitrh;
        @Temporal(TemporalType.DATE)
        private Date birthday;
        private String email;
        private String registrationAddress;
        private String residentionAddress;


}
