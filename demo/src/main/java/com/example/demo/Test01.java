package com.example.demo;

public class Test01 {


    enum Size {S, M, L, XL};

    public static void main(String[] args) {
        /*Size[] allSize = new Size[]{Size.S,Size.M, Size.L, Size.XL};
        for (Size sz : allSize) {
            switch (sz){
                case S:
                    System.out.println("small");
                    break;
                case M:
                    System.out.println("medium");
                    continue;
                case L:
                    System.out.println("large");
                default:
                    System.out.println("default");
            }
            System.out.println(sz);
        }*/
        //String s = new String("a"+"b");
        //int ooo = new Test01().ooo(null);
        //System.out.println("返回值:"+ooo);
        int m = 2;

        switch (m){
            case 0:
                System.out.println("condtion0");
            case 1:
                System.out.println("condtion1");
            case 2:
                System.out.println("condtion2");
            case 3:
                System.out.println("condtion3");
            break;
            default:
                System.out.println("other");
        }
    }

     public int ooo(String ss){

         try {
             System.out.println("长度:"+ss.length());
             return 1;
         } catch (Exception e) {
             System.out.println("exection");
             return 2;
         } finally {
             System.out.println("finally");
             return 3;
         }
     }
}
