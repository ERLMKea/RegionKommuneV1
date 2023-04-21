package com.example.regionkommunev1.service;


import com.example.regionkommunev1.model.Kommune;

import java.util.List;

public interface ServiceKommuner {
    List<Kommune> getKommunerStartsWith(Character c);
}
