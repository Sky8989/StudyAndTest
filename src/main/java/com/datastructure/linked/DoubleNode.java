package com.datastructure.linked;

/**
 * 节点
 */
public class DoubleNode {
   public int no;
    public String name;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("no=").append(no);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
