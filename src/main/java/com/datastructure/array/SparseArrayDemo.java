package com.datastructure.array;

/**
 * 稀疏数组
 *  第一行存储[len][len] = 个数
 *         row   col   val
*     0   11      11    2
 *    1   1       2     1
 *    2   2       3     2
 *
 */
public class SparseArrayDemo {

    public static void main(String[] args) {
        int[][] arr1 = new int[11][11];

        arr1[1][2] = 1;
        arr1[2][3] = 2;

        printArray(arr1);
        int[][] sparseArr = saveSparseArray(arr1);
        System.out.println("稀疏数组 = " );
        printArray(sparseArr);

        int[][] towArr = sparseArrToArray(sparseArr);
        System.out.println("稀疏数组 转二维数组 = " );
        printArray(towArr);


    }

    /**
     * 稀疏数组转二维数组
     * @param sparseArr
     */
    private static  int[][] sparseArrToArray(int[][] sparseArr) {
        int[][] resArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sparseArr.length; i++){
           resArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        return resArr;
    }

    /**
     * 普通二维数组转稀疏数组
     *          row   col   val
     *      0   11      11    2
     *      1   1       2     1
     *      2   2       3     2
     * @param arr1
     * @return
     */
    private static int[][] saveSparseArray(int[][] arr1) {
        int sum = 0;

        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
              int val = arr1[i][j];
              if(val > 0){
                  sum++;
              }
            }
        }
        System.out.println("sum = " + sum);

        //初始化稀疏数组
        int[][] sparseArr = new int[sum+1][3] ;
        //存储数组的信息
        sparseArr[0][0] = arr1.length;          //第一列
        sparseArr[0][1] = arr1[0].length;       //第二列
        sparseArr[0][2] = sum;                  //弟三列

        int num = 0;
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                int val = arr1[i][j];
                if(val > 0){
                   sparseArr[num+1][0] = i;
                   sparseArr[num+1][1] = j;
                   sparseArr[num+1][2] = arr1[i][j];
                   num++;
                }
            }
        }

        return sparseArr;

    }



    /**
     * 打印二维数组
     * @param arr1
     */
    private static void printArray(int[][] arr1) {
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println("");
        }


    }

}
