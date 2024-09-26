package com.example.demo.validation;

import com.example.demo.dto.ClientDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Optional;

public class ClientValidator {

    @Autowired
    private Environment env;


    public String validateClient(String source, ClientDto clientDto)  {
        if (env.getProperty("validator.required."+source+".name").equals("true")) {
            if (clientDto.getName().isEmpty() || clientDto.getName() == null) {
                return new String("Name should not be empty");
            }
        }
        return "Success";
    }
}
