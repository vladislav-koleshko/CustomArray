package com.inkspac3.course.service.stream;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.exception.CustomArrayException;

public interface MinMaxStreamService {
    String getMin(CustomArray array) throws CustomArrayException;
    String getMax(CustomArray array) throws CustomArrayException;
}
