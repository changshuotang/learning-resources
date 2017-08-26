### Sort a stack using only another stack

```java
// If helper stack is empty push
// If stack.peek is less than value pop

public Stack<E> sortStackWithStack(Stack<E> stk){
	Stack<E> helper = new Stack<E>;
	while (!stk.empty()){
		while (helper.empty() || helper.peek() > stk.peek()){
			helper.push(stk.pop());
		}
		E temp = stk.pop();
		while (!helper.empty() && helper.peek() < temp){
			stk.push(helper.pop());
		}
		helper.push(temp);
	}
	return helper;
}
```

### Find the position of a number in a sorted array

```java
public int binSearch(int[] arr, int k){
	int lo = 0;
	int hi = arr.length - 1;
	while (hi >= lo){
		//int pos = (hi+lo)/2;   MIGHT CAUSE OVERFLOW
		int pos = lo + (hi-lo)/2;
		if (arr[pos] == k) return pos;
		else if (arr[pos] > k) hi = pos - 1;
		else if (arr[pos] < k) lo = pos + 1;
	}
	return -1;
}
```

### Return k elements from an array ordered from highest occurring to lowest occurring; at least O(n log n) time

```java
public List<Integer> topKFrequent(int[] arr, int k){
	Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
	for (int i: arr){
		freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
	}
	PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
	for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
		maxHeap.add(entry);
	}
	List<Integer> list = new ArrayList<>();
	while (maxHeap.peek() != null && k > 0){
		list.add(maxHeap.poll().getKey());
		k--;
	}
	return list;
}
```

### A broken clock is right twice a day, given k the number of seconds the clock will move per second passed and h hours elapsed find out how many times the clock was accurate

```java
// k = - 2, h = 24, output = 6
// k = -1, h = 24, output = 4
// k = 0, h = 24, output = 2
// k = 1, h = 24, output = undefined
// k = 2, h = 24, output = 2, rate = 12
// k = 3, h = 24, output = 4, rate = 6
// k = 4, h = 24, output = 6, rate = 4

public int brokenClock(int k, int hours){
	if (k == 1) throw new Error();
	double rate = 12.0 / (Math.abs(1 - k));
	return Math.floor(hours / rate);
}
```

### Reverse a linked list

```java
// Recursive Solution
public ListNode reverseList(ListNode head){
	if (head == null || head.next == null) return head;
	ListNode tail = reverseList(head.next); //bubble tail up 
	head.next.next = head; //point head.next to head
	head.next = null; //prevent loop
	return tail;
}

// Iterative Solution
public ListNode reverseList(ListNode head){
	ListNode previous = null;
	while (head != null){
		ListNode next = head.next;
		head.next = previous;
		previous = head;
		head = next;
	}
	return previous;
}
```

### Find the median of two sorted integer array

```python
def findMedianSortedArrays(self, nums1, nums2):
	if len(nums1) == 0 return self.median(nums2)
	if len(nums2) == 0 return self.median(nums1)
	mid = math.floor((len(nums1) + len(nums2)) / 2)
	for _ in range(mid):
		if not nums1:
			temp = nums2.pop()
		elif not nums2:
			temp = nums1.pop()
		elif nums1[-1] > nums2[-1]:
			temp = nums1.pop()
		elif nums1[-1] < nums2[-1]:
			temp = nums2.pop()
		elif len(nums1) <= 1:
			temp = nums2.pop()
		elif len(nums2) <= 1:
			temp = nums1.pop()
	if len(nums1) == 0:
		temp2 = nums2[-1]
	elif len(nums2) == 0:
		temp2 = nums1[-1]
	else:
		temp2 = math.max(nums2[-1], nums1[-1])
	return temp2 if (len(nums1) + len(nums2)) % 2 == 1 else (temp1 + temp2) / 2
    
def median(self, arr):
	mid = math.floor(arr.length / 2) 
	return arr[mid] if mid % 2 == 1 else (arr[mid] + arr[mid-1] / 2)
```

### Swap pairs in a linked list

```java
// Recursive solution
public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) return head;
	ListNode newHead = head.next;
	head.next = swapPairs(newHead.next);
	newHead.next = head;
	return newHead;
}
```

### Find the n-th number in the Fibonacci sequence recursively

```java
public int fib(int n){
	if (n <= 0) return 0;
	if (n <= 2) return 1;
	else return fib(n-1) + fib(n-2);
}
```

### Ways to climb n-stairs (can take 1 or 2 steps)

```java
// 1
// 11, 2
// 111, 12, 21 
// 1111, 112, 121, 211, 22
public int climbStairs(int n) {
	int a = 1, b = 1;
	for (int i = 0; i < n; i++){
		b += a;
		a = b - a;
	}
	return a;
}
```

### Ways to climb n-stairs (can take up to k steps)

```java
// O(k^n) run time
public static double climbStairs(int n, int k) {
	if (n <= k){
		return Math.pow(2, n-1); // Math.pow() returns a double
	}
	double c = 0;
	for (int i = 1; i <= k; i++){
		c += climbStairs(n-i, k);
	}
	return c;
}
```

### Cut the sticks

```python
def cutTheSticks(sticks):
	sticks.sort()
	while sticks:
		print len(sticks)
		min = sticks[0]
		sticks = filter(lambda x: x > 0, map(lambda x: x - min, sticks))
	return
```

### Maximal Rectangle (Find largest rectangle of 1's)

```python
def maximalRectangle(self, matrix):
	"""
	:type matrix: List[List[str]]
	:rtype: int
	"""
	for row in matrix:
		for x in range(len(row)):
			height[x] = height[x] + 1 if row[i] == '1' else 0
		stack = [-1]
		for x in range(len(row) + 1):
			while height[x] < height[stack[-1]]:
				h = height[stack.pop()]
				w = x - 1 - h
				ans = max(ans, h * w)
			
	
```