package com.leammin.leetcode.util.arg;

public interface Converter<T> {
    T convert(String str) throws ConvertException;
}

