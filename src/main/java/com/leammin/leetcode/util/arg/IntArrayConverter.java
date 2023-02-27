package com.leammin.leetcode.util.arg;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class IntArrayConverter implements Converter<int[]> {

    @Override
    public int[] convert(String str) throws ConvertException {
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
            return new int[0];
        }

        return Splitter.on(',').trimResults().splitToList(str)
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
