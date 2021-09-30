package org.eeasonloo;

import java.util.Arrays;
import java.util.Scanner;

public class ACMArray {
    // 题目描述
    // 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai ，
    // 每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，
    // 但是为了省电，要使这个d最小，请找到这个最小的d。
    public static void main(String[] args) {
        // 输入描述:
        // 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。
        // 第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。
        // 输入
        // 7 15
        // 15 5 3 7 9 14 0
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int lightCount = sc.nextInt();
            long roadLong = sc.nextLong();

            long[] lightPos = new long[lightCount];

            for (int i = 0; i < lightCount; i++) {
                lightPos[i] = sc.nextLong();
            }


            Arrays.sort(lightPos);
            long gap = lightPos[1] - lightPos[0];

            for (int i = 1; i < lightCount; i++) {
                gap = Math.max(gap, lightPos[i] - lightPos[i - 1]);
            }

            //Let's assumed there are light at Pos 0 and roadLong
            gap = Math.max(gap, (lightPos[0] - 0) * 2);
            gap = Math.max(gap, (roadLong - lightPos[lightCount - 1]) * 2);

            System.out.println(String.format("%.2f", gap/2.0));

        }
    }
}
