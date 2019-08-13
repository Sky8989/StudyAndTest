package com.datastructure.array.sort;

/**
 * 二分查找
 * 前提: 传入的数组必须有序
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,8,9,10,40,60,100,121};

        int num = 121;

        int  result = binarySearch(arr,num);
        if( result > 0){
            System.out.println("查找到结果为 = " + result);
        }else{
            System.out.println("没有找到");
        }
    }


    /**
     * 二分查询
     * @param arr  数组
     * @param item 目标值
     * @return
     */
    public static int binarySearch(int[] arr, int item){
        if(arr == null){
            throw new RuntimeException("传入的数据为空");
        }
        int len = arr.length;
        int min = 0;
        int max = len;
        int mid = 0;
        while(true){
            mid = (min + max) / 2;

            if(item > arr[mid]){
                min = mid ;
            }else if(item < arr[mid]){
                max = mid;
            }else if(item == arr[mid]){
                return arr[mid];
            }
            if(min == max){
                return 0;
            }
        }



    }
}
