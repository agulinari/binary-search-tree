package com.binarytree.impl;

import com.binarytree.api.BinarySearchTree;

import java.util.Optional;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private BinaryTreeNode root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    public BinarySearchTreeImpl(BinaryTreeNode root) {
        this.root = root;
    }

    public BinarySearchTreeImpl(Integer[] array) {
        for (Integer value : array) {
            this.insert(value);
        }
    }

    @Override
    public BinaryTreeNode insert(Integer value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode(value);
            return this.root;
        }
        return findAndInsert(this.root, value);
    }

    @Override
    public void delete(Integer value) {
        this.root = findAndDelete(this.root, value);
    }

    @Override
    public Optional<BinaryTreeNode> search(Integer value) {
        return findRecursive(this.root, value);
    }

    @Override
    public Integer size() {
        return countNodes(this.root, 0);
    }

    @Override
    public DeepestNodes deepestNodes() {
        DeepestNodes deepestNodes = new DeepestNodes();
        findDeepestNodes(this.root, 0, deepestNodes);
        return deepestNodes;
    }

    @Override
    public void printInOrder() {
        inorderWalk(this.root, 0);
    }

    @Override
    public void printPreOrder() {
        preorderWalk(this.root, 0);
    }

    @Override
    public void printPostOrder() {
        postorderWalk(this.root, 0);
    }

    @Override
    public BinaryTreeNode getRoot() {
        return this.root;
    }

    private Integer countNodes(BinaryTreeNode currentNode, int count) {
        if (currentNode == null) {
            return count;
        } else {
            count++;
        }

        count = countNodes(currentNode.getLeftNode(), count);
        count = countNodes(currentNode.getRightNode(), count);
        return count;
    }

    private Integer findReplacement(BinaryTreeNode node) {
        BinaryTreeNode currentNode = node;
        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }
        return currentNode.getData();
    }

    /**
     * This method searches and deletes the element recursively and returns the new root after deletion
     */
    private BinaryTreeNode findAndDelete(BinaryTreeNode currentNode, Integer value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.getData().compareTo(value) == 0) {
            // the current node contains the element to delete

            if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                // if current node is a leaf we can delete it safely
                return null;
            }
            if (currentNode.getRightNode() == null) {
                // if current node does not have a right child, left node will be the new parent
                return currentNode.getLeftNode();
            }
            if (currentNode.getLeftNode() == null) {
                // if current node does not have a left child, right node will be the new parent
                return currentNode.getRightNode();
            }

            // if current node has both child we have to find next minimum value and replace it in the current node
            Integer newValue = findReplacement(currentNode.getRightNode());
            currentNode.setData(newValue);
            // then we delete the replacement node from the bst
            BinaryTreeNode subtreeRoot = findAndDelete(currentNode.getRightNode(), newValue);
            // And assign new subtree root as the current node right child
            currentNode.setRightNode(subtreeRoot);
            return currentNode;
        }
        if (currentNode.getData().compareTo(value) < 0) {
            // if current value is lesser than the input value we continue the search in the right subtree
            BinaryTreeNode subtreeRoot = findAndDelete(currentNode.getRightNode(), value);
            // After node is deleted from subtree, we assign the new subtree root as the current node right child
            currentNode.setRightNode(subtreeRoot);
        } else {
            // if current value is greater than the input value we continue the search in the left subtree
            BinaryTreeNode subtreeRoot = findAndDelete(currentNode.getLeftNode(), value);
            // After node is deleted from subtree, we assign the new subtree root as the current node left child
            currentNode.setLeftNode(subtreeRoot);
        }
        return currentNode;
    }

    private void inorderWalk(BinaryTreeNode currentNode, Integer depth) {
        if (currentNode == null) {
            return;
        }
        inorderWalk(currentNode.getLeftNode(), depth + 1);
        printNode(currentNode, depth);
        inorderWalk(currentNode.getRightNode(), depth + 1);
    }

    private void preorderWalk(BinaryTreeNode currentNode, Integer depth) {
        if (currentNode == null) {
            return;
        }
        printNode(currentNode, depth);
        preorderWalk(currentNode.getLeftNode(), depth + 1);
        preorderWalk(currentNode.getRightNode(), depth + 1);
    }

    private void postorderWalk(BinaryTreeNode currentNode, Integer depth) {
        if (currentNode == null) {
            return;
        }
        postorderWalk(currentNode.getLeftNode(), depth + 1);
        postorderWalk(currentNode.getRightNode(), depth + 1);
        printNode(currentNode, depth);

    }

    private void printNode(BinaryTreeNode currentNode, Integer depth) {
        String left = (currentNode.getLeftNode() != null) ? currentNode.getLeftNode().getData().toString() : "null";
        String right = (currentNode.getRightNode() != null) ? currentNode.getRightNode().getData().toString() : "null";
        System.out.println("Data: " + currentNode.getData() + " Depth: " + depth + " LChild: " + left + " RChild: " + right);
    }


    private void findDeepestNodes(BinaryTreeNode currentNode, Integer depth, DeepestNodes deepestNodes) {

        if (deepestNodes.getDepth() == depth) {
            deepestNodes.getNodes().add(currentNode);
        } else if (deepestNodes.getDepth() < depth) {
            deepestNodes.getNodes().clear();
            deepestNodes.getNodes().add(currentNode);
            deepestNodes.setDepth(depth);
        }

        if (currentNode.getLeftNode() != null) {
            findDeepestNodes(currentNode.getLeftNode(), depth + 1, deepestNodes);
        }
        if (currentNode.getRightNode() != null) {
            findDeepestNodes(currentNode.getRightNode(), depth + 1, deepestNodes);
        }
    }


    private BinaryTreeNode findAndInsert(BinaryTreeNode currentNode, Integer value) {

        if (currentNode.getData().compareTo(value) == 0) {
            return currentNode;
        } else if (currentNode.getData().compareTo(value) >= 0) {
            if (currentNode.getLeftNode() == null) {
                BinaryTreeNode node = new BinaryTreeNode(value);
                currentNode.setLeftNode(node);
                return node;
            } else {
                return findAndInsert(currentNode.getLeftNode(), value);
            }
        } else {
            if (currentNode.getRightNode() == null) {
                BinaryTreeNode node = new BinaryTreeNode(value);
                currentNode.setRightNode(node);
                return node;
            } else {
                return findAndInsert(currentNode.getRightNode(), value);
            }
        }
    }

    private Optional<BinaryTreeNode> findRecursive(BinaryTreeNode currentNode, Integer value) {

        if (currentNode == null) {
            return Optional.empty();
        }

        if (currentNode.getData().compareTo(value) == 0) {
            return Optional.of(currentNode);
        }

        if (currentNode.getData().compareTo(value) > 0) {
            return findRecursive(currentNode.getLeftNode(), value);
        } else {
            return findRecursive(currentNode.getRightNode(), value);
        }

    }


}
