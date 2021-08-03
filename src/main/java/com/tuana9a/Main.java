package com.tuana9a;


import com.tuana9a.reflection.Class1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//====================================================================================================================
//TEST ALL
//        int[][] a = new int[][]{
//                {1,2,3},
//                {1}
//        };
//
//        System.out.println(a[0].length);
//        System.out.println(a[1].length);

        Class1 c = new Class1();
        System.out.println(String.class.getName());

//====================================================================================================================
//TEST BREAK OUTER

//        outer: while(true) {
//            int i = 0;
//            while(true) {
//                if(i >10)
//                    break outer;
//                System.out.println(i);
//                ++i;
//            }
//        }

//====================================================================================================================
//TEST GHI OBJECT RA FILE VÀ ĐỌC OBJECT TỪ FILE

//        Class1 temp = new Class1("Gemdino");
//        temp.age = 20;
//        File f = new File("D:\\Gem Dino\\Web\\backend\\java\\Projects\\personal\\src\\test\\javacore\\obj.txt");
//        FileOutputStream fos = new FileOutputStream(f);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(temp);
//        oos.close();
//        fos.close();
//        FileInputStream fis = new FileInputStream(f);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Class1 temp1 = (Class1)ois.readObject();
//        System.out.println(temp1.name+ " - " + temp1.age);
//        ois.close();
//        fis.close();

//====================================================================================================================
//TEST XỬ LÝ FILE

//        File f = new File("test/error.png");
//        System.out.println(f.exists());
//        ImageIO.read(new File("test/error.png"));
//            if(file.isDirectory()) System.out.println("Directory");
//            else if(file.isFile()) System.out.println("File");
//            else System.out.println("Unknow File");
//            System.out.println(file.delete());
//        } else {
//            System.out.println(file.mkdir());
//        }

//====================================================================================================================
//TEST CUSTOM EXCEPTION

//        System.out.println(exception());

//====================================================================================================================
//TEST XỬ LÝ COLLECTION ITERATOR

//        List<Class2> temp = new ArrayList<Class2>(){{
//            add(new Class2("obj1"));
//            add(new Class2("obj2"));
//        }};
//        Class2 temp1 = new Class2("tuan");
//        temp.add(temp1);
//        temp.add(temp1);
//
//        Set<String> temp3 = new HashSet<String>(){{
//           add("abc");
//           add("abce");
//           add("abcf");
//           add("abcd");
//        }};


//        System.out.println(temp.size());
//        for (Iterator<Class2> iterator = temp.iterator(); iterator.hasNext();) {
//            Class2 string = iterator.next();
//            // Remove the current element from the iterator and the list.
//            iterator.remove();
//        }
//        System.out.println(temp.size());
    }
//====================================================================================================================
}