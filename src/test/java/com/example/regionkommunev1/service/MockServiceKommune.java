package com.example.regionkommunev1.service;

import com.example.regionkommunev1.model.Kommune;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
public class MockServiceKommune {

    @Autowired
    ServiceKommuner serviceKommuner;

    @Test
    void getKommunerStartsWith() {
        ServiceKommuner mockserv = mock(ServiceKommuner.class);
        List<Kommune> lst = new ArrayList<>();
        lst.add(new Kommune("1085", "Roskilde"));
        when(mockserv.getKommunerStartsWith('R')).thenReturn(lst);
        lst = mockserv.getKommunerStartsWith('R');
        assertEquals(1, lst.size());

        //List<Kommune> kmns = serviceKommuner.getKommunerStartsWith('R');


    }

    @Test
    void testMockStarterMedR() {
        ServiceKommuner mockserv = mock(ServiceKommuner.class);
        List<Kommune> kommuner = mockserv.getKommunerStartsWith('R');
        assertEquals(0, kommuner.size());
        Kommune komRos = new Kommune();
        komRos.setKode("0265");
        komRos.setName("Roskilde");
        List<Kommune> someKommune = new ArrayList<>();
        someKommune.add(komRos);
        Kommune komRing = new Kommune();
        komRing.setKode("329");
        someKommune.add(komRing);

        when(mockserv.getKommunerStartsWith('R')).thenReturn(someKommune);
        List<Kommune> mockKommuner = mockserv.getKommunerStartsWith('R');
        assertEquals(true, mockKommuner.size() == 2);

    }



}