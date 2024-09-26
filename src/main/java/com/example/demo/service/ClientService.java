package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientEntity getClient(Integer id) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return client;
    }

    public Set<ClientEntity> searchByString(String searchString){
        String[] searchWords = searchString.split(" ");
        List<String> searchWordsList = Arrays.asList(searchWords);
        Set<ClientEntity> clientEntitySet = new HashSet<>();
        clientEntitySet.addAll(clientRepository.findAllBySurnameIn(searchWordsList));
        clientEntitySet.addAll(clientRepository.findAllByNameIn(searchWordsList));
        clientEntitySet.addAll(clientRepository.findAllByPatronymicIn(searchWordsList));
        clientEntitySet.addAll(clientRepository.findAllByPhoneIn(searchWordsList));
        clientEntitySet.addAll(clientRepository.findAllByEmailIn(searchWordsList));
        return clientEntitySet;
    }

    public Integer createClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity).getId();
    }


}
