package com.datastructure.array.sort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,9,2,7,4,8,1};
        int L = 0;
        int R = arr.length - 1;
        quickSort(arr,L,R);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {

        int l,r,temp,line;

        l = left;
        r = right;

        //基准线 默认为第一个
        line = arr[left];

        //扫描超过位置结束
        while (l <= r){
            while (arr[r] >= line && left < r){
                r--;
            }

            while (arr[l] <= line  && l < right){
                l++;
            }

            if(l <= r){
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }

        //交换基准线
        arr[left] = arr[l];
        arr[l] = line;

        /**
         * 递归调用左
         */
        if(left < r){
            quickSort(arr,left,r);
        }
        if(l < right){
            quickSort(arr,l,right);
        }
    }
}
