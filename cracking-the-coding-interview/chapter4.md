# IV. Big O

Big O is how we describe the efficiency of algorithms. An analogy for comparing different Big O efficiency would be a situation where you need to transfer a file to another person ASAP. Most people would assume that sending it electronically would be 

 fastest method but what if the file size was extremely large? The situation would arise that getting on a plane and delivering the file personally in a portable hard drive would be faster.

## Time Complexity

We can describe the data transfer 'algorithm' in different time complexities:
- _Electronic Transfer_: $$O(s)$$, where s is the size of the file. The transfer time is dependent on the size of the file.
- _Airplane Transfer_: $$O(1)$$, as the file size increase, the delivery time remains constant.

Remember that Big O describes the asymptotic runtime of an algorithm, so no matter how big the constant is in $$O(1)$$, $$O(s)$$ will inevitably eventually surpass it.

Common run times include:
- $$O(log N)$$
- $$O(N log N)$$
- $$O(N)$$
- $$O(N^2)$$
- $$O(2^N)$$

#### Big O, Big Theta, and Big Omega

- __Big O__: describes the upper bound
- __Big Omega__: describes the lower bound
- __Big Theta__: describes the tight, like Big O and Omega combined

#### Best Case, Worst Case, and Expected Case

Lets examine each scenario through the perspective of a quick sort on an array of elements:
- __Best Case__: If all elements are equal, quick sort will just traverse the array just once. This is $$O(N)$$.
- __Worse Case__: If the pivot in quick sort is repeatedly the biggest element we will have to traverse the array $$N$$ times, which will result in $$O(N^2)$$.
- __Expected Case__: We expect the pivot to be sometimes high and sometimes low, so on average we can expect a runtime of $$O(N log N)$$.

## Space Complexity

Time efficiency is not the only thing we care about; the amount of memory, or space, required by the algorithm is important too. If we need a 2D array of size $$n * n$$ we will require $$O(n^2)$$ space.

Remember that stack space in recursive calls counts too. So the following code would take $$O(n)$$ time and $$O(n)$$ space.

```java
int sum(int n) {
  if (n <= 0) {
    return 0;
  }
  return n + sum(n - 1);
}
```

However, having n calls does not always result in using $$O(n)$$ space.

```java
int pairSumSequence(int n){
  int sum = 0;
  for (int i = 0; i < n; i++) {
    sum += pairSum(i, i + 1);
  }
  return sum;
}

int pairSum(int a, int b) {
  return a + b
}
```
There will be about $$O(n)$$ calls to ```pairSum```, but since the calls do not exist simultaneously on the call stack, we only need $$O(1)$$ space.

## Drop the Constants and Non-Dominant Terms

Because Big O describes the asymptotic runtime, $$O(2N)$$ can be simplified to just $$O(N)$$, and $$O(N^2 + N)$$ becomes just $$O(N^2)$$.

## Multi-Part Algorithms: Add vs. Multiply

Lets take an algorithm where you print each element in array A, then print each element in array B. We will do A chunks of work then B chunks of work, so we add the runtime. $$O(A + B)$$.

For another algorithm where we where for each element in array A, we print each element in array B, we are doing B chunks of work for every element in A. The total runtime would be $$O(A * B)$$ in this case.

## Amortized Time

An ```ArrayList``` is implemented using an array that is copied to another array double in capacity once we fill it up. How do we describe the runtime of the insertion process utilized by the ```ArrayList```?

The array could be full, in which case the insertion of a new element will take $$O(N)$$ time (creating an array of size 2N and copying N elements over). In most cases it will take just $$O(1)$$ time. We will need to take both cases into account.

For the insertion of up to X number of elements we can assume the array starts at size 1 and increases in powers of 2 until X:

$$
1+2+4+8+16+...+X
$$

Reading the equation from right to left we can rewrite it as such:

$$
X+X/2+X/4+X/8+...+1=2X
$$

The times when we have to resize are far and in between, so much so that the cost of doing so has been amortized. Inserting X amount of elements will take $$O(2X)$$ amount of time, so inserting one element will take $$O(1)$$ time.

## Log N Runtimes

Common search algorithms like the binary search, where we halve our search space each loop, take $$O(logN)$$ time.

## Recursive Runtimes

What is the runtime of the following:
```java
int f(int n){
  if (n <= 1){
    return 1;
  }
  return f(n - 1) + f(n - 1)
}
```
We can see that the amount of function calls double for each iteration in the recursive loop, until iteration n.

$$
1+2+4+8+...
$$

Which follows the pattern of:

$$
2^0+2^1+2^2+...+2^{N-1}=2^N-1
$$

So the run time of the function would be $$O(2^N)$$. This pattern holds true for recursive functions that make multiple calls, and tends to look like $$O(branches^{depth})$$.