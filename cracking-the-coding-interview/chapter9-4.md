## 4) Trees and Graphs

### Types of Trees

A tree is a data structure composed of the following properties:
- contains a root node
- root node has zero or more child nodes
- each child node has zero or more child nodes

```java
class Node {
  public String name;
  public Node[] children;
}

class Tree {
  public Node root;
}
```

Binary trees are trees that have up to two children.

The difference between a binary tree and a binary search tree is that the binary search tree is sorted.

A ___balanced tree___ ensures ```O(log n)``` time for ```insert``` and ```find```. Two common types of balanced trees are red-black trees and AVL trees.

A ___complete binary tree___ is a tree that is fully filled, expect for perhaps the last level.

A ___full binary tree____ is a binary tree in which every node has either zero or two children.

A ___perfect binary tree___ is one that is both full and complete.

### Binary Tree Traversal

- ___In-order traversal___ visit the left branch, then the current node, then the right branch.
- ___Pre-Order Traversal___ visits the current node before the left then right branches.
- ___Post-Order Traversal___ visits the left and right branches before the current node.

```java
void inOrderTraversal(TreeNode node){
  if (node != null){
    inOrderTraversal(node.left);
    visit(node);
    inOrderTraversal(node.right);
  }
}

void preOrderTraversal(TreeNode node){
  if (node != null){
    visit(node);
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }
}

void postOrderTraversal(TreeNode node){
  if (node != null){
    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    visit(node);
  }
}
```

### Binary Heaps (Min/Max-Heaps)

A min-heap is a complete binary tree where each node is smaller than its children. The root therefore is the minimum element in the tree. Thee are two key operations on a min-heap: ```insert``` and ```extract_min```.

##### Insert

When we insert into a min-heap we start by inserting the element at the bottom right. We then 'fix' the tree by swapping the new element with its parent until we find an appropriate spot. This takes ```O(log n)``` time where ```n``` is the number of nodes in the heap.

##### Extract Minimum Element

To extract the min element on a min-heap, the topmost element, we need to first swap it with the last element of the heap (bottom right), then swap the element with the smaller of the two children nodes until the min-heap property is restored. This algorithm also takes ```O(log n)``` time.

### Tries (Prefix Trees)

A tire is a variant of an n-ary tree in which characters are stored at each node, and each path down the tree may represent a word. A * node, or null node, can be used at the end of the path to indicate complete words. A node in a trie can have anywhere from 1 through ```ALPHABET_SIZE + 1``` children. Tries are often used to store the entire English language for quick prefix lookups.

### Graphs

A tree is a type of graph, but not all graphs are trees. A graph is simply a collection of nodes with edges between some of them.
- Graphs can be either directed or undirected.
- A graph might consist of multiple isolated subgraphs. If there is a path between every pair of vertices it is called a connected graph.
- A graph can also have cycles. An' acyclic graph" is one without cycles.

We can represent graphs through ___adjacency lists___.

```java
class Graph {
  public Node[] nodes;
}

class Node{
  public String name;
  public Node[] children;
}
```

We can also represent graph through an ___adjacency matrix___, an ```NxN``` boolean matrix where a true value represent an edge. In an undirected graph an adjacency matrix will be symmetric.

### Graph Search

#### Depth-First Search (DFS)

In DFS, we visit as far along a path as possible before backtracking. Here is the pseudocode for DFS:

```java
void search(Node root){
  if (root == null) return;
  visit(root);
  root.visited = true;
  for each (Node n in root.adjacent){
    if (n.visited == false){
      search(n);
    }
  }
}
```

#### Breadth-First Search (BFS)

In BFS we explore all the nodes on the same level before moving on to explore nodes of a deeper level. Here is the pseudocode for BFS:

```java
void search(Node root){
  Queue queue = new Queue();
  root.marked = true;
  queue.enqueue(root);
  while (!queue.isEmpty()){
    if (n.marked == false){
      n.marked == true;
      queue.enqueue(n);
    }
  }
}
```

#### Bidirectional Search

Bidirectional search is used to find the shortest path between a source and destination node. It is essentially running two simultaneous BFS from each node, stopping when the search collide. Bidirectional search is more efficient then traditional BFS because the searches only search ```depth/2``` levels compared to BFS.