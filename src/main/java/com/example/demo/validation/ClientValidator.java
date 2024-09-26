package com.example.demo.validation;

import com.example.demo.dto.ClientDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ClientValidator {

    @Autowired
    private Environment env;


    public void validateClient(String source, ClientDto clientDto) throws BadRequestException {
        if (env.getProperty("validator.required."+source+".name").equals("true")) {
            if (clientDto.getName().isEmpty() || clientDto.getName() == null) {
                throw new BadRequestException("Name should not be empty");
            }
        }
    }
}
