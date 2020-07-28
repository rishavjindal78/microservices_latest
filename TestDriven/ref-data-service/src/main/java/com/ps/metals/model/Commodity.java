package com.ps.metals.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMMODITY")
public class Commodity implements RefData, Serializable {
    @Id
    private String code;
    private String name;

    public Commodity() {
    }

    public Commodity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
