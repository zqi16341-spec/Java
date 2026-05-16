package com.github.qichangfeng.javase.array;

public class ArrayUtil {
    public static int getSum(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
        }
        return sum;
    }

    public static int getMax(int[] arr) {
        int max =arr[0];
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min =arr[0];
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static double getAverage(int[] arr) {
        return getSum(arr)*1.0/arr.length;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                System.out.print(arr[arr.length-1]+"]");
            }else {
                System.out.print(arr[i]+", ");
            }
        }
    }
}

