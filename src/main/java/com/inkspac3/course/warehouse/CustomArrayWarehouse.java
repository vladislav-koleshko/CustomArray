package com.inkspac3.course.warehouse;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.entity.CustomArrayData;

import java.util.HashMap;
import java.util.Map;


public class CustomArrayWarehouse {
    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArrayData> arrayParametersMap = new HashMap<>();

    private CustomArrayWarehouse() {}

    public static CustomArrayWarehouse getInstance() {
        if(instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public CustomArrayData get(long id) {
        return arrayParametersMap.get(id);
    }

    public void put(CustomArray array, CustomArrayData parameters) {
        arrayParametersMap.put(array.getId(), parameters);
    }

    public void remove(long id) {
        arrayParametersMap.remove(id);
    }

}

