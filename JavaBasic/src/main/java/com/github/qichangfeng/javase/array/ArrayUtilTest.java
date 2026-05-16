package com.github.qichangfeng.javase.array;

public class ArrayUtilTest {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 7, 5};

        System.out.println(ArrayUtil.getSum(arr));
        System.out.println(ArrayUtil.getMax(arr));
        System.out.println(ArrayUtil.getMin(arr));
        System.out.println(ArrayUtil.getAverage(arr));
        ArrayUtil.printArray(arr);
    }
}

