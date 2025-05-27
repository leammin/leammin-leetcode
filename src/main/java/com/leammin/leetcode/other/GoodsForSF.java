package com.leammin.leetcode.other;

import com.leammin.leetcode.medium.ArithmeticSlices;

import java.math.BigInteger;
import java.util.*;

public interface GoodsForSF {
    class Container {
        int row;
        int column;
        int[][] blocks;
    }

    class Goods {
        String index;
        int weight;
        int[][] shape;
    }

    String[][] goods(Container container, Goods[] objects);

    class Solution implements GoodsForSF {

        static class GoodsModel {
            static int index = 0;

            int id;
            Goods goods;
            int[][] shape;
            BigInteger scope;

            private GoodsModel(Goods goods, int[][] shape) {
                this.id = index++;
                this.goods = goods;
                this.shape = shape;
                this.scope = calculateScope(shape);
            }

            static List<GoodsModel> newGoodsModel(Goods goods) {
                Map<BigInteger, GoodsModel> map = new HashMap<>();
                int[][] shape = goods.shape;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 4; j++) {
                        GoodsModel goodsModel = new GoodsModel(goods, shape);
                        map.put(goodsModel.scope, goodsModel);
                        shape = rotate(shape);
                    }
                    shape = turn(shape);
                }
                return List.copyOf(map.values());
            }
        }

        static class ContainerModel {
            BigInteger scope;

            ContainerModel(Container container) {
                this.scope = BigInteger.ONE;
                for (int i = 0; i < container.blocks.length; i++) {
                    int[] block = container.blocks[i];
                    this.scope = this.scope.and(BigInteger.ONE.shiftLeft(block[0] * container.row + block[1]));
                }
            }
        }

        @Override
        public String[][] goods(Container container, Goods[] objects) {
            List<GoodsModel> goodsList = new ArrayList<>();
            for (int i = 0; i < objects.length; i++) {
                goodsList.addAll(GoodsModel.newGoodsModel(objects[i]));
            }



            return null;
        }

        static int[][] rotate(int[][] shape) {
            int[][] newShape = new int[shape[0].length][shape.length];
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[i].length; j++) {
                    newShape[j][shape.length - 1 - i] = shape[i][j];
                }
            }
            return newShape;
        }

        static int[][] turn(int[][] shape) {
            int[][] newShape = new int[shape.length][shape[0].length];
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[i].length; j++) {
                    newShape[i][shape[i].length - 1 - j] = shape[i][j];
                }
            }
            return newShape;
        }

        static BigInteger calculateScope(int[][] shape) {
            BigInteger scope = BigInteger.ZERO;
            int x = 0;
            for (int i = 0; i < shape.length; i++) {
                for (int j = 0; j < shape[i].length; j++) {
                    if (shape[i][j] != 0) {
                        scope = scope.and(BigInteger.ONE.shiftLeft(x));
                    }
                    x++;
                }
            }
            return scope;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}