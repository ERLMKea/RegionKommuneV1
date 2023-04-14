package com.example.regionkommunev1.controller;


import com.example.regionkommunev1.model.Kommune;
import com.example.regionkommunev1.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PageController {

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/kommunepage")
    public ResponseEntity<List<Kommune>> getPageOfCounties() {
        int page = 0;
        int size = 5;
        PageRequest kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageCounty = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstCounties = pageCounty.getContent();
        if (lstCounties.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(lstCounties, HttpStatus.OK);
    }


    @GetMapping("/k2")
    public ResponseEntity<List<Kommune>> getPageOf2() {
        int page = 0;
        int size = 5;
        PageRequest kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageCounty = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstCounties = pageCounty.getContent();
        return new ResponseEntity<>(lstCounties, HttpStatus.OK);
    }


    @GetMapping("/kommunepageparm")
    public ResponseEntity<Map<String, Object>> getPageOfKommuner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(paging);

        List<Kommune> kommuner = pageKommune.getContent();

        if (kommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("kommuner", kommuner);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}



