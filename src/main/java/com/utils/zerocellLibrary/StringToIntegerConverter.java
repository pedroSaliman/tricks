package com.utils.zerocellLibrary;

import com.creditdatamw.zerocell.converter.Converter;

public class StringToIntegerConverter implements Converter<Integer> {
    @Override
    public Integer convert(String value, String s1, int i) {
        return Integer.parseInt(value);
    }
}
