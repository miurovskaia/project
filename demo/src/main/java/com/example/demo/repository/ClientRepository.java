package com.example.demo.repository;

import com.example.demo.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ClientRepository extends JpaRepository<ClientEntity, String> {

        Optional<ClientEntity> findById(Integer id);

        Set<ClientEntity> findAllBySurnameIn(List<String> searchWords);
        Set<ClientEntity> findAllByNameIn(List<String> searchWords);
        Set<ClientEntity> findAllByPatronymicIn(List<String> searchWords);
        Set<ClientEntity> findAllByPhoneIn(List<String> searchWords);
        Set<ClientEntity> findAllByEmailIn(List<String> searchWords);

    }


