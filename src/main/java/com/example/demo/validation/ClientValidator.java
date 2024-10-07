package com.example.demo.validation;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Optional;

public class ClientValidator {

    @Autowired
    private Environment env;


    public String validateClient(String source, CreateClientDto createClientDto)  {
        if (env.getProperty("validator.required."+source+".name").equals("true")) {
            if (createClientDto.getName().isEmpty() || createClientDto.getName() == null) {
                return new String("Name should not be empty");
            }
        }
        return "Success";
    }
}
