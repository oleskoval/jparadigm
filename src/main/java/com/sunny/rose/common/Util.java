package com.sunny.rose.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** 10.02.12  23:40 */

public class Util
{
    public static <T> List<T> convertSet(Set<T> set)
    {
        List<T> listValues = new ArrayList<T>();
        for (T value : set)
        {
            listValues.add(value);
        }
        return listValues;
    }
}
