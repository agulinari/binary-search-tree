package com.binarytree.impl;

import java.util.ArrayList;
import java.util.List;

public class DeepestNodes {

    private List<BinaryTreeNode> nodes;
    private Integer depth;

    public DeepestNodes() {
        this.nodes = new ArrayList<>();
        this.depth = 0;
    }

    public List<BinaryTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<BinaryTreeNode> nodes) {
        this.nodes = nodes;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
