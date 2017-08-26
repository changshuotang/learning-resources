## 3) Stacks and Queues

The stack data structure uses LIFO (last-in-first-out) ordering, while the queue data structure is similar but uses FILA (first-in-last-out) ordering. They both usually contain the following operations:
- ```pop()``` or ```remove()```: remove the top/first item
- ```push(item)```: place an item on the top
- ```peek()```: return the top item
- ```isEmpty()```: returns true if stack is empty

```java
public class Stack<T> {
  private static class StackNode<T>{
    private T data;
    private StackNode<T> next;
    public StackNode(T data) {
      this.data = data;
    }
  }
  private StackNode<T> top;
  public T pop(){
    if (top == null) throw new EmptyStackException();
    T item = top.data;
    top  = top.next;
    return item
  }
  public void push(T item){
    StackNode<T> t = new StackNode<T>(item);
    t.next = top;
    top = t;
  }
  public T peek(){
    if (top == null) throw new EmptyStackException();
    return top.data;
  }
  public boolean isEmpty(){
    return top == null;
  }
}
```

A stack is often useful in certain recursive algorithms. They can be used to implement recursive algorithms iteratively.

```java
public class Queue<T> {
  private static class QueueNode<T>{
    private T data;
    private QueueNode<T> next;
    public QueueNode(T data) {
      this.data = data;
    }
  }
  private QueueNode<T> first;
  private QueueNode<T> last;
  public void add(T item){
    QueueNode<T> t = new QueueNode<T>(item);
    if (last != null){
      last.next = t;
    }
    last = t;
    if (first == null){
      first = last;
    }
  }
  public T remove(){
    if (first == null) throw new NoSuchElementException();
    T data = first.data;
    first = first.next
    if (first == null) {
      last = null;
    }
    return data;
  }
  public T peek(){
    if (first == null) throw new NoSuchElementException();
    return first.data;
  }
  public boolean isEmpty(){
    return first == null;
  }
}
```

One place where queues are often used is in breadth-first search or in implementing a cache.