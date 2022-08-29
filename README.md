# Binary Search Tree
This is a library containing all methods of a binary search tree

## Installation

Run maven command

```bash
mvn clean install
```

Import dependency in your pom

```xml
<dependency>
    <groupId>com.binarytree.api</groupId>
    <artifactId>binary-search-tree</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
import com.binarytree.*;

// build tree from array
Integer[] array = {2, 3, 11, 7, 19, 4, 6};
BinarySearchTree bst = new BinarySearchTreeImpl(array);

// insert new element
BinaryTreeNode node = bst.insert(10);

// delete element
bst.delete(11);

// search element
Optional<BinaryTreeNode> node = bst.search(7);

// get deepest nodes
DeepestNodes deepestNodes = bst.deepestNodes();

```
