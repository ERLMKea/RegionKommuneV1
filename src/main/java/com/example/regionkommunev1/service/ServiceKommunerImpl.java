package com.example.regionkommunev1.service;

import com.example.regionkommunev1.model.Kommune;
import com.example.regionkommunev1.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceKommunerImpl implements ServiceKommuner {


    @Autowired
    KommuneRepository kommuneRepository;

    @Override
    public List<Kommune> getKommunerStartsWith(Character c) {
        List<Kommune> kommuner = kommuneRepository.findAll();
        return kommuner.stream().filter(kom -> kom.getName().charAt(0) == c).collect(Collectors.toList());
    }
}
