package com.leammin.leetcode.medium;


import java.util.*;
import java.util.function.Function;

/**
 * 638. 大礼包
 *
 * <div><p>在LeetCode商店中， 有许多在售的物品。</p>
 *
 * <p>然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。</p>
 *
 * <p>现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出<strong>确切</strong>完成待购清单的最低花费。</p>
 *
 * <p>每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。</p>
 *
 * <p>任意大礼包可无限次购买。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,5], [[3,0,5],[1,2,10]], [3,2]
 * <strong>输出:</strong> 14
 * <strong>解释:</strong>
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * <strong>输出:</strong> 11
 * <strong>解释:</strong>
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和2B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * 	<li>最多6种物品， 100种大礼包。</li>
 * 	<li>每种物品，你最多只需要购买6个。</li>
 * 	<li>你不可以购买超出待购清单的物品，即使更便宜。</li>
 * </ol>
 * </div>
 *
 * @date 2018-08-31
 * @author Leammin
 */
public class ShoppingOffers {
    private Map<List<Integer>, Integer> priceMapByNeeds = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Integer cache = priceMapByNeeds.get(needs);
        if (cache != null) {
            return cache;
        }
        int minCost = 0;
        Iterator<Integer> needsKeyIterator = needs.iterator();
        Iterator<Integer> priceIterator = price.iterator();
        while (needsKeyIterator.hasNext()) {
            minCost += priceIterator.next() * needsKeyIterator.next();
        }
        for (List<Integer> sp : special) {
            boolean tooMany = false;
            List<Integer> newNeeds = new ArrayList<>(needs.size());
            Iterator<Integer> needsIterator = needs.iterator();
            Iterator<Integer> spIterator = sp.iterator();
            while (needsIterator.hasNext()) {
                int newNeed = needsIterator.next() - spIterator.next();
                if (newNeed < 0) {
                    tooMany = true;
                    break;
                }
                newNeeds.add(newNeed);
            }
            if (tooMany) {
                continue;
            }
            int cost = spIterator.next() + shoppingOffers(price, special, newNeeds);
            if (cost < minCost) {
                minCost = cost;
            }
        }
        priceMapByNeeds.put(needs, minCost);
        return minCost;
    }
}
