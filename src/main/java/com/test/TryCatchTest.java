package com.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TryCatchTest {

    public static void main(String[] args) {


       Map map = new  HashMap(16);

        try (BufferedReader br = new BufferedReader(new FileReader("read.txt"));
             BufferedReader br1 = new BufferedReader(new FileReader("read.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("read.txt"));){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



  /*  public static void method(List<String> list) {
        System.out.println("invoke method(List<String> list)");

    }

    public static void method(List<Integer> list) {

        System.out.println("invoke method(List<Integer> list)");
    }*/
}
