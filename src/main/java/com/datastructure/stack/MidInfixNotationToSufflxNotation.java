package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀转后缀
 *
 *          1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
 *          2) 从左至右扫描中缀表达式；
 *          3) 遇到操作数时，将其压s2；
 *          4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
 *              1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
 *              2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
 *              3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
 *          5) 遇到括号时：
 *              (1) 如果是左括号“(”，则直接压入s1
 *              (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 *          6) 重复步骤2至5，直到表达式的最右边
 *          7) 将s1中剩余的运算符依次弹出并压入s2
 *          8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class MidInfixNotationToSufflxNotation {

    /**
     * 中缀表达式 1 + ( ( 2 + 3 )* 4) - 5 =》 后缀表达式
     * 将 s2 出栈  - 5 + * 4 + 3 2 1  =>  1 2 3 + 4 * + 5 -
     */

    public static void main(String[] args) {

        String mindInfix = "1+((2+3)*4)-5";
        String  resNum = mindInfixToSufflx(mindInfix);
        System.out.println("出栈结果 = " + resNum);


        List<String>  infixList = strToList(mindInfix);
    }


    private static List<String> strToList(String mindInfix) {
        int len = mindInfix.length();
        List<String> resList = new ArrayList<>(len);
        for(int i= 0; i < len; i++){
            resList.add(mindInfix.charAt(i)+"");
        }
        return resList;
    }


    private static String mindInfixToSufflx(String mindInfix) {
        int len = mindInfix.length();

        /**
         * 运算符栈
         */
        Stack<String> s1 = new Stack<String>();
        /**
         * 存中间结果的栈
         */
        Stack<String> s2 = new Stack<String>();


        for(int i = 0; i < len; i++){
            String val = mindInfix.charAt(i)+"";
            if(isSymbol(val)){
                //符号
                if(s1.size() == 0 || "(".equals(val) || "(".equals(s1.peek()))
                {
                    //栈空 或者为 '(' 直接入栈  s1的栈顶为'('  直接入栈
                    s1.add(val);
                } else
                    {

                    if(")".equals(val)){
                        //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                        while (true){
                            String str1 =  s1.pop();
                            if("(".equals(str1)){
                                break;
                            }else{
                                s2.push(str1);
                            }
                        }

                    }

                     if(priority(val) > priority(s1.peek()) && !(")".equals(val)) ){
                        //将s1的栈顶 拿出来
                        //若优先级比栈顶运算符的高，也将运算符压入s1 同时不等于)
                        s1.add(val);
                     }else if(priority(val) <= priority(s1.peek()) && !(")".equals(val))){
                         //否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
                         s2.push(s1.pop());
                         i--; //转到4.1 从新来一遍
                         continue;
                     }



                    }
            }else{
                //数字
                s2.push(val);
            }
        }

        //如果 s1不为空 加入到s2
        while (s1.size() > 0){
            s2.push(s1.pop());
        }

        StringBuilder sb = new StringBuilder();
        //s2出栈
//       while (s2.size() > 0){
//            sb.append(s2.pop());
//       }

        for(String str : s2){
            sb.append(str+" ");
        }
       return sb.toString();
    }

    private static int priority(String val) {

        if ("(".equals(val.trim()) || ")".equals(val.trim())) {
            return 2;
        } else if ("/".equals(val.trim()) || "*".equals(val.trim() )) {
            return 1;
        }
        else if ("+".equals(val.trim()) || "-".equals(val.trim() )) {
            return 0;
        }
        return -1;
    }

    private static boolean isSymbol(String val) {
        return "+".equals(val) || "-".equals(val) || "*".equals(val) || "/".equals(val) || "(".equals(val) || ")".equals(val);
    }
}
