package com.test;

public class OutterClass {

    public static void main(String[] args) {

    }

    private String outterClassField;

    public String getOutterClassField() {
        return outterClassField;
    }

    public void setOutterClassField(String outterClassField) {
        this.outterClassField = outterClassField;
    }

    class InnerClass{
        private String innerClassField;

        public String getInnerClassField() {
            return innerClassField;
        }

        public void setInnerClassField(String innerClassField) {
            this.innerClassField = innerClassField;
        }
    }
}
