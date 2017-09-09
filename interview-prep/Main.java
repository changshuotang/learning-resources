import java.lang.*;
import java.util.*;

class Main {
  static final Solutions s = new Solutions();

  public static void main(String[] args) throws Exception {
    s.queueOneStack.enqueue(1);
    s.queueOneStack.enqueue(2);
    s.queueOneStack.enqueue(3);
    s.queueOneStack.enqueue(4);
    System.out.println(s.queueOneStack.dequeue());
    System.out.println(s.queueOneStack.dequeue());
    s.queueOneStack.enqueue(5);
    s.queueOneStack.enqueue(6);
    System.out.println(s.queueOneStack.dequeue());
    System.out.println(s.queueOneStack.dequeue());
    System.out.println(s.queueOneStack.dequeue());
    System.out.println(s.queueOneStack.dequeue());
  }
}
