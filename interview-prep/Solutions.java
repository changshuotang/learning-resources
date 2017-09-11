import java.lang.*;
import java.util.*;

class Solutions {
  class ListNode {
    int val;
    ListNode next;
  }

  class DListNode {
    int val;
    DListNode next;
    DListNode prev;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  public QueueOneStack queueOneStack;
  public LRUCache lruCache;

  public Solutions() { 
    queueOneStack = new QueueOneStack();
    lruCache = new LRUCache(5);
  }

  class LRUCache {
    private int cacheSize;
    private Map<Integer, CacheNode> cache;
    private CacheNode head;
    private CacheNode tail;

    class CacheNode {
      int pageKey;
      Object pageVal;
      CacheNode prev;
      CacheNode next;

      public CacheNode(int pageKey, Object pageVal) {
        this.pageKey = pageKey;
        this.pageVal = pageVal;
        this.prev = null;
        this.next = null;
      }

      @Override
      public String toString() {
        return String.format("key: %s, value: %s", pageKey, pageVal.toString());
      }
    }

    public LRUCache(int cacheSize) {
      this.cacheSize = cacheSize;
      this.cache = new HashMap<Integer, CacheNode>();
    }

    public Object getPage(int pageKey) {
      CacheNode pageNode;
      if (cache.containsKey(pageKey)) { // cache contains reference to page in memory
        pageNode = cache.get(pageKey);
        /* detach node from LL */
        if (pageNode.prev != null) {
          pageNode.prev.next = pageNode.next;
        }
        if (pageNode != head && pageNode.next != null) {
          pageNode.next.prev = pageNode.prev;
        }
      } else { // cache doesn't contain reference to page and retrieves from disk
        pageNode = getPageFromDisk(pageKey);
        if (cache.size() == cacheSize) { // cache size full, remove least recently used
          cache.remove(tail.pageKey);
          tail = tail.prev;
          tail.next = null;
        } 
        if (head == null) { // cache is empty
          head = pageNode;
          tail = pageNode;
        }
      }
      if (head != pageNode) { // update LL to reflect most recently used page
        head.prev = pageNode;
        pageNode.next = head;
        head = head.prev;
      }
      cache.put(pageKey, pageNode);
      return pageNode.pageVal;
    }

    public void printQueue() {
      CacheNode tmp = head;
      while (tmp != null) {
        System.out.println(tmp);
        tmp = tmp.next;
      }
    }

    public void printCache() {
      System.out.println(cache.toString());
    }

    private CacheNode getPageFromDisk(int pageKey) {
      return new CacheNode(pageKey, String.valueOf(pageKey));
    }
  }

  class QueueOneStack {
    private Stack<Integer> s;
    private int retVal;
  
    public QueueOneStack() {
      s = new Stack<Integer>();
    }

    public void enqueue(int num) {
      s.push(num);
    }

    public int dequeue() {
      dequeueHelper();
      return retVal;
    }

    private void dequeueHelper() {
      if (s.size() == 0) {
        retVal = Integer.MIN_VALUE;
        return;
      }
      if (s.size() == 1) {
        retVal = s.pop();
        return;
      }
      int save = s.pop();
      dequeueHelper();
      s.push(save);
    }
  }
}
