## 15) Threads and Locks

### Threads in Java

In Java threads are each created and controlled by a unique ```java.lang.Thread``` class object. When executing a ```main()``` method a user thread called the main thread is automatically created. We can implement threads by either implementing the ```java.lang.Runnable``` interface or extending the ```java.lang.Thread``` class.

##### Implementing the Runnable Interface

##### Extending the Thread Class

##### Extending the Thread Class vs. Implementing the Runnable Interface

There are two reason why implementing the ```Runnable``` interface may be preferable to extending the ```Thread``` class.

- Java does not support multiple inheritance, so extending the ```Thread``` class means you cannot extends any other classes.
- A class might only be interested in being runnable, so inheriting the full overhead of the ```Thread``` class is excessive.

### Synchronization and Locks

##### Synchronized Methods & Blocks

We can restrict access to shared resources through the use of the ```synchronized``` keyword. It can be applied to methods and code blocks, and restricts multiple threads from executing the code simultaneously on _the same object_.

```java
public class MyClass extends Thread {
  private String name;
  private MyObject myObj;
  public MyClass(MyObject obj, String n) {
    name = n;
    myObj =obj;
  }
  public void run() { myObj.foo(name);
  }
}

public class MyObject {
  public synchronized void foo(String name) {
    try {
      System.out.println("Thread " + name + ".fooO: starting"); Thread.sleep(3000);
      System.out.println("Thread " + name + ".fooO: ending");
    } catch (InterruptedException exc) {      
      System.out.println("Thread " + name + ": interrupted.");
    }
  }
}
```

Statics methods synchronize on the _class lock_ so two different threads can not execute synchronized static methods on the same class, even if they are calling different methods.

___Synchronized block___ behave really similarly to synchronized methods.

```java
public class MyClass extends Thread {
  ...
  public void run() {
    myObj.foo(name);
  }
}

public class MyObject {
  public void foo(String name) {
    synchronized(this) {
      ...
    }
  }
}
```

##### Lock

For more granular control we can utilize locks, which synchronize access to a shared resource by associating the resource with the lock.

```java
public class LockedATM {
  private Lock lock;
  private int balance = 100;

  public LockedATM() {
    lock = new ReentrantLock();
  }

  public int withdraw(int value) {
    lock.lock();
    int newVal = balance;
    try {
      Thread.sleep(100);
      newVal = newVal - value;
      THread.sleep(100);
      balance = newVal;
    } catch (InterruptedException e) {}
    lock unlock();
    return newVal;
  }
}
```

##### Deadlocks and Deadlock Prevention

A deadlock is when a thread is waiting for an object lock that another thread holds and this second thread is waiting for an object lock that the first thread holds (or an equivalent situation with several threads).

Deadlocks only occur when all four of the following conditions are met:
1.  ___Mutual Exclusion___: Only one process can access a resource at a given time.
2.  ___Hold and Wait___: Processes already holding a resource can request additional resources with relinquishing current resources.
3.  ___No Preemption___: One process cannot forcibly remove another process' resource.
4.  ___Circular Wait___: Two or more processes form a circular chain where each process is waiting on another resource in the chain.

Deadlock prevention entails removing any of the above conditions. Most deadlock prevention algorithms focus on avoiding condition #4: circular wait.
