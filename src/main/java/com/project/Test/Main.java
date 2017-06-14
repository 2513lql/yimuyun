package com.project.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line  = sc.nextLine();
        String[] array  = line.split("\\|");
        List<Integer[]> list = new ArrayList();

        for(int i=0;i<array.length;i++){
            String aaa = array[i];
            aaa = aaa.substring(1,aaa.length()-1);
            String[] bbb = aaa.split("\\.");
            Integer[] ccc = {Integer.parseInt(bbb[0]),Integer.parseInt(bbb[1]),Integer.parseInt(bbb[2]),Integer.parseInt(bbb[3]),Integer.parseInt(bbb[3])};
            list.add(ccc);
        }
        Integer[] zero = {0,0,0,200,200};
        list.add(zero);
        execute(list);
    }
    public static void execute(List<Integer[]> list){
        //排序
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){

                if(list.get(i)[1]<list.get(j)[1]){
                    Integer[] temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }

            }

        }
        int priorp = 0;
        int last = 0;
        for(int i=1;i<=200;i++){
            for(int j = 0;j<list.size();j++){
                Integer[] p = list.get(j);
                int rest = p[4];
                int start = p[2];
                if(rest>0 && i>=start){
                    last++;
                    if(p[0] != priorp){
                            System.out.print( priorp + "." + last+"|");
                        last = 0;
                    }
                    priorp = p[0];
//                    System.out.println("p:"+p[0]+",time:"+p[4]);

                    p[4]--;
                    break;
                }
            }
        }
        last++;
        System.out.println(priorp + "." + last);
    }
}
