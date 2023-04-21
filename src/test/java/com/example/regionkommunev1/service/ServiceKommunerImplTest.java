package com.example.regionkommunev1.service;

import com.example.regionkommunev1.model.Kommune;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceKommunerImplTest {

    @Autowired
    ServiceKommuner serviceKommuner;

    @Test
    void getKommunerStartsWith() {
        List<Kommune> kmns = serviceKommuner.getKommunerStartsWith('R');
        assertEquals(7, kmns.size());
    }

    @Test
    void getKommunerStartsWith0() {
        List<Kommune> kmns = serviceKommuner.getKommunerStartsWith('r');
        assertEquals(0, kmns.size());
    }

}