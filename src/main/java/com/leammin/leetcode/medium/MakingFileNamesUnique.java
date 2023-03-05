package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/making-file-names-unique/">1487. 保证文件名唯一</a>
 *
 * <p>给你一个长度为 <code>n</code> 的字符串数组 <code>names</code> 。你将会在文件系统中创建 <code>n</code> 个文件夹：在第 <code>i</code> 分钟，新建名为 <code>names[i]</code> 的文件夹。</p>
 *
 * <p>由于两个文件 <strong>不能</strong> 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 <code>(k)</code> 的形式为新文件夹的文件名添加后缀，其中 <code>k</code> 是能保证文件名唯一的 <strong>最小正整数</strong> 。</p>
 *
 * <p>返回长度为<em> <code>n</code></em> 的字符串数组，其中 <code>ans[i]</code> 是创建第 <code>i</code> 个文件夹时系统分配给该文件夹的实际名称。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>names = [&quot;pes&quot;,&quot;fifa&quot;,&quot;gta&quot;,&quot;pes(2019)&quot;]
 * <strong>输出：</strong>[&quot;pes&quot;,&quot;fifa&quot;,&quot;gta&quot;,&quot;pes(2019)&quot;]
 * <strong>解释：</strong>文件系统将会这样创建文件名：
 * &quot;pes&quot; --&gt; 之前未分配，仍为 &quot;pes&quot;
 * &quot;fifa&quot; --&gt; 之前未分配，仍为 &quot;fifa&quot;
 * &quot;gta&quot; --&gt; 之前未分配，仍为 &quot;gta&quot;
 * &quot;pes(2019)&quot; --&gt; 之前未分配，仍为 &quot;pes(2019)&quot;
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>names = [&quot;gta&quot;,&quot;gta(1)&quot;,&quot;gta&quot;,&quot;avalon&quot;]
 * <strong>输出：</strong>[&quot;gta&quot;,&quot;gta(1)&quot;,&quot;gta(2)&quot;,&quot;avalon&quot;]
 * <strong>解释：</strong>文件系统将会这样创建文件名：
 * &quot;gta&quot; --&gt; 之前未分配，仍为 &quot;gta&quot;
 * &quot;gta(1)&quot; --&gt; 之前未分配，仍为 &quot;gta(1)&quot;
 * &quot;gta&quot; --&gt; 文件名被占用，系统为该名称添加后缀 (k)，由于 &quot;gta(1)&quot; 也被占用，所以 k = 2 。实际创建的文件名为 &quot;gta(2)&quot; 。
 * &quot;avalon&quot; --&gt; 之前未分配，仍为 &quot;avalon&quot;
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>names = [&quot;onepiece&quot;,&quot;onepiece(1)&quot;,&quot;onepiece(2)&quot;,&quot;onepiece(3)&quot;,&quot;onepiece&quot;]
 * <strong>输出：</strong>[&quot;onepiece&quot;,&quot;onepiece(1)&quot;,&quot;onepiece(2)&quot;,&quot;onepiece(3)&quot;,&quot;onepiece(4)&quot;]
 * <strong>解释：</strong>当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 &quot;onepiece(4)&quot;。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>names = [&quot;wano&quot;,&quot;wano&quot;,&quot;wano&quot;,&quot;wano&quot;]
 * <strong>输出：</strong>[&quot;wano&quot;,&quot;wano(1)&quot;,&quot;wano(2)&quot;,&quot;wano(3)&quot;]
 * <strong>解释：</strong>每次创建文件夹 &quot;wano&quot; 时，只需增加后缀中 k 的值即可。</pre>
 *
 * <p><strong>示例 5：</strong></p>
 *
 * <pre><strong>输入：</strong>names = [&quot;kaido&quot;,&quot;kaido(1)&quot;,&quot;kaido&quot;,&quot;kaido(1)&quot;]
 * <strong>输出：</strong>[&quot;kaido&quot;,&quot;kaido(1)&quot;,&quot;kaido(2)&quot;,&quot;kaido(1)(1)&quot;]
 * <strong>解释：</strong>注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= names.length &lt;= 5 * 10^4</code></li>
 * 	<li><code>1 &lt;= names[i].length &lt;= 20</code></li>
 * 	<li><code>names[i]</code> 由小写英文字母、数字和/或圆括号组成。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-03
 */
public interface MakingFileNamesUnique {
    String[] getFolderNames(String[] names);

    static Testsuite<MakingFileNamesUnique> testsuite() {
        return Testsuite.<MakingFileNamesUnique>builder()
                .addExpected(t -> t.getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"}), new String[]{"pes", "fifa", "gta", "pes(2019)"})
                .addExpected(t -> t.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}), new String[]{"gta", "gta(1)", "gta(2)", "avalon"})
                .addExpected(t -> t.getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}), new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"})
                .addExpected(t -> t.getFolderNames(new String[]{"onepiece", "onepiece(01)", "onepiece(2)", "onepiece(3)", "onepiece"}), new String[]{"onepiece", "onepiece(01)", "onepiece(2)", "onepiece(3)", "onepiece(1)"})
                .addExpected(t -> t.getFolderNames(new String[]{"wano", "wano", "wano", "wano"}), new String[]{"wano", "wano(1)", "wano(2)", "wano(3)"})
                .addExpected(t -> t.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}), new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"})
                .addExpected(t -> t.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"}), new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)", "kaido(2)(1)"})
                .build();
    }

    class Solution implements MakingFileNamesUnique {

        @Override
        public String[] getFolderNames(String[] names) {
            String[] res = new String[names.length];
            Map<String, Set<Integer>> used = new HashMap<>();
            Map<String, Integer> next = new HashMap<>();
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                int k = getK(name);
                if (k > 0) {
                    String x = name.substring(0, name.lastIndexOf("("));
                    int n = next.getOrDefault(x, 0);
                    if (k >= n) {
                        Set<Integer> usedX = used.computeIfAbsent(x, key -> new HashSet<>());
                        if (!usedX.contains(k)) {
                            res[i] = names[i];
                            next.put(names[i], 1);
                            usedX.add(k);
                            continue;
                        }
                    }
                }
                int n = next.getOrDefault(names[i], 0);
                while (used.getOrDefault(names[i], Collections.emptySet()).contains(n)) {
                    n++;
                }
                if (n > 0) {
                    res[i] = names[i] + "(" + n + ")";
                    next.put(res[i], 1);
                } else {
                    res[i] = names[i];
                }
                next.put(names[i], n + 1);
            }
            return res;
        }

        private int getK(String name) {
            if (name.charAt(name.length() - 1) != ')') {
                return 0;
            }
            int k = 0;
            int r = 1;
            for (int i = name.length() - 2; i >= 0; i--) {
                char c = name.charAt(i);
                if (c == '(') {
                    if (k > 0 && name.charAt(i + 1) == '0') {
                        return 0;
                    }
                    return k;
                }
                if (c < '0' || c > '9') {
                    return 0;
                }
                k += (c - '0') * r;
                r *= 10;
            }
            return 0;
        }
    }
}
