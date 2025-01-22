package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientDto;
import com.example.demo.entity.ClientEntity;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.service.ClientService;
import com.example.demo.validation.ClientValidator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//import org.apache.coyote.BadRequestException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;

    ClientController(ClientService clientService, ClientMapper clientMapper, ClientValidator clientValidator, ClientService clientService1, ClientMapper clientMapper1, ClientValidator clientValidator1)
    {
        this.clientService = clientService1;
        this.clientMapper = clientMapper1;
        this.clientValidator = clientValidator1;

    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestHeader(value = "x-Source", required = true) String source,
                                          @RequestBody CreateClientDto createClientDto)  {
        String validationResult = clientValidator.validateClient( source, createClientDto);
        if (!validationResult.equals("Success")) {
            return ResponseEntity.badRequest().body(validationResult);
        }
        ClientEntity entity = clientMapper.createClientDtoToClientEntity(createClientDto);
        Integer clientId = clientService.createClient(entity);
        return ResponseEntity.ok(clientId);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?>  getClientByClientId(@PathVariable Integer clientId) {
        ClientDto clientDto  = clientMapper.clientEntityToClientDto(clientService.getClient(clientId));
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getClientBySearch(@RequestHeader(value = "SearchString", required = true) String searchString) throws Exception {
        if (searchString.isEmpty()) {
            throw new BadRequestException("search word should not be empty");
        }
        Set<ClientEntity> clientEntitySet = clientService.searchByString(searchString);
        Set<ClientDto> clientDtoSet = new HashSet<>();
        for(ClientEntity client: clientEntitySet )
        {
            clientDtoSet.add(clientMapper.clientEntityToClientDto(client));
        }
        return new ResponseEntity(clientDtoSet, HttpStatus.OK);
    }

}
