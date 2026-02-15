package com.leammin.leetcode.undone.hard;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;
import java.util.List;

/**
 * 126. 单词接龙 II
 *
 * <p>给定两个单词（<em>beginWord</em> 和 <em>endWord</em>）和一个字典 <em>wordList</em>，找出所有从 <em>beginWord </em>到 <em>endWord </em>的最短转换序列。转换需遵循如下规则：</p>
 *
 * <ol>
 * 	<li>每次转换只能改变一个字母。</li>
 * 	<li>转换过程中的中间单词必须是字典中的单词。</li>
 * </ol>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li>如果不存在这样的转换序列，返回一个空列表。</li>
 * 	<li>所有单词具有相同的长度。</li>
 * 	<li>所有单词只由小写字母组成。</li>
 * 	<li>字典中不存在重复的单词。</li>
 * 	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * beginWord = &quot;hit&quot;,
 * endWord = &quot;cog&quot;,
 * wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
 *
 * <strong>输出:</strong>
 * [
 *   [&quot;hit&quot;,&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;cog&quot;],
 * &nbsp; [&quot;hit&quot;,&quot;hot&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
 * ]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * beginWord = &quot;hit&quot;
 * endWord = &quot;cog&quot;
 * wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]
 *
 * <strong>输出: </strong>[]
 *
 * <strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以不存在符合要求的转换序列。</pre>
 *
 * @author Leammin
 * @date 2020-06-07
 */
public interface WordLadderIi {
    List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList);

//    class Solution implements WordLadderIi {
//
//        @Override
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            HashSet<String> wordSet = new HashSet<>(wordList);
//            Set<Character>[] wordChars = new Set[beginWord.length()];
//            for (int i = 0; i < wordChars.length; i++) {
//                wordChars[i] = new HashSet<>();
//            }
//            for (String s : wordSet) {
//                for (int i = 0; i < s.length(); i++) {
//                    wordChars[i].add(s.charAt(i));
//                }
//            }
//
//            int resSize = -1;
//            List<List<String>> res = new ArrayList<>();
//            Queue<List<String>> queue = new LinkedList<>();
//            queue.add(Collections.singletonList(beginWord));
//            while (!queue.isEmpty()) {
//                List<String> words = queue.poll();
//                if (resSize > 0 && words.size() > resSize) {
//                    return res;
//                }
//                HashSet<String> wordsSet = new HashSet<>(words);
//                System.out.println(words);
//                String word = words.get(words.size() - 1);
//                for (int i = 0; i < word.length(); i++) {
//                    for (Character c : wordChars[i]) {
//                        if (c != word.charAt(i)) {
//                            String newWord = replace(word, i, c);
//                            if (!wordsSet.contains(newWord)) {
//                                if (newWord.equals(endWord)) {
//                                    resSize = words.size();
//                                    ArrayList<String> r = new ArrayList<>(words);
//                                    r.add(newWord);
//                                    res.add(r);
//                                } else if (wordSet.contains(newWord)) {
//                                    ArrayList<String> r = new ArrayList<>(words);
//                                    r.add(newWord);
//                                    queue.add(r);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return res;
//        }
//
//        private String replace(String str, int index, char newChar) {
//            char[] chars = str.toCharArray();
//            chars[index] = newChar;
//            return new String(chars);
//        }
//    }

//    class Solution implements WordLadderIi {
//
//        @Override
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            if (beginWord.equals(endWord)) {
//                ArrayList<List<String>> lists = new ArrayList<>();
//                lists.add(new LinkedList<>(Collections.singletonList(beginWord)));
//                return lists;
//            }
//            List<String> diff1 = new ArrayList<>();
//            List<String> diff2 = new ArrayList<>();
//            for (String s : wordList) {
//                int diff = diff(s, beginWord);
//                if (diff == 1) {
//                    diff1.add(s);
//                } else if (diff > 1) {
//                    diff2.add(s);
//                }
//            }
//            List<List<String>> res = new ArrayList<>();
//            for (String s : diff1) {
//                res.addAll(findLadders(s, endWord, diff2));
//            }
//            for (List<String> re : res) {
//                re.add(0, beginWord);
//            }
//            return res;
//        }
//
//        private int diff(String a, String b) {
//            int diff = 0;
//            for (int i = 0; i < a.length(); i++) {
//                if (a.charAt(i) != b.charAt(i)) {
//                    if (++diff > 1) {
//                        return diff;
//                    }
//                }
//            }
//            return diff;
//        }
//    }

    /**
     * 15.98%
     * 90.00%
     */

    static Testsuite<WordLadderIi> testsuite() {
        return Testsuite.<WordLadderIi>builder()
                .add(VerifiableTestcase.ofConsumer(
                        t -> t.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(
                                List.of("hit", "hot", "dot", "dog", "cog"),
                                List.of("hit", "hot", "lot", "log", "cog")
                        )))
                .add(VerifiableTestcase.ofConsumer(
                        t -> t.findLadders("hit", "cog", List.of("hit", "hot", "dot", "dog", "lot", "log", "cog")),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(
                                List.of("hit", "hot", "dot", "dog", "cog"),
                                List.of("hit", "hot", "lot", "log", "cog")
                        )))
                .add(VerifiableTestcase.ofConsumer(
                        t -> t.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")),
                        r -> Assertions.assertThat(r).isEmpty()))
                .add(VerifiableTestcase.ofConsumer(
                        t -> t.findLadders("cet", "ism", List.of(
                                "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay",
                                "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay",
                                "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay",
                                "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui",
                                "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu",
                                "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal",
                                "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie",
                                "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac",
                                "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log",
                                "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib",
                                "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom",
                                "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe",
                                "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin",
                                "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen",
                                "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod",
                                "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere",
                                "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam",
                                "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum",
                                "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad",
                                "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao",
                                "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may",
                                "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava",
                                "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you",
                                "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate",
                                "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed",
                                "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah",
                                "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son",
                                "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin",
                                "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid",
                                "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin",
                                "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay",
                                "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee",
                                "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit",
                                "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw",
                                "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix",
                                "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton",
                                "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did",
                                "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov",
                                "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode",
                                "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot",
                                "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him",
                                "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com",
                                "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran",
                                "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac",
                                "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid",
                                "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib",
                                "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy",
                                "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot",
                                "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got",
                                "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob")),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(
                                List.of("cet", "get", "gee", "gte", "ate", "ats", "its", "ito", "ibo", "ibm", "ism"),
                                List.of("cet", "cot", "con", "ion", "inn", "ins", "its", "ito", "ibo", "ibm", "ism"),
                                List.of("cet", "cat", "can", "ian", "inn", "ins", "its", "ito", "ibo", "ibm", "ism")
                        )))
                .build();
    }

    class Solution2 implements WordLadderIi {

        @Override
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return findLadders(Collections.singleton(beginWord), endWord, wordList);
        }

        public List<List<String>> findLadders(Set<String> beginWord, String endWord, List<String> wordList) {
            if (beginWord.isEmpty()) {
                return new ArrayList<>();
            }
            if (beginWord.contains(endWord)) {
                ArrayList<List<String>> lists = new ArrayList<>();
                lists.add(new ArrayList<>(Collections.singletonList(endWord)));
                return lists;
            }
            Set<String> newBeginWord = new HashSet<>();
            List<String> newWordList = new ArrayList<>();
            for (String s : wordList) {
                int diff = 0;
                if (!beginWord.contains(s)) {
                    for (String b : beginWord) {
                        if ((diff = diff(s, b)) == 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    newBeginWord.add(s);
                } else if (diff > 1) {
                    newWordList.add(s);
                }
            }
            List<List<String>> res = new ArrayList<>();
            List<List<String>> ladders = findLadders(newBeginWord, endWord, newWordList);
            for (List<String> l : ladders) {
                String s = l.get(0);
                for (String b : beginWord) {
                    if (diff(s, b) == 1) {
                        ArrayList<String> re = new ArrayList<>(l.size() + 1);
                        re.add(b);
                        re.addAll(l);
                        res.add(re);
                    }
                }
            }
            return res;
        }

        private int diff(String a, String b) {
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (++diff > 1) {
                        return diff;
                    }
                }
            }
            return diff;
        }
    }
}

class WordLadderIiTest extends AbstractTest<WordLadderIi> {
}
