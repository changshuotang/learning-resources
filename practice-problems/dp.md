### Longest Increasing Subsequence

```python 
def lengthOfLIS(self, nums):
	"""
	:type nums: List[int]
	:rtype: int
	"""
	if not nums:
		return 0
	dp = [1 for _ in range(len(nums))]
	for i in range(1, len(nums)):
		for j in range(i):
			if nums[i] > nums[j]:
				dp[i] = max(dp[i], dp[j]+1)
	return max(dp)
```

### Word Break

```python
def wordBreak(self, s, wordDict):
    """
    :type s: str
    :type wordDict: List[str]
    :rtype: bool
    """
    dp = [True] + [False] * len(s)
    for i in range(len(s)):
        if dp[i] == True:
            for j in range(i+1, len(s)+1):
                if s[i:j] in wordDict:
                    dp[j] = True
    return dp[-1]
```

### Maximal Square

```python
def maximalSquare(self, matrix):
	"""
	:type matrix: List[List[str]]
	:rtype: int
	"""
	if not matrix: return 0
	dp = [[0 if matrix[y][x] == '0' else 1 for x in range(len(matrix[0]))] for y in range(len(matrix))]
	
	for y in range(1, len(matrix)):
		for x in range(1, len(matrix[0])):
			if matrix[y][x] == '1':
				dp[y][x] = int(min(dp[y-1][x], dp[y][x-1], dp[y-1][x-1])) + 1
			else:
				dp[y][x] = 0
	return max(max(i) for i in dp) ** 2
```

### Longest Common Subsequence

```python
def LCS(a, b):
	x, y = len(a)+1, len(b)+1
	dp = [[0 for _ in range(x)] for _ in range(y)]
	for i in range(1, y):
		for j in range(1, x):
			if a[j-1] == b[i-1]:
				dp[i][j] = dp[i-1][j-1] + 1
			else:
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
	return dp[-1][-1]
```

### Edit Distance

```python
def minDistance(self, word1, word2):
	"""
	:type word1: str
	:type word2: str
	:rtype: int
	"""
	l1, l2 = len(word1), len(word2)
	dp = [[0 for _ in range(l1+1)] for _ in range(l2+1)]
	for y in range(l2+1):
		for x in range(l1+1):
			if y == 0:
				dp[y][x] = x
			elif x == 0:
				dp[y][x] = y
			else:
				dp[y][x] = min(dp[y-1][x] + 1, 
							   dp[y][x-1] + 1, 
							   dp[y-1][x-1] + (word1[x-1] != word2[y-1]))
	return dp[-1][-1]
```

### Coin Change

coin vs amount |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7
-------------- | --- | --- | --- | --- | --- | --- | --- | ---
__2__          | 0   | -1  | 1   | -1  | 2   | -1  | 3   | -1
__3__          | 0   | -1  | 1   | 1   | 2   | 2   | 2   | 3
__4__          | 0   | -1  | 1   | 1   | 2   | 1   | 2   | 2

```python
def coinChange(self, coins, amount):
    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """
    dp = [0] + [-1] * amount
    for i in range(1, amount+1):
        validOptions = [dp[i-c] for c in coins if i-c >= 0 and dp[i-c] != -1]
        if validOptions:
            dp[i] = min(validOptions) + 1
    return dp[-1] 
```

### Knapsack Problem

(weight,value) vs W |  0  |  1  |  2  |  3  |  4  |  5  |  6
------------------- | --- | --- | --- | --- | --- | --- | ---
__(0,0)__           | 0   | 0   | 0   | 0   | 0   | 0   | 0
__(2,3)__           | 0   | 0   | 3   | 3   | 6   | 6   | 9
__(3,5)__           | 0   | 0   | 3   | 5   | 6   | 8   | 10


```python
'''
O(n^2) space
'''
def knapSack(W, weights , values, n):
    dp = [[0 for _ in range(W+1)] for _ in range(n+1)]
    for i in range(1, n+1):
        for w in range(1, W+1):
            if w >= weights[i-1]:
                dp[i][w] = max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w]
    return dp[-1][-1]

'''
O(n) space
'''
def knapSack(W, weights, values, n):
    dp = [0] * (W+1)
    for i in range(n):
        for w in range(1, W+1):
            if w >= weights[i]:
                dp[w] = max(dp[w], dp[w-weights[i]] + values[i])
    return dp[-1]
```

### Subset Sum

Build a DP with y-axis representing sum and x-axis representing an element in the subset, including the empty set. 

Base Problem: when the sum is 0, the empty set will automatically fulfill that condition. 

{E} vs sum |  0  |  1  |  2  |  3  |  4  |  5  |  6
---------- | --- | --- | --- | --- | --- | --- | ---
__{}__     | T   | F   | F   | F   | F   | F   | F
__1__      | T   | T   | F   | F   | F   | F   | F
__2__      | T   | T   | T   | T   | F   | F   | F
__3__      | T   | T   | T   | T   | F   | F   | T

```python
'''
O(n^2) space
'''
def subsetSum(nums, sum):
    dp = [[False for _ in range(sum+1)] for _ in range(len(nums)+1)]
    dp[0][0] = True # Base case; empty set will return True for a sum of 0
    for y in range(1, len(nums)+1):
        for x in range(1, sum+1):
            if x < nums[y-1]:
                dp[y][x] = dp[y-1][x]
            else:
                dp[y][x] = dp[y-1][x] or dp[y-1][x - nums[y-1]]
    return dp[-1][-1]
```

```python
'''
O(n) space
'''
def subsetSum(nums, sum):
    dp = [True] + [False] * sum
    for n in nums:
        prevDp = dp[:]
        for x in range(1, sum+1):
            if x >= n:
                dp[x] = prevDp[x] or prevDp[x-n]
    return dp[-1]
```

### Longest Palindromic Substring

```python
def longestPalindrome(self, s):
    dp = [[False for _ in s] for _ in s]
    for i in range(len(s)):
        dp[i][i] = True
    goal = s[0]
    offset = 1
    while offset < len(s):
        for i in range(len(s) - offset):
            if offset == 1 and s[i] == s[i+offset]: # Check substrings of length 2
                dp[i][i+offset] = True
                goal = s[i:i+offset+1]
            elif s[i] == s[i+offset] and dp[i+1][i+offset-1]: # Check substrings of length 3 and up
                dp[i][i+offset] = True
                goal = s[i:i+offset+1]
        offset += 1
    return goal
```

### Jump Game II (Minimum Number of Jumps)

```python
# Time Limit Exceeded
def jump(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    dp = [sys.maxint] * len(nums)
    dp[0] = 0
    
    for i in range(1, len(nums)):
        for j in range(0, i):
            if nums[j] >= i - j:
                dp[i] = min(dp[i], dp[j] + 1)
    return dp[-1]
```

### Partition Equal Subset Sum

```python
'''
Strategy is to compute sum of all the numbers.
Then find if a subset of nums can equal half of sum.
'''
def canPartition(self, nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    totalSum = sum(nums)
    if totalSum % 2 != 0:
        return False
    dp = [True] + [False] * (totalSum // 2)
    for n in nums:
        prevDp = dp[:]
        for i in range(1, len(dp)):
            if i >= n:
                dp[i] = prevDp[i] or prevDp[i - n]
    return dp[-1]
```
