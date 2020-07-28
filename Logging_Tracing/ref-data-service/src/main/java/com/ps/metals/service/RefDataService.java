package com.ps.metals.service;

import java.util.List;
import java.util.Optional;

public  interface RefDataService<T> {
    List<T> getRefData();
    Optional<T> getByCode(String code);
}
