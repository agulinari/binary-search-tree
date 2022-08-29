package com.binarytree.api;

import com.binarytree.impl.BinaryTreeNode;
import com.binarytree.impl.DeepestNodes;

import java.util.Optional;

public interface BinarySearchTree {

    /**
     * Inserts a new integer in the BST. Duplicate values are ignored.
     *
     * @param value Integer to insert in the BST
     * @return Node containing the inserted value
     */
    BinaryTreeNode insert(Integer value);

    /**
     * Removes the node containing the given integer from the BST
     * Does nothing if the integer is not found
     *
     * @param value Integer to be removed
     */
    void delete(Integer value);

    /**
     * Searches the given integer in the BST
     *
     * @param value Integer to be found
     * @return If the integer is found returns an optional holding the node with the integer, otherwise it returns an empty Optional.
     */
    Optional<BinaryTreeNode> search(Integer value);

    /**
     * Returns the number of nodes of the BST
     *
     * @return Returns the number of nodes of the BST
     */
    Integer size();

    /**
     * Returns the deepest nodes in the BST along with their depth
     *
     * @return DeepestNodes
     */
    DeepestNodes deepestNodes();

    /**
     * Prints the BST using InOrder walk
     */
    void printInOrder();

    /**
     * Prints the BST using PreOrder walk
     */
    void printPreOrder();

    /**
     * Prints the BST using PostOrder walk
     */
    void printPostOrder();

    /**
     * Returns the root node
     *
     * @return Root Node
     */
    BinaryTreeNode getRoot();
}
