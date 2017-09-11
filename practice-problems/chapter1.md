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

### Group Anagrams

```python
def groupAnagrams(self, strs):
	"""
	:type strs: List[str]
	:rtype: List[List[str]]
	"""
	d = {}
	for string in strs:
		key = tuple(sorted(string))
		d[key] = d.get(key, []) + [string]
	return d.values()
```

### Number of Islands

```python
"""
Iterate through each space.
If a '1' change to zero along with all connected 1s.
Increase
"""
def numIslands(self, grid):
	"""
	:type grid: List[List[str]]
	:rtype: int
	"""
	count = 0
	for i in range(len(grid)):
		for j in range(len(grid[0])):
			if grid[i][j] == '1':
				self.dfs(grid, i, j)
				count += 1
	return count

def dfs(self, grid, i, j):
	if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] != '1':
		return
	grid[i][j] = '0'
	self.dfs(grid, i-1, j)
	self.dfs(grid, i, j-1)
	self.dfs(grid, i+1, j)
	self.dfs(grid, i, j+1)
```

### Spiral Matrix

```python
def spiralOrder(self, matrix):
	res = []
	if not matrix or not matrix[0]:
		return res
	x1, y1 = 0, 0
	x2, y2 = len(matrix[0])-1, len(matrix)-1
	while True:
		for x in range(x1, x2+1):
			res += [matrix[y1][x]]
		y1 += 1
		for y in range(y1, y2+1):
			res += [matrix[y][x2]]
		x2 -= 1
		if x1 > x2 or y1 > y2:
			break
		for x in range(x2, x1-1, -1):
			res += [matrix[y2][x]]
		y2 -= 1
		for y in range(y2, y1-1, -1):
			res += [matrix[y][x1]]
		x1 += 1
		if x1 > x2 or y1 > y2:
			break
	return res
```

### Combination Sum

Given an array of numbers and a target number, find all combinations of number with the target as its sum. Reusing numbers is allowed.

```python
def combinationSum(self, candidates, target):
	"""
	:type candidates: List[int]
	:type target: int
	:rtype: List[List[int]]
	"""
	res = []
	self.dfs(candidates, target, [], res)
	return res
	
def dfs(self, candidates, target, arr, res):
	if target < 0:
		return
	elif target == 0:
		res.append(arr)
		return 
	for i, n in enumerate(candidates):
		self.dfs(candidates[i:], target - n, arr + [n], res)
```


### Permutations

```python
def permute(self, nums):
	"""
	:type nums: List[int]
	:rtype: List[List[int]]
	"""
	res = []
	self.helper(nums, [], res)
	return res

def helper(self, nums, arr, finalArr):
	if not nums:
		finalArr.append(arr)
		return
	for i, n in enumerate(nums):
		self.helper(nums[:i] + nums[i+1:], arr + [n], finalArr)
```

### Combination

```python 
def combine(self, n, k):
	arr = range(1, n+1)
	res = []
	self.dfs(arr, k, [], res)
	return res
	
def dfs(self, nums, k, arr, res):
	if k < 0:
		return
	if k == 0:
		res.append(arr)
		return
	for i, x in enumerate(nums):
		self.dfs(nums[i+1:], k-1, arr+[x], res)
```

```python
def combine(self, n, k):
	arr = range(1, n+1)
	res = []
	self.dfs(arr, k, 0, [], res)
	return res

def dfs(self, nums, k, index, arr, res):
	if k < 0:
		return
	if k == 0:
		res.append(arr)
		return
	for i in range(index, len(nums)):
		self.dfs(nums, k-1, i+1, arr+[nums[i]], res)
```

### Valid Palindrome

```python
def isPalindrome(self, s):
	"""
	:type s: str
	:rtype: bool
	"""
	import re
	a = re.sub(r"\W", r"", s.lower())
	return a == a[::-1]
```

### Valid Parentheses 

```python
def isValid(self, s):
	"""
	:type s: str
	:rtype: bool
	"""
	d = { '{': '}', '[': ']', '(': ')' }
	stk = []
	for c in s:
		if c in d.keys():
			stk.append(c)
		elif not stk or d[stk.pop()] != c:
			return False
	return len(stk) == 0
```

### Subset

```python
def subsets(self, nums):
	res = [[]]
	for i in nums:
		for arr in res[:]:
			res.append(arr + [i])
	return res
```

```python
# Bit Manipulation
def subsets(self, nums):
	res = []
	for i in range(0, 2 ** len(nums)):
		arr = []
		for j in range(len(nums)):
			if (i >> j) & 1 == 1:
				arr.append(nums[j])
		res.append(arr)
	return res
```

```python
# One Liner Bit Manipulation
def subsets(self, nums):
	return [[x for j,x in enumerate(nums) if (i >> j) & 1 == 1] for i in range(0, 2 ** len(nums))]
```

### Remove Duplicate Letters

```python
'''
Greedy Solution:
- Try substrings starting with the smallest chars first
- If substring contains all characters in set(s)
- Add char to result and recurse with rest of substring
'''
def removeDuplicateLetters(self, s):
	"""
	:type s: str
	:rtype: str
	"""
	for c in sorted(set(s)):
		suffix = s[s.index(c):]
		if set(suffix) == set(s):
			return c + self.removeDuplicateLetters(suffix.replace(c, ''))
	return ''
```
