package com.ps.metals.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COUNTER_PARTY")
public class CounterParty implements Serializable {
    @Id
    private String code;
    private String name;

    public CounterParty() {
    }

    public CounterParty(String code, String name) {
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
