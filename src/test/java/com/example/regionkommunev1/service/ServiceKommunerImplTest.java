package com.example.regionkommunev1.service;

import com.example.regionkommunev1.model.Kommune;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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


    @ParameterizedTest
    @ValueSource(chars = {'B', 'D', 'G', 'R','K'}) // five letters
    void testLastDigitParam(char letter) {
        List<Kommune> kommuner = serviceKommuner.getKommunerStartsWith(letter);
        assertNotEquals(0, kommuner.size());
        assertEquals(true, kommuner.size()<100);
        Kommune kommune = kommuner.get(0);
        String str = kommune.getName();
        char firstLetter = str.substring(0,1).charAt(0);
        assertEquals(letter, firstLetter);
    }

}