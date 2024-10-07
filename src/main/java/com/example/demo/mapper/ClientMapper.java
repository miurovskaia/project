package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientDto;
import com.example.demo.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto clientEntityToClientDto(ClientEntity clientEntity);

    ClientEntity createClientDtoToClientEntity(CreateClientDto createClientDto);
}
