package com.example.regionkommunev1;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Mock1 {

    @Test
    void testInlineMap() {
        Map<Integer,String> mapKommuner = new HashMap<>();
        mapKommuner.put(1085, "Roskilde");
        String str = mapKommuner.get(1085);
        System.out.println(str);
        assertEquals("Roskilde", str);
    }

    @Test
    void testInlineMockMap() {
        Map<Integer, String> mapMock = mock(Map.class);
        mapMock.put(1085, "Roskilde");
        String str = mapMock.get(1085);
        System.out.println(str);
        assertTrue(mapMock.size()>0);
        //assertEquals("Roskilde", str);
    }

    @Test
    void testInlineMockMapWhen() {
        Map<Integer, String> mapMock = mock(Map.class);
        when(mapMock.get(1085)).thenReturn("Roskilde");
        //mapMock.put(1085, "Roskilde");
        String str = mapMock.get(1085);
        System.out.println(str);
        //assertTrue(mapMock.size()>0); still size = 0
        assertEquals("Roskilde", str);
    }

    @Test
    void testListThenThen() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3, listMock.size());
    }

}



