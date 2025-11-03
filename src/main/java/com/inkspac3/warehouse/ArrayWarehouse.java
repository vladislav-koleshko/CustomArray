package com.inkspac3.warehouse;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.entity.CustomArrayData;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static volatile ArrayWarehouse instance;
    private final Map<Long, CustomArrayData> arrayParametersMap = new HashMap<>();

    private ArrayWarehouse() {}

    public static ArrayWarehouse getInstance() {
        ArrayWarehouse localInstance = instance;
        if(localInstance == null) {
            synchronized (ArrayWarehouse.class) {
                localInstance = instance;
            }
            instance = localInstance = new ArrayWarehouse();
        }
        return localInstance;
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

    public void clear() {
        arrayParametersMap.clear();
    }

}
