import java.lang.*;
import java.util.*;

class Main {
  static final Solutions s = new Solutions();

  public static void main(String[] args) throws Exception {
    System.out.println(s.lruCache.getPage(1));
    System.out.println(s.lruCache.getPage(2));
    System.out.println(s.lruCache.getPage(3));
    System.out.println(s.lruCache.getPage(4));
    System.out.println(s.lruCache.getPage(5));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(2));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(3));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(6));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(7));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(8));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(20));
    s.lruCache.printQueue();
    System.out.println(s.lruCache.getPage(7));
    s.lruCache.printQueue();
  }
}
