package com.leammin.leetcode.util.convert;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerListConverter implements Converter<List<Integer>> {

    @Override
    public List<Integer> convert(String str) throws ConvertException {
        if (str == null) {
            return null;
        }
        str = CharMatcher.whitespace().trimFrom(str);
        if (!str.startsWith("[")) {
            throw new ConvertException("int array must be start with '['");
        }
        if (!str.endsWith("]")) {
            throw new ConvertException("int array must be end with ']'");
        }
        str = str.substring(1, str.length() - 1);
        if (str.equals("")) {
            return new ArrayList<>();
        }

        return Splitter.on(',').trimResults().splitToList(str)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
