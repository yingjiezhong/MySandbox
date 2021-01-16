package com.denofprogramming.leetcode.tree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyBSTTest {

    @Test
    void iterativeTraverse() {
        MyBST bst = new MyBST(4, 2, 3, 6, 7);

        List<Integer> list = bst.iterativeTraverse(MyBST.Order.PREORDER);
        System.out.println("preorder: " + list);
        List<Integer> preorderList = Arrays.asList(4,2,3,6,7);
        Assert.assertEquals(preorderList, list);

        list.clear();
        list = bst.iterativeTraverse(MyBST.Order.POSTORDER);
        System.out.println("postorder: " + list);
        List<Integer> postorderList = Arrays.asList(3,2,7,6,4);
        Assert.assertEquals(postorderList, list);

        list.clear();
        list = bst.iterativeTraverse(MyBST.Order.INORDER);
        System.out.println("inorder: " + list);
        List<Integer> inorderList = Arrays.asList(2,3,4,6,7);
        Assert.assertEquals(inorderList, list);

        // add nodes
        bst.addNode(1);
        bst.addNode(5);
        list.clear();
        list = bst.iterativeTraverse(MyBST.Order.PREORDER);
        System.out.println("inorder: " + list);
        preorderList = Arrays.asList(4,2,1,3,6,5,7);
        Assert.assertEquals(preorderList, list);

        list.clear();
        list = bst.iterativeTraverse(MyBST.Order.POSTORDER);
        System.out.println("postorder: " + list);
        preorderList = Arrays.asList(1,3,2,5,7,6,4);
        Assert.assertEquals(preorderList, list);

        list.clear();
        list = bst.iterativeTraverse(MyBST.Order.INORDER);
        System.out.println("inorder: " + list);
        inorderList = Arrays.asList(1,2,3,4,5,6,7);
        Assert.assertEquals(inorderList, list);

    }
}