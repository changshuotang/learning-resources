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

### Recursively reverse a linked list

```java
public ListNode reverseList(ListNode head){
	if (head == null || head.next == null) return head;
	ListNode tail = reverseList(head.next); //bubble tail up 
	head.next.next = head; //point head.next to head
	head.next = null; //prevent loop
	return tail;
}

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

