## 8) Recursion and Dynamic Programming

### How to Approach

To approach recursion we want to first find the 'base case' or the simplest data set the algorithm will run on. Once we find the base case it is easy to build upon it and find a recursive approach that will eventually lead to the base case.

### Recursive vs. Iterative Solutions

Recursive algorithms can always be implemented iteratively. Iterative solutions are almost always more space efficient when compared to their recursive counterpart, but can be vastly more difficult to implement. The trade off is efficiency vs. complexity.

### Dynamic Programming & Memoization

Dynamic programming involves breaking up a problem into overlapping subproblems, and caching results for future iterations. Dynamic programming is often used in recursion to increase efficiency.


##### Recursion

```c++
int fib(int x)
{
    if (x < 2)
        return 1;

    return fib(x-1) + fib(x-2);
}
```

##### Recursion with DP

```c++
void fib(int x)
{
    static vector<int> cache(N, -1);

    int& result = cache[x];

    if (result == -1)
    {
        if (x < 2)
            result = 1;
        else
            result = fib(x-1) + fib(x-2);
    }

    return result;
}
```
