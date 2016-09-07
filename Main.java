package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    testChaining();





    }



    public static void testChaining() {
        Function h = new Function1();
        HTChaining hashTable = new HTChaining(h, 11);
        hashTable.insert(22,22);
        hashTable.insert(1,1);
        hashTable.insert(13,13);
        hashTable.insert(11,11);
        hashTable.insert(24,24);
        hashTable.insert(33,33);
        hashTable.insert(18,18);
        hashTable.insert(42,42);
        hashTable.insert(31,31);
        Object[] result = hashTable.getHashTable();
        List tempList;
        boolean flag = true;
        tempList = (List) result[0];
        if (!(((Integer)((HashObject)tempList.get(0)).getData() == 33) &&
                ((Integer)((HashObject)tempList.get(1)).getData() == 11) &&
                ((Integer)((HashObject)tempList.get(2)).getData() == 22) &&
                tempList.size() == 3))
            flag = false;
        tempList = (List) result[1];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 1) &&
                        tempList.size() == 1))
            flag = false;
        tempList = (List) result[2];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 24) &&
                        ((Integer)((HashObject)tempList.get(1)).getData() == 13) &&
                        tempList.size() == 2))
            flag = false;
        for (int i = 3; i <= 6 && flag; i++) {
            tempList = (List) result[i];
           /* if(result[5] ==null)
            System.out.println("YYYYYYYYYYYYYYYY");*/

            if (flag &&
                    !(tempList.size() == 0))
                flag = false;
        }
        tempList = (List) result[7];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 18) &&
                        tempList.size() == 1))
            flag = false;
        tempList = (List) result[8];
        if (flag &&
                !(tempList.size() == 0))
            flag = false;
        tempList = (List) result[9];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 31) &&
                        ((Integer)((HashObject)tempList.get(1)).getData() == 42) &&
                        tempList.size() == 2))
            flag = false;
        tempList = (List) result[10];
        if (flag &&
                !(tempList.size() == 0))
            flag = false;
        if (flag)
            System.out.println("Chaining test 1.1 was passed");
        else {
            System.out.println("Chaining test 1.1 was FAILED");
            System.out.println("Expected table: {[33, 11, 22],[1],[24, 13],[],[],[],[],[18],[],[31, 42],[]}");
            System.out.println("Your table: " + Arrays.toString(result));
        }

        Object existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33))
            System.out.println("Chaining find test 1.2 was passed");
        else {
            System.out.println("Chaining find test 1.2 was FAILED");
            System.out.println("Expected data: find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(33) = " + existingData);
            else
                System.out.println("Your data: find(33) = " + existingData.toString());
        }

        hashTable.delete(11);
        Object deletedData = hashTable.find(11);
        existingData = hashTable.find(33);
        if (existingData != null && existingData.equals(33) && deletedData==null)
            System.out.println("Chaining delete test 1.3 was passed");
        else {
            System.out.println("Chaining delete test 1.3 was FAILED");
            System.out.println("Expected data: find(11) = null ; find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData);
            else
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData.toString());
        }
    }
}
