package com.sky.bean;

import java.util.ArrayList;
import java.util.List;

public class TestPerson {

     interface FilterPerson{

         //静态方法
         static void testStaticMethod(){

         }

         //定义默认方法
          default void  testDefaultMethod(){

         }



          boolean filter(Person p);
    }

    public static Person filterPerson(Person p, FilterPerson f){

         if(f.filter(p)){
             return p;
         }else{
             return  null;
         }

    }


    public static void main(String[] args) {

         List<Person> pList = new  ArrayList<Person>();
        pList.add(new Person("111",11,true));
        pList.add(new Person("222",13,false));
        pList.add(new Person("333",23,true));
        pList.add(new Person("444",18,true));

       // return new Person("aaa",12,true).equals(p);

        List<Person> filterList = new ArrayList<Person>();
        /*for (Person p : pList){
            Person resultp =  filterPerson(p, new FilterPerson() {
                @Override
                public boolean filter(Person p) {
                    return p.equals(new Person("444",18,true));
                }
            });

            if(resultp != null){
                filterList.add(resultp);
            }
        }*/

        for (Person p : pList){
            Person resultp =  filterPerson(p, (x)->x.equals(new Person("444",18,true)));

            if(resultp != null){
                filterList.add(resultp);
            }
        }


        System.out.println(filterList);

    }
}
