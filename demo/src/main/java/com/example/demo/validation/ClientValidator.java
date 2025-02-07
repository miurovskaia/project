package com.example.demo.validation;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientValidator {

    @Autowired
    private Environment env;


    public String validateClient(String source, CreateClientDto createClientDto)  {
        if(env.containsProperty("validator.required." + source + ".name")) {
            if (env.getProperty("validator.required." + source + ".name").equals("true")) {
                if (createClientDto.getName() == null || createClientDto.getName().isEmpty()) {
                    return new String("Name should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source+".email")) {
            if (env.getProperty("validator.required." + source + ".email").equals("true")) {
                if (createClientDto.getEmail() == null || createClientDto.getEmail().isEmpty()) {
                    return new String("Email should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".phone")) {
            if (env.getProperty("validator.required." + source + ".phone").equals("true")) {
                if (createClientDto.getPhone() == null || createClientDto.getPhone().isEmpty()) {
                    return new String("Phone should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".bank_id")) {
            if (env.getProperty("validator.required." + source + ".bank_id").equals("true")) {
                if (createClientDto.getbankid() == null) {
                    return new String("Bank id should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".surname")) {
            if (env.getProperty("validator.required." + source + ".surname").equals("true")) {
                if (createClientDto.getSurname() == null || createClientDto.getSurname().isEmpty()) {
                    return new String("Surname should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".patronymic")) {
            if (env.getProperty("validator.required." + source + ".patronymic").equals("true")) {
                if (createClientDto.getPatronymic() == null || createClientDto.getPatronymic().isEmpty()) {
                    return new String("Patronymic should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".birthday")) {
            if (env.getProperty("validator.required." + source + ".birthday").equals("true")) {
                if (createClientDto.getBirthday() == null) {
                    return new String("Birthday should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".passport")) {
            if (env.getProperty("validator.required." + source + ".passport").equals("true")) {
                if (createClientDto.getPassport() == null || createClientDto.getPassport().isEmpty()) {
                    return new String("Passport should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".placeofbirth")) {
            if (env.getProperty("validator.required." + source + ".placeofbirth").equals("true")) {
                if (createClientDto.getplaceofbirth() == null || createClientDto.getplaceofbirth().isEmpty()) {
                    return new String("Place of birth field should not be empty");
                }
            }
        }
        if(env.containsProperty("validator.required." + source + ".registrationaddress")) {
            if (env.getProperty("validator.required." + source + ".registrationaddress").equals("true")) {
                if (createClientDto.getregistrationaddress() == null || createClientDto.getregistrationaddress().isEmpty()) {
                    return new String("Registration address field should not be empty");
                }
            }
        }


        if (!createClientDto.getPassport().matches("^(\\d{4}\\s\\d{6})?$")) {
            return new String("Incorrect format of passport number");
        }

        if (!createClientDto.getPhone().matches("^([7]{1}[0-9]{10})?$")) {
            return new String("Incorrect format of phone number");
        }

        return "Success";
    }
}
