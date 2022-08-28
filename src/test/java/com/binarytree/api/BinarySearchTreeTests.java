package com.binarytree.api;

import com.binarytree.impl.BinarySearchTreeImpl;
import com.binarytree.impl.BinaryTreeNode;
import com.binarytree.impl.DeepestNodes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTests {

    @Test
    void insertNewElementTest() {
        Integer[] array = {2, 3, 11, 7, 19, 4, 6};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);

        BinaryTreeNode node = bst.insert(10);

        assertEquals(10, node.getData());
        assertEquals(8, bst.size());
    }

    @Test
    void deepestNodesTest1() {
        Integer[] array = {12, 11, 90, 82, 7, 9};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);

        DeepestNodes deepestNodes = bst.deepestNodes();

        assertEquals(3, deepestNodes.getDepth());
        assertEquals(1, deepestNodes.getNodes().size());
        assertEquals(9, deepestNodes.getNodes().get(0).getData());

    }

    @Test
    void deepestNodesTest2() {
        Integer[] array = {26, 82, 16, 92, 33};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);

        DeepestNodes deepestNodes = bst.deepestNodes();

        assertEquals(2, deepestNodes.getDepth());
        assertEquals(2, deepestNodes.getNodes().size());
        assertEquals(33, deepestNodes.getNodes().get(0).getData());
        assertEquals(92, deepestNodes.getNodes().get(1).getData());

    }

    @Test
    void sizeTest() {
        Integer[] array = {50, 4, 100, 82, 2, 1, 90, 85, 16, 92, 33, 44};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);
        Integer size = bst.size();
        assertEquals(array.length, size);
    }

    @Test
    void deleteRootTest() {
        Integer[] array = {50, 4, 100, 82, 2, 1, 90, 85, 16, 92, 33, 44};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);
        bst.delete(50);
        assertEquals(82, bst.getRoot().getData());
    }

    @Test
    void deleteNodeTest() {
        Integer[] array = {50, 4, 100, 82, 2, 1, 90, 85, 16, 92, 33, 44};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);
        bst.delete(4);
        assertEquals(16, bst.getRoot().getLeftNode().getData());
    }

    @Test
    void deleteLeafTest() {
        Integer[] array = {50, 4, 100, 82, 2, 1, 90, 85, 16, 92, 33, 44};
        BinarySearchTree bst = new BinarySearchTreeImpl(array);
        bst.delete(1);
        assertEquals(null, bst.getRoot().getLeftNode().getLeftNode().getLeftNode());
    }

    @Test
    void deleteNullTreeTest() {
        BinarySearchTree bst = new BinarySearchTreeImpl();
        bst.delete(1);
        assertEquals(null, bst.getRoot());
    }


}
