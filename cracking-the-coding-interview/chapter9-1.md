# IX. Interview Questions

## 1) Arrays and Strings

### Hash Tables

A simple and common implementation of the hash table would be using an array of linked lists and a hash function.
- First compute the hash code.
- Then map the hash code to an index in the array, such as using: ```hash(key) % array_length```
- Store the value at the index using the linked list to resolve collision.

If collision is high, the worst case runtime is $$O(N)$$. Assuming good implementation and minimum collision, the lookup time is $$O(1)$$.

Alternatively we can implement the hash table with a balanced binary search tree, which will give us $$O(log N)$$ lookup time, but may use less space since we do not need to allocate a huge array.

### ArrayList & Resizable Arrays

Look at the _Amortized Time_ section.

### StringBuilder

Imagine we are concatenating a list of n strings of size x. A simple implementation would be:

```java
for (String w : words) {
  returnString = returnString + w;
}
return returnString;
```

But doing so like above requires us to copy x characters in the first iteration, 2x characters in the  second iteration, and so on until the nth iteration, resulting in a $$O(xn^2)$$ runtime. Not very efficient at all.

Solve this using the StringBuilder class, a resizable array of all the strings.

```java
StringBuilder sentence = new StringBuilder();
for (String w : words) {
  sentence = sentence.append(w);
}
return sentence.toString();
```

We only copy the strings once, in the final return statement. This will give us a $$O(xn)$$ runtime.