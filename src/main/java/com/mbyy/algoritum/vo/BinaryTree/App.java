package com.mbyy.algoritum.vo.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        theTree.insert(28, 1.9);
        theTree.insert(22, 1.9);
        theTree.insert(12, 1.5);
        theTree.insert(30, 1.5);
        theTree.insert(43, 1.5);
        theTree.insert(87, 1.5);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);
        theTree.inOrder(theTree.find(50));
        System.out.println();
        theTree.delete(93);
        theTree.inOrder(theTree.find(50));
    }
}
