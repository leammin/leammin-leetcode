package com.leammin.leetcode.util.convert;

public interface Converter<T> {
    T convert(String str) throws ConvertException;
}

