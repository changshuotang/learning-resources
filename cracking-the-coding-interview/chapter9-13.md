## 13) Java

### Overloading vs. Overriding

___Overloading___ is a term used to describe two methods that have the same name but different parameters.

```java
public double computeArea(Circle c){...}
public double computeArea(Square s){...}
```

___Overriding___ is when a method shares and same name and function signature as another method in its super class, essentially reimplementing the method for the subclass.

### Collection Framework

The java collection framework is immensely useful. Here are some commonly used items:

__ArrayList__: a dynamically resizing array, that grows as you insert elements.

```java
ArrayList<String> myArr = new ArrayList<String>();
myArr.add("one");
myArr.add("two");
System.out.printl(myArr.get(0));  /*  prints "one"  */
```

__Vector__: similar to ArrayList except that it is synchronized.

```java
Vector<String> myVect = new Vector<String>();
myVect.add("one");
myVect.add("two");
System.out.printl(myVect.get(0));  /*  prints "one"  */
```

__LinkedList (Iterator)__: Java's built-in LinkedList class helps demonstrate the syntax for an iterator.

```java
LinkedList<String> myLinkedLIst = new Linkedlist<String>();
myLinkedList.add("two");
myLinkedList.addFirst("one");
Iterator<String> iter = myLinkedLIst.iterator();
while (iter.hasNext()) {
  System.out.println(iter.next());
}
```

__HashMap__:

```java
HashMap<String, String> map = new HashMap<String, String>();
map.put("one", "uno");
map.put("two", "dos");
System.out.println(map.get("one"));
```
