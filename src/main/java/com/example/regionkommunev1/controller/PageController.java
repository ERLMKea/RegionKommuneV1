package com.example.regionkommunev1.controller;


import com.example.regionkommunev1.model.Kommune;
import com.example.regionkommunev1.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/k4")
    public ResponseEntity<Map<String, String>> getparm(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        System.out.println("page=" + page);
        System.out.println("size=" + size);
        Map<String, String> response = new HashMap<>();
        response.put("page", ""+page);
        response.put("size", ""+size);
        return new ResponseEntity<>(response, HttpStatus.OK);
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

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    @GetMapping("kommunepagesort")
    public ResponseEntity<Map<String, Object>> getCountyPageAndSort(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "kode,desc") String[] sort) {

        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        Page<Kommune> pageCounty = kommuneRepository.findAll(pagingSort);
        List<Kommune> county = pageCounty.getContent();

        if (county.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("county", county);
        response.put("currentPage", pageCounty.getNumber());
        response.put("totalItems", pageCounty.getTotalElements());
        response.put("totalPages", pageCounty.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}



