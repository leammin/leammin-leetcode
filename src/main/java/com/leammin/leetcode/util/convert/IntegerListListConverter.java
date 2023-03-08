package com.leammin.leetcode.util.convert;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IntegerListListConverter implements Converter<List<List<Integer>>> {

    @Override
    public List<List<Integer>> convert(String str) throws ConvertException {
        if (str == null) {
            return null;
        }
        str = CharMatcher.whitespace().trimFrom(str);
        if (!str.startsWith("[")) {
            throw new ConvertException("int matrix must be start with '['");
        }
        if (!str.endsWith("]")) {
            throw new ConvertException("int matrix must be end with ']'");
        }
        str = str.substring(1, str.length() - 1);
        if (!str.startsWith("[")) {
            throw new ConvertException("int matrix must be start with '['");
        }
        if (!str.endsWith("]")) {
            throw new ConvertException("int matrix must be end with ']'");
        }
        str = str.substring(1, str.length() - 1);

        return Splitter.on(Pattern.compile("\\s*\\]\\s*,\\s*\\[\\s*"))
                .trimResults()
                .splitToList(str)
                .stream()
                .map(s -> "".equals(s) ? new ArrayList<Integer>() : Splitter.on(',')
                        .trimResults()
                        .splitToList(s)
                        .stream()
                        .map(Integer::parseInt)
                        .toList())
                .collect(Collectors.toList());
    }
}