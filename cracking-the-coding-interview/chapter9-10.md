## 10) Sorting and Searching

### Common Sorting Algorithms

##### Bubble Sort | Runtime: $$O(n^2)$$ for average and worst case | Memory: $$O(1)$$.

The bubble sort starts at the beginning of an array and swap the first two elements if the first is greater than the second. We do the same with the next pair of elements and so on, until the array is sorted.

##### Selection Sort | Runtime: $$O(n^2)$$ for average and worst case | Memory: $$O(1)$$.

The selection sort linearly scans the array to find the smallest element then moves it to the front by swapping it with the first element. It then finds the second smallest and moves it to the second position, repeating until the array is sorted.

##### Merge Sort | Runtime: $$O(n\ log(n))$$ for average and worst case | Memory: $$O(n)$$.

The merge sort divides the array into the smallest number of elements (1 element in this case) and merges each element with its neighbor, sorting them when merging. We do this until array is sorted.

##### Quick Sort | Runtime: $$O(n\ log(n))$$ average case and $$O(n^2)$$ worst case | Memory: $$O(log\ n)$$.

Choose a random element as a pivot and group all elements less and greater than the pivot to the left and right of it. Recursively apply this pivot sorting, with both groups.

##### Radix/Bucket Sort | Runtime: $$O(kn)$$ average case and worst case | Memory: $$O(n)$$.

A non-comparative sorting algorithm for integers (and some other data types). We iterate through each digit of the number left to right, grouping the numbers with the same digits. The $$k$$ variable in the runtime represents how many iterations we go through.

### Searching algorithms

The binary search is one of the most common search algorithms for a sorted array. You look the middle element, and if the search element is less or greater than the middle element, you take the left or right chunk of the array and apply the same process.

```java
int binarySearch(int[] arr, int val) {
  int low = 0;
  int high = arr.length - 1;
  int mid;

  while(low < high) {
    mid = (low + high) / 2;
    if (arr[mid] < val) low = mid - 1;
    if (arr[mid] > val) high = mid + 1;
    else return mid;
  }
  return -1;
}
```

