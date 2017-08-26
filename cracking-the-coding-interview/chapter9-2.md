## 2) Linked Lists

A linked list is a data structure represented by a sequence of nodes. Each node contains data and points to the next node in the list. Nodes in a doubly linked list will point to the previous node as well.

### Creating a Linked List

Below is a basic implementation of a singly linked list:

```java
class Node {
  Node next = null;
  int data;
  public Node(int d){
    data = d;
  }
  void appendToTail(int d){
    Node end = new Node(d);
    Node n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = end;
  }
}
```

### Deleting a Node from a Singly Linked List

We access the linked list through a reference to the head Node of the linked list. Deleting a node is also fairly straightforward. We iterate until we find matching data in ```n.next.data```, then set ```n.next``` to ```n.next.next```.

```java
Node deleteNode(Node head, int d) {
  Node n = head;
  if (n.data == d){
    return head.next;
  }
  while (n.next != null) {
    if (n.next.data == d){
      n.next = n.next.next;
      return head;
    }
  }
  return head
}
```

### The "Runner" Technique and Recursion

It is often handy to use a second pointer when iterating through a linked list to accomplish certain tasks, such as weaving the elements of the linked list.

Also, number of linked list problems rely on recursion for an easy solution, so if you are having problems, try recursion.