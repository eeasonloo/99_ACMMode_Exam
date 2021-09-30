package org.eeasonloo;

import java.util.Arrays;
import java.util.Scanner;

public class ACMMultipleLines {
    // 题目
    // 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
    // 每门课由平时成绩和考试成绩组成，满分为r。
    // 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
    // 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。

    public static void main(String[] args) {
        // 输入描述:
        // 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，
        // 接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
        // 示例1
        // 输入
        // 5 10 9
        // 0 5
        // 9 1
        // 8 1
        // 0 1
        // 9 100
        //Scanner类默认的分隔符就是空格

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int classCount = sc.nextInt();
            int fullScore = sc.nextInt();
            int avgScore = sc.nextInt();

            int[][] map = new int[classCount][2];
            for (int i = 0; i < classCount; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
            }

            //假定不会出现拿不到奖学金的情况
            if (classCount == 1) {
                System.out.println((avgScore - map[0][0]) * map[0][1]);
                continue;
            }
            Arrays.sort(map, (o1, o2) -> o1[1] - o2[1]);//按复习代价从小到大排序
            long sum = 0;
            for (int[] a : map) {
                sum += a[0];
            }
            long limit = avgScore * classCount;
            int index = 0;
            long time = 0;
            while (sum < limit) {
                int tmp = fullScore - map[index][0];
                if (tmp + sum <= limit) {                  //如果一门课程复习到满分，小于限制，
                    time += tmp * map[index][1];
                    sum += tmp;
                    index++;
                } else {                              //如果一门课程复习到满分，大于限制，
                    time += (limit - sum) * map[index][1];
                    sum = limit;
                }
            }
            // 输出描述:
            // 一行输出答案。
            // 输出
            // 43
            System.out.println(time);
        }


    }
}
