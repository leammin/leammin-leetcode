package com.leammin.leetcode.util.arg;

import com.google.common.base.CharMatcher;

public class IntMatrixConverter implements Converter<int[][]> {
    @Override
    public int[][] convert(String str) throws ConvertException {
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

        // TODO

        return new int[0][];
    }
}
