package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.ClientEntity;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.service.ClientService;
import com.example.demo.validation.ClientValidator;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestHeader(value = "x-Source", required = true) String source,
                                          @RequestBody ClientDto clientDto) throws BadRequestException {
        clientValidator.validateClient( source,clientDto);
        ClientEntity entity = clientMapper.clientDtoToClientEntity(clientDto);
       // Integer fileId = clientService.createClient(entity);
        clientService.createClient(entity);
/*
        if (errors.isPresent()) {
            return ResponseEntity.badRequest().body(errors.get().getBody());
        }

 */
        //return ResponseEntity.ok(fileId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ClientDto getClientByClientId(@PathVariable Integer clientId) {
        return clientMapper.clientEntityToClientDto(clientService.getClient(clientId));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getClientBySearch(@RequestHeader(value = "searchString", required = true) String searchString) {
        if (searchString.isEmpty()) {
            throw new RuntimeException("search word should not be empty");
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
