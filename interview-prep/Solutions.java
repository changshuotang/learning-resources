import java.lang.*;
import java.util.*;

class Solutions {
  public QueueOneStack queueOneStack;

  public Solutions() { 
    queueOneStack = new QueueOneStack();
  }

  class QueueOneStack {
    Stack<Integer> s;
    int retVal;
  
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
