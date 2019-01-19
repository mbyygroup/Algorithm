package com.mbyy.algoritum.vo.HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int aKey,size,n,keysPerCell;
        System.out.println("Enter size of hash table: ");
        size=getInt();
        System.out.println("Enter initial number of items: ");
        n=getInt();
        keysPerCell=10;
        HashTable theHashTable=new HashTable(size);
        for (int j = 0; j <n ; j++) {
            aKey= (int) (Math.random()*keysPerCell*size);
            aDataItem=new DataItem(aKey);
            theHashTable.insert(aKey,aDataItem);
        }
        while (true){
            System.out.println("Enter first letter of ");
            System.out.println("show,insert,delete,or find: ");
            char choice=getChar();
            switch (choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    aKey=getInt();
                    aDataItem=new DataItem(aKey);
                    theHashTable.insert(aKey,aDataItem);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    aKey=getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    aKey=getInt();
                    aDataItem=theHashTable.find(aKey);
                    if (aDataItem!=null){
                        System.out.println("Found "+aKey);
                    }else {
                        System.out.println("Could not find "+aKey);
                    }
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s=getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s=getString();
        return Integer.parseInt(s);
    }
}
