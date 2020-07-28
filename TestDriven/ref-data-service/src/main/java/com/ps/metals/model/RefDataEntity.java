package com.ps.metals.model;

import org.apache.commons.lang.StringUtils;

import java.util.Optional;


public enum RefDataEntity {
    COMMODITY("commodity"), LOCATION("location"), COUNTER_PARTY("counterParty");

    private String name;

    RefDataEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<RefDataEntity> byName(String name) {
        for (RefDataEntity value : RefDataEntity.values()) {
            if (StringUtils.equals(value.getName(), name)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
