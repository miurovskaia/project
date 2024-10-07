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
        private Long bankId;
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
