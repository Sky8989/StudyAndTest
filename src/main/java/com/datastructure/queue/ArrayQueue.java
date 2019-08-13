package com.datastructure.queue;

/**
 * 先进先出 FIFO
 */
public class ArrayQueue {


    int front = -1; //队列前 不包含  默认-1   队头删除一个元素+1
    int rear = -1; //队列最后 包含   默认-1   队尾插入一个元素+1

    int maxLength; //最大长度

    int[] arr;

    //front=rear时，队列中没有任何元素，称为空队列


    public ArrayQueue(int length) {
        maxLength = length;
        arr = new int[maxLength];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    void isEmpty() {
        if (front == rear) {
            throw new RuntimeException("队列为空");
        }

    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    void isMaxLength() {
        if (rear == maxLength - 1) {
            throw new RuntimeException("队列已满");
        }


    }

    int add(int val) {
        isMaxLength();

        //队尾添加
        rear++;

        arr[rear] = val;

        return val;
    }

    int get() {
        isEmpty();

        return 0;
    }

}
