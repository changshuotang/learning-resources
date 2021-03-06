/**
  * Check if string consists of only unique characters
	*/

boolean isUnique(String s) {
	boolean[] characters = new boolean[256];
	for (char c : s.toCharArray()) {
		if (characters[c] == true) return false;
		characters[c] = true;
	}
	return true;
}

/**
  * Find 1st non-repeated char in string
	*/

char firstNonRepeatedChar(String s) {
	int[] frequencies = new int[256];
	for (char c : s.toCharArray()) {
		frequencies[c]++;
	}
	for (char c : s.toCharArray()) {
		if (frequencies[c] == 1) return c;
	}
	return '';
}

/**
  * Reverse a string in place
	*/

void reverseString(String s) {
	char[] chars = s.toCharArray();
	for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
		char tmp = chars[i];
		chars[i] = chars[j];
		chars[j] = tmp;
	}
	return new String(chars);
}

/**
  * Swap pairs in linked list recursively
  * 1 -> 2 -> 3 -> 4
  * 2 -> 1 -> 4 -> 3
  */

void swapPairs(Node head) {
	if (head == null) {
		return null;
	}
	if (head.next == null) {
		return head;
	}
	Node second = head.next;
	Node third = second.next;
	second.next = head;
	head.next = swapPairs(third);
	return second;
}

/**
  * Remove n-th last node from a linked list
  * 1 -> 2 -> 3 -> 4 -> 5
  */

Node removeNthLastNode(Node head, int n) {
	if (head == null) return null;
	Node it = head;
	while (n > 1) {
		if (it.next == null) return it;
		it = it.next;
		n--;
	}
	Node it2 = head;
	while (it.next != null) {
		it = it.next;
		it2 = it2.next;
	}
	it2.next = it2.next.next;
	return head;
}

/**
 	* Recursively reverse  a linked list
  * 1 -> 2 -> 3 -> 4 -> 5
	*/

Node reverse(Node head) {
	if (head == null) return null;
	if (head.next == null) return head;
	Node second = head.next;
	head.next = null;
	Node rest = reverse(second);
	second.next = head;
	return rest;
}

/**
	* Iteratively reverse a linked list
	*/

Node reverse(Node head) {
	if (head == null || head.next == null) return head;
	Node prev = null;
	Node cur = head;
	Node next = null;
	while (cur != null) {
		next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
	}
	return prev;
}

/**
 	* Delete a node given only that node (and if not last in a linked list)
	*/

void deleteNode(Node n) {
	n.val = n.next.val;
	n.next = n.next.next;
}

/**
 	* Check if two strings are anagrams of each other
	*/

boolean isAnagram(String a, String b) {
	if (a.length() != b.length()) return false;
	int[] frequencies = new int[256];
	for (char c : a.toCharArray()) {
		frequencies[c]++;
	}
	for (char c : b.toCharArray()) {
		frequencies[c]--;
		if (frequencies[c] < 0) return false;
	}
	for(int i : frequencies) {
		if (i > 0) return false;
	}
	return true;
}

/**
 	* Return the # of deletes in order to make two strings anagrams of each other
	*/

int numDeletesAnagram(String a, String b) {
	int length = (a.length() > b.length()) ? a.length() : b.length();
	int[] frequencies = new int[256];
	char[] aChar = a.toCharArray();
	char[] bChar = b.toCharArray();
	for (int i = 0; i < length; i++) {
		if (length < a.length()) {
			frequencies[aChar[i]]++;
		}
		if (length < b.length()) {
			frequencies[bChar[i]]--;
		}
	}
	int numDeletes = 0;
	for (int i : frequencies) {
		numDeletes += Math.abs(i);
	}
	return numDeletes;
}

/**
 	* Find the pair in a array that have the smallest absolute value difference
	*/

int[] smallestAbsValPair(int[] arr) {
	int[] pair = new int[2];
	int absDiff = Integer.MAX_VALUE;
	Arrays.sort(arr);
	for (int i = 0; i < arr.length - 1; i++) {
		int diff = Math.abs(arr[i] - arr[i+1]);
		if (diff < absDiff) {
			absDiff = diff;
			pair[0] = arr[i];
			pair[1] = arr[i+1];
 		}
	}
	return pair;
}

/**
  * Implement strStr(). Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  */

public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}

/**
 	* Find the number of times a substring occurs in a string
	*/

int numSubstrOccurence(String substr, String str) {
	char[] substrChar = substr.toCharArray();
	int i = 0;
	for (char c : str.toCharArray()) {
		if (i < substr.length() && substrChar[i] == c) {
			i++;
		}
		else if (i > 0) {
			i = 0;
		}
		if (i == substr.length()) {
			count++;
			i = 0;
		}
	}
	return count;
}

/**
  * Given two strings, find the number of times the second string occurs in the first string, whether continuous or discontinuous.
  */

int numSubsequence(String a, String b) {

}

/**
 	* Add two binary numbers represented as strings
	*/

String addBinaryString(String bin1, String bin2) {
	int len1 = bin1.length();
	int len2 = bin2.length();
	int length;
	if (len1 > len2) {
		length = len1;
		for (int i = 0; i < len1 - len2; i++) {
			bin2 = '0' + bin2;
		}
	} else {
		length = len2;
		for (int i = 0; i < len2 - len1; i++) {
			bin1 = '0' + bin1;
		}
	}
	int carry = 0;
	String result;
	for (int i = 0; i < length; i++) {
		int bit1 = Integer.parseInt(bin1.charAt(i));
		int bit2 = Integer.parseInt(bin2.charAt(i));
		int sum = carry ^ bit1 ^ bit2;
		result = Integer.toString(sum) + result;
		carry = (bit1 & bit2) | (carry & bit1) | (carry & bit2);
	}
	if (carry == 1) {
		result = '1' + result;
	}
	return result;
}

/**
 	* Validate that a string containing different parenthesis is valid (closing in the right order)
	* Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘, and ‘]’,
	* determine if the input string is valid
	*/

boolean validParenthesis(String parenthesis) {
	Map<Character, Character> validBraces = new HashMap<Character, Character>();
	validBraces.put('(',')');
	validBraces.put('{','}');
	validBraces.put('[',']');

	Stack<Character> s = new Stack<Character>();
	for (char brace : parenthesis.toCharArray()) {
		if (validBraces.containsKey(brace)) {
			s.push(brace);
		} else if (validBraces.containsValue(brace) && !s.empty() && validBraces.get(s.peek()) == brace) {
			s.pop();
		} else {
			return false;
		}
	}
	return s.empty();
}

/**
 	* Print all possible permuatations of a string
	*/

void printPermutations(String str) {
	printPermutationsHelper("", str);
}

void printPermutationsHelper(String perm, String str) {
	if (str.length() == 0) {
		System.out.println(perm);
	} else {
		for (int i = 0; i < str.length(); i++) {
			printPermutationsHelper(prefix + str.charAt(i),
															str.substring(0,i) + str.substring(i+1,str.length()));
		}
	}
}

/**
 	* Return whether two strings are isomorphic
	* egg, fee -> TRUE
	* get, tet -> FALSE
	*/

boolean isIsomorphic(String str1, String str2) {
	if (str1.length() != str2.length()) {
		return false;
	}
	Map<Character, Character> pairs = HashMap<>();
	for (int i = 0; i < str1.length(); i++) {
		char char1 = str1.charAt(i);
		char char2 = str2.charAt(i);
		if (pairs.containsKey(char1)) {
			if (pairs.get(char1) != char2) {
				return false;
			}
		} else {
			if (pairs.containsValue(char2)) {
				return false;
			}
			pairs.put(char1, char2);
		}
	}
	return true;
}

/**
 	* Find the minimum distance between two words in an array of strings (duplicates exist)
	*/

int shortestWordDistance(String[] words, String w1, String w2) {
	int minDist = Integer.MAX_VALUE;
	int idx1 = -1, idx2 = -1;
	boolean first = false, second = false;
	for (int i = 0; i < words.length; i++) {
		if (w1.equals(w2)) {
			if (words[i].equals(w1)) {
				if (first == false) {
					idx1 = i;
					first = true;
				} else if (second == false) {
					idx2 = i;
					second = true;
				} else {
					idx1 = idx2;
					idx2 = i;
					minDist = Math.min(minDist, Math.abs(idx2 - idx1));
				}
			}
		} else {
			if (words[i].equals(w1)) {
				idx1 = i;
				first = true;
			} else if (words[i].equals(w2)) {
				idx2 = i;
				second = true;
			}
			if (first && second) {
				minDist = Math.min(minDist, Math.abs(idx2 - idx1));
			}
		}
	}
	return minDist;
}

/**
 	* Return the unique items in a unsorted array
	*/

List<Integer> returnUniqueElements(int[] arr) {
	List<Integer> unique = new ArrayList<>();
	Set<Integer> set = new HashSet<>();
	for (int i : arr) {
		if (!set.contains(i)) {
			set.add(i);
			unique.add(i);
		}
	}
	return unique;
}

/**
 	* Return the unique items in a sorted array
	*/

int[] returnUniqueElementsInSortedArray(int[] arr) {
	int i = 0;
	int current = Integer.MIN_VALUE;
	for (int j = 0; j < arr.length; j++) {
		if (arr[j] != current) {
			arr[i] = arr[j];
			i++;
		}
		current = arr[j];
	}
	return Arrays.copyOfRange(arr, 0, i+1);
}

List<Integer> returnUniqueElementsInSortedArray(int[] arr) {
	int current = Integer.MIN_VALUE;
	List<Integer> unique = new ArrayList<Integer>();
	for (int num : arr) {
		if (num != current) {
			unique.add(num);
		}
		current = num;
	}
	return current;
}

/**
 	* Print out the duplicates in an unsorted array
	*/

void printDuplicates(int[] arr) {
	Set<Integer> set = new HashSet<>();
	for (int num : arr) {
		if(set.contains(num)) {
			System.out.println(num);
		} else {
			set.add(num);
		}
	}
}

/**
	* Print out duplicates in an sorted array
	*/

void printDuplicatesSorted(int[] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
		if (arr[i] == arr[i+1]) {
			System.out.println(arr[i]);
		}
	}
}

/**
 	* Check if a string is just a rotation of another string
	*/

boolean checkRotation(String str1, String str2) {
	String combined = str1 + str2;
	if (combined.contains(str1)) {
		return true;
	}
	return false;
}

/**
 	* Implement a function that returns x^n
	* n is a positive/negative integer
	*/

double pow(double x, int n) {
	int temp;
	if (n == 0) return 1;
	temp = pow(x, n/2);
	if (n % 2 == 0) { // even
		return temp*temp;
	} else { // odd
		if (n > 0) {
			return temp*temp*x
		} else {
			return (temp*temp)/x;
		}
	}
}

/**
 	* Find the missing number given given a list of n-1 integers, these integers
  * are in the range 1 to n. One of the integers list is missing in the list and
	* you have to find it
	*/

int missingNumber(int[] nums) {
	// sum = n(n+1)/2
	int n = nums.length;
	int sum = n*(n+1)/2;
	for (int num : nums) {
		sum -= num;
	}
	return sum;
}

/**
 	* Find max sub-array sum of input array of positive and negative integers
	*/

int maxSubarraySum(int[] nums) {
	int max = 0;
	int maxEndingHere = 0;
	for (int num : nums) {
		maxEndingHere += num;
		if (maxEndingHere < 0) {
			maxEndingHere = 0;
		}
		if (max < maxEndingHere) {
			max = maxEndingHere;
		}
	}
	return max;
}

/**
 	* Return all factors of a number
	*/

List<Integer> returnFactors(int n) {
	List<Integer> factors = new ArrayList<>();
	int inc = 1;
	if (n % 2 == 1) { // odd number
		inc = 2;
	}
	for (int i = 1; i <= n/2; i += inc) {
		if (n % i == 0) {
			factors.add(i);
		}
	}
	factors.add(n);
	return factors;
}

/**
 	* Move all zeroes in an array to the end
	* {1,2,0,0,1,2,0} -> {1,2,1,2,0,0,0}
	* {0,1,2,3,0,0} -> {1,2,3,0,0,0}
	*/

int[] pushZeroesToEnd(int[] arr) {
	int current = 0;
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] != 0) {
			arr[current] = arr[i];
			if (current != i) arr[i] = 0;
			current++;
		}
	}
	return arr;
}

/**
 	* Remove duplicates in linked list
	* 1 -> 0 -> 0 -> 2 -> 3 -> 2
	*/

Node removeDups(Node head) { // not legit solution
	if (head == null || head.next == null) {
		return head;
	}
	Node prev = head;
	Node cur = head.next;
	Set<Integer> set = new HashSet<>();
	while (cur != null) {
		set.add(prev.val);
		if (set.contains(cur.val)) {
			prev.next = cur.next;
		}
		prev = prev.next;
		prev != null ? cur = prev.next : cur = null;
	}
	return head;
}

Node removeDups(Node head) { // better solution
	if (head == null || head.next == null) {
		return head;
	}
	Node prev = null;
	Node cur = head;
	Set<Integer> set = new HashSet<>();
	while (cur != null) {
		if(set.contains(cur.val)) {
			prev.next = cur.next;
		} else {
			set.add(cur.val);
			prev = cur;
		}
		cur = cur.next;
	}
	return head;
}

/**
 	* Find if a linked list is looped
	*/

boolean isLooped(Node head) { // version where you don't return node where loop starts
	Node slow = head;
	Node fast = head;
	while (slow != null && fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) {
			return true;
		}
	}
	return false;
}

/**
  * Return the node where the loop starts
	*/

Node returnLooped(Node head) {
	Node slow = head;
	Node fast = head;
	while (slow != null && fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) {
			break;
		}
	}
	if (slow == fast) {
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}	else {
		return null;
	}
}

/**
  * Remove the loop
	*/

void removeLoop(Node head) {
	Node slow = head;
	Node fast = head;
	while (slow != null && fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) break;
	}
	if (slow == fast) {
		slow = head;
		while(slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = null;
	}
}

/**
  * Implement a queue with a linked list
	*/

class Queue {
	private Node head;
	private Node tail;

	public Queue() {
		head = null;
		tail = null;
	}

	public isEmpty() {
		if (head == null && tail == null) return true;
		return false;
	}

	public void enqueue(int n) {
		if (isEmpty()) {
			tail = new Node(n);
			head = tail;
		} else {
			tail.next = new Node(n);
			tail = tail.next;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			return -1;
		} else {
			int returnVal = head.val;
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return returnVal;
		}
	}
}

/**
 	* Implement a queue with an array
	*/

class Queue { // FIFO
	private int[] arr;
	private int size;
	private int first;
	private int last;

	public Queue(int size) {
		arr = new int[size];
		this.size = size;
		this.first = -1;
		this.last = -1;
	}

	public boolean isEmpty() {
		if (first == -1 && last == -1) return true;
		return false;
	}

	public boolean enqueue(int n) { // increment last THEN set value!
		if (isEmpty()) {
			first++;
			last++;
			arr[last] = n;
			return true;
		} else {
			if (last != first) {
				last = (last % size) + 1;
				arr[last] = n;
				return true;
			}
			return false;
		}
	}

	public int dequeue(int n) {
		if (isEmpty()) {
			return -1;
		} else {
			int returnVal = arr[first];
			if (first == last) {
				first = -1;
				last = -1;
			} else {
				first = (first % size) + 1;
			}
			return returnVal;
		}
	}
}

/**
 	* Implement a stack that returns the minimum value in constant time (no dups)
	*/

class Stack {
	private List<Integer> s;
	private List<Integer> mins;

	public Stack() {
		s = new ArrayList<>();
		mins = new ArrayList<>();
	}

	public void push(int num) {
		s.add(num);
		if (mins.isEmpty() || num < mins.get(mins.size()-1)) {
			mins.add(num);
		}
	}

	public int pop() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int ret = s.get(s.size()-1);
		if (ret == mins.get(mins.size()-1)) {
			mins.remove(mins.size()-1);
		}
		s.remove(s.size()-1);
		return ret;
	}

	public int getMin() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return mins.get(mins.size()-1);
	}

	public int peek() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return s.get(s.size()-1);
	}

	public boolean isEmpty() {
		return s.isEmpty() && mins.isEmpty();
	}
}

/**
  * Implement a queue with two stacks
  */

class StackQueue {
  private Stack<Integer> s;
  private Stack<Integer> q;

  public StackQueue() {
    s = new Stack<>();
    q = new Stack<>();
  }

  public void enqueue(int num) {
    s.push(num);
  }

  public int dequeue() {
    if (q.isEmpty()) {
      while(!s.isEmpty()) {
        q.push(s.pop());
      }
    }
    return q.isEmpty() ? -1 : q.pop();
  }
}

/**
  * Sort a stack with only another stack
  */

Stack<Integer> sortStackWithStack(Stack<Integer> s) {
	Stack<Integer> sorted = new Stack<>();
	while (!s.isEmpty()) {
		int tmp = s.pop();
		while (!sorted.isEmpty() && tmp > sorted.peek()) {
			s.push(sorted.pop());
		}
		sorted.push(tmp);
	}
	return sorted;
}

/**
  * Find a number in a sorted array
  */

boolean binarySearch(int[] sortedArr, int key) {
	int beg = 0;
	int end = sortedArr.length - 1;
	int mid;
	while(beg <= end) {
		mid = (end + beg)/2;
		if (sortedArr[mid] == key) {
			return true;
		} else if (sortedArr[mid] > key) {
			end = mid;
		} else {
			beg = mid;
		}
	}
	return false;
}

/**
 	* Return the top k frequent elements in an array
	*/

/**
 	* Return the top k elements in an array
	*/

List<Integer> kFrequent(int[] arr, int k) {
	Queue<Integer> pq = new PriorityQueue<>();
	for (int num :arr) {
		pq.add(num);
		if (pq.size() > k) pq.poll();
	}
	List<Integer> fin = new ArrayList<Integer>();
	while (!pq.isEmpty()) {
		fin.add(pq.poll());
	}
	return fin;
}

/**
  * Given two strings, return whether the first string is contained in the second string
  */

boolean contains(String str1, String str2) {
  int[] chars = new int[256];
  for (char c : str1.toCharArray()) {
    chars[c]++;
  }
  for (char c : str2.toCharArray()) {
    chars[c]--;
  }
  for (int count : chars) {
    if (count > 0) return false;
  }
  return true;
}

/**
	* Given an array of strings, group the anagrams together
	*/

Map<String, List<String>> groupAnagrams(String[] strings) {
  Map<String, List<String>> map = new HashMap<>();
  for (String str : strings) {
    String sortedStr = String.join("",Arrays.sort(str.toCharArray()));
    if (map.containsKey(sortedStr)) {
      map.get(sortedStr).add(str);
    } else {
      map.put(sortedStr, new ArrayList<String>);
      map.get(sortedStr).add(str);
    }
  }
  return map;
}

/**
 	* Reverse words in a sentence
	*/

String reverseWords(String sentence) {
	String[] sentenceList = sentence.split(" ");
	int len = sentenceList.length;
	for (int i = 0; i < len/2; i++) {
		String tmp = sentenceList[i];
		sentenceList[i] = sentenceList[len - 1 - i];
		sentenceList[len - 1 - i] = tmp;
	}
	return String.join(' ', sentenceList);
}

/**
	* Length of longest substring without repeating characters
	*/

int longestUniqueSubstring(String str) {
  int longest = 1;
  Set<Character> uniqueChars = new HashSet<>();
  char[] strArr = str.toCharArray();
  int i = 0, j = 0;
  while (j < str.length()) {
    while (uniqueChars.contains(strArr[j])) {
      uniqueChars.remove(strArr[i]);
      i++;
    }
    uniqueChars.add(strArr[j]);
    j++;
    longest = Math.max(longest, j - i);
  }
  return longest;
}

/**
 	* Find longest common prefix
	*/

String longestCommonPrefix(String[] strings) {
  if (strings == null) {
    return "";
  }
  String prefix = strings[0];
  for (int i = 1; i < strings.length; i++) {
    while (strings[i].indexOf(prefix) != 0) {
      prefix = prefix.substring(0,prefix.length()-1);
      if (prefix == "") return prefix;
    }
  }
  return prefix;
}

/**
  * Implement a data structure with O(1) insert, remove, and getRandom methods (no dups)
	*/

class RandomSet {

}

/**
  * Given two strings str1 and str2. If you can perform insert, remove, and replace
  * operations on str1, find the minimum number of edits (operations) required to
  * convert str1 into str2
	*/

// RECURSIVE SOLUTION
int editDistance(String str1, String str2) {
    return editDistanceHelper(str1, str2, str1.length(), str2.length());
}

int editDistanceHelper(String str1, String str2, int it1, int it2) {
	if (it1 == 0) return it2;
	if (it2 == 0) return it1;
	if (str1.charAt(it1) == str2.charAt(it2)) {
		return editDistanceHelper(str1, str2, it1 - 1, it2 - 1);
	} else {
		return 1 + Math.min(editDistanceHelper(str1, str2, it1 - 1, it2), // removal
							          Math.min(editDistanceHelper(str1, str2, it1, it2 - 1), // insertion
							                   editDistanceHelper(str1, str2, it1 - 1, it2 - 1)); // replace
	}
}

// DP SOLUTION
int editDistance(String str1, String str2) {
	int len1 = str1.length();
	int len2 = str2.length();
	int[][] dp = new dp[len1+1][len2+1];
	for (int i = 0; i <= len1; i++) {
		for (int j = 0; j <= len2; j++) {
			// str1 is empty, you have to insert all the characters in str2
			if (i == 0) dp[i][j] = j;
			// str2 is empty, you have to remove all the characters in str2
			else if (j == 0) dp[i][j] = i;
			// str1 and str2 characters equal
			else if (str1.charAt(i-1) == str2.charAt(j-1)) {
				dp[i][j] = dp[i-1][j-1];
			} else {
				dp[i][j] = 1 + Math.min(dp[i-1][j], // removal
																Math.min(dp[i][j-1], // insertion
																				 dp[i-1][j-1])); // replace
			}
		}
	}
	return dp[len1][len2];
}

/**
  * A k-palindrome is a string which transforms into a palindrome on removing at
	* most k characters. Given a string and an integer k, print “YES” if S is a
	* k-palindrome, else print “NO”
	*/

// RECURSIVE SOLUTION
void isKPalindrome(String str, int k) {
	boolean isK = isKPalindromeHelper(str, k);
	if (isK) {
		System.out.println("YES");
	} else {
		System.out.println("NO");
	}
}

boolean isKPalindromeHelper(String str, int k) {
	if (k < 0) return false;
	if (str.length() <= 1) return true;
	char first = str.charAt(0);
	char last = str.charAt(str.length()-1);
	if (first == last) {
		return isKPalindromeHelper(str.substring(1,str.length()-1),k-1);
	}
	return isKPalindromeHelper(str.substring(1,str.length()), k-1) ||
				 isKPalindromeHelper(str.substring(0,str.length()-1), k - 1);
}

// DP SOLUTION
void isKPalindrome(String str, int k) {
	String rev = new StringBuilder(str).reverse().toString();
	int numChanges = isKPalindromeHelper(str, rev);
	if (numChanges <= k*2) {
		System.out.println("YES");
	} else {
		System.out.println("NO");
	}
}

int isKPalindromeHelper(String str1, String str2) {
	int len = str1.length();
	int[][] dp = new int[len+1][len+1];
	for (int i = 0; i <= len; i++) {
		for (int j = 0; j <= len; j++) {
			if (i == 0) dp[i][j] = j;
			if (j == 0) dp[i][j] = i;
			if (str1.charAt(i-1) == str2.charAt(j-1)) {
				dp[i][j] = dp[i-1][j-1];
			} else {
				dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[len][len];
}

/**
	* Implement a hashtable
	*/

class HashTable {
	List<String>[] table;
	int size;

	public HashTable(int size) {
		this.size = size;
		table = new List<String>[size];
	}

	public void insert(String key, String value) {

	}

	public void delete(String key) {

	}
}

/**
  * Given a matrix of m x n elements (m rows, n columns), return all elements
	* of the matrix in spiral order
	*/

void printSpiralMatrix(int[][] matrix) {
	if (matrix.length == 0) return;
	int m = matrix.length;
	int n = matrix[0].length;
	int top = 0;
	int bottom = m - 1;
	int left =  0;
	int right = n - 1;
	while (m > 0 && n > 0) {
		for (int i = left; i <= right; i++) {
			System.out.println(matrix[top][i]);
		}
		top++;
		for (int i = top; i <= bottom; i++) {
			System.out.println(matrix[i][right]);
		}
		right--;
		if (bottom < top) break;
		for (int i = right; i >= left; i--) {
			System.out.println(matrix[bottom][i]);
		}
		bottom--;
		if (right < left) break;
		for (int i = bottom; i >= top; i--) {
			System.out.println(matrix[i][left]);
		}
		m -= 2;
		n -= 2;
	}
}

/**
	* Implement quicksort
	*/

void implementQuicksort(int[] arr) {

}

/**
  * If a = 1, b = 2, …, z = 26. Given a number string, count all possible alphabet
  * codes that number string can generate.
  *
  * Input: “1123”
  * Output: 5 (“aabc”, “kbc”, “alc”, “aaw”, “kw”)
  */

// RECURSIVE SOLUTION

int countDecodeString(String code) {
  return countDecodeStringHelper(code, code.length());
}

int countDecodeStringHelper(String code, int n) {
  if (n == 0 || n == 1) return 1;
  int count = 0;
  if (code.charAt(n-1) > '0') {
    count = countDecodeStringHelper(code, n-1);
  }
  if ((code.charAt(n-2) == '1' || code.charAt(n-2) == '2') && code.charAt(n-1) < '7') {
    count += countDecodeStringHelper(code, n-2);
  }
  return count;
}

// DP SOLUTION

int countDecodeString(String code) {
  if (code.length() == 1) return 1;
  int[] dp = new int[code.length()+1];
  dp[0] = 1;
  dp[1] = 1;
  for (int i = 2; i <= code.length(); i++) {

    // If the last digit is not 0, then last digit must add to
    // the number of words
    if (code.charAt(i-1) > '0') {
      dp[i] = dp[i-1];
    }

    // If second last digit is smaller than 2 and last digit is
    // smaller than 7, then last two digits form a valid character
    if ((code.charAt(i-2) == '1' || code.charAt(i-2) == '2') && code.charAt(i-1) < '7') {
      dp[i] += dp[i-2];
    }
  }
  return dp[code.length()];
}

/**
  * If a = 1, b = 2, …, z = 26. Given a number string, find all possible alphabet
	* codes that number string can generate.
	*
	* Input: “1123”
	* Output: [“aabc”, “kbc”, “alc”, “aaw”, “kw”]
	*/

// RECURSIVE SOLUTION
Set<String> decodeString(String code) {
	return decodeStringHelper("", code);
}

Set<String> decodeStringHelper(String decoded, String code) {
	Set<String> set = new HashSet<>();
	if (code.length() == 0) {
		set.add(decoded);
		return set;
	}
	if (code.charAt(0) == '0') return set;
	set.addAll(decodeStringHelper(decoded + (char) (code.charAt(0) - '1' + 'a'),
																code.substring(1)));
	if (code.length() >= 2) {
		if (code.charAt(0) == '1') {
			set.addAll(decodeStringHelper(decoded + (char)(10 + code.charAt(1) - '1' + 'a'),
																		code.substring(2)));
		}
		else if (code.charAt(0) == '2' && code.charAt(1) <= '6') {
			set.addAll(decodeStringHelper(decoded + (char)(20 + code.charAt(1) - '1' + 'a'),
																		code.substring(2)));
		}
	}
	return set;
}

/**
	* Given a string s and a dictionary of words dict, determine if s can be segmented
	* into a space-separated sequence of one or more dictionary words. Commonly
	* known as the word break problem.
	*/

// RECURSIVE SOLUTION
boolean canBeSegmented(String str, Set<String> dict) {
	int len = str.length();
	if (len == 0) return true;
	for (int i = 1; i < len; i++) {
		if (dict.contains(str.substring(0,i)) && canBeSegemented(str.substring(i,len), dict)) {
			return true;
		}
	}
	return false;
}

// DP SOLUTION
boolean canBeSegmented(String str, Set<String> dict) {
	int len = str.length();
	boolean[] dp = new boolean[len+1];
	dp[0] = true;
	for (int i = 0; i < len; i++) {
		if (dp[i] == true) {
			for (int j = i+1; j < len; j++) {
				String substr = str.substring(i,j);
				if (dict.contains(substr)) {
					dp[j] = dp[i];
				}
			}
		}
	}
	return dp[len];
}

// Now return the words in the dictionary used
List<String> wordsInDictionaryUsed(String str, Set<String> dict) {
	List<String> wordsUsed = new ArrayList<String>();
	int len = str.length();
	boolean[] dp = new boolean[len + 1];
	dp[0] = true;
	for (int i = 0; i < len; i++) {
		if (dp[i] == true) {
			for (int j = i+1; j < len; j++) {
				String substr = str.substring(i,j);
				if (dict.contains(substr)) {
					dp[j] = dp[i];
					wordsUsed.add(substr)
				}
			}
		}
	}
	return wordsUsed;
}

// Now return the chosen order of words possible
// INPUT: "bedbathsandbeyond", {"bed", "bath", "sand", "and", "beyond", "baths"}
// OUTPUT: {"bed baths and beyond", "bed bath sand beyond"}
// http://www.geeksforgeeks.org/word-break-problem-using-backtracking/

List<String> sentencesFromDictionary(String str, Set<String> dict) {

}

/**
	* Given an array of non-negative integers, and a value sum, determine if there
	* is a continguous subarray that adds up to the given sum
	*/

boolean isSubarraySum(int[] arr, int sum) {

}

// Determine if there is a contiguous subarray that adds up to a multiple of
// of the sum, n*sum, such that n is also an integer

boolean isSubarraySum(int[] arr, int sum) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(0, -1);
	int currSum = 0;
	for (int i = 0; i < arr.length; i++) {
		currSum += arr[i];
		if (sum != 0) currSum %= sum;
		if (map.containsKey(currSum) && i - map.get(currSum) > 1) {
			return true;
		}
		map.put(currSum, i);
	}
	return false;
}

/**
	* Given an array of integers, and a value sum, determine if there is a
	* continguous subarray that adds up to the given sum
	*/

boolean isSubarraySum(int[] arr, int sum) {
	Set<Integer> set = new HashSet<Integer>();
	int currSum = 0;
	for (int num : arr) {
		currSum += num;
		if (num == sum || currSum == sum) return true;
		if (set.contains(currSum - sum)) return true;
		set.add(currSum);
	}
	return false;
}

// Return the shortest length of possible subarrays

int returnShortestLengthOfSubarraySum(int[] arr, int sum) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int currSum = 0;
	int shortest = Integer.MAX_VALUE;
	for (int i = 0; i < arr.length; i++) {
		currSum += arr[i];
		if (arr[i] == sum) shortest = 1;
		if (currSum == sum) shortest = Math.min(i + 1, shortest);
		if (map.containsKey(currSum - sum)) {
			shortest = Math.min(i - map.get(currSum - sum), shortest);
		}
		map.put(currSum, i);
	}
	return shortest == Integer.MAX_VALUE ? 0 : shortest;
}

// Return the number of subarrays that add up to sum

int returnNumSubarraySum(int[] arr, int sum) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(0, 1);
	int numSubarrays = 0;
	int currSum = 0;
	for (int i = 0; i < arr.length; i++) {
		currSum += arr[i];
		if (map.containsKey(currSum - sum)) {
			numSubarrays += map.get(currSum - sum);
		}
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);
	}
	return numSubarrays;
}

/**
	* Given an array of non-negative integers, and a value sum, determine if there
	* is a subset of the given set with sum equal to given sum.
	*/

// RECURSIVE SOLUTION
boolean isSubsetSum(int[] arr, int sum) {
	return isSubsetSumHelper(arr, arr.length, sum);
}

boolean isSubsetSumHelper(int set[], int n, int sum) {
	// Base Cases
	if (sum == 0)
		return true;
	if (n == 0 && sum != 0)
		return false;

	// If last element is greater than sum, then ignore it
	if (set[n-1] > sum)
		return isSubsetSum(set, n-1, sum);

	/* else, check if sum can be obtained by any of the following
	(a) including the last element
	(b) excluding the last element   */
	return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum - set[n-1]);
}

// DP SOLUTION
boolean isSubsetSum(int[] arr, int sum) {
	int len = arr.length;
	boolean[][] dp = new boolean[sum+1][len];
	// if sum is 0 and its true
	for (int i = 0; i <= len; i++) {
		dp[0][i] = true;
	}
	// if sum isn't 0 and set is empty
	for (int i = 1; i <= sum; i++) {
		dp[sum][0] == false;
	}
	for (int i = 1; i <= sum; i++) {
		for (int j = 1; j <= len; j++) {
			dp[i][j] = dp[i][j-1];
			if (i >= set[j-1]) {
				dp[i][j] = dp[i][j] || subset[i - arr[j-1]][j-1];
			}
		}
	}
	return dp[sum][len];
}

/**
	* Given a set of non-negative numbers, and a value sum, return all valid
	* subsets that add up to given sum
	*/

List<List<Integer>> returnSubsetSum(List<Integer> set, int sum) {

}

/**
  * Find the length of longest unique substring
	*/

int lengthOfLongestSubstring(String s) {
	boolean[] exist = new boolean[256];
	int i = 0, maxLen = 0;
	for(int j = 0; j < s.length(); j++) {
		while(exist[s.charAt(j)]) {
			exist[s.charAt(i)] = false;
			i++;
		}
		exist[s.charAt(j)] = true;
		maxLen = Math.max(maxLen, j - i + 1);
	}
	return maxLen;
}

/**
	* Find the longest increasing subarray length
	*/

public int longestIncreasingSubarray(int[] arr) {
	int start = 0;
	int end = 1;
	int maxLen = 1;
	while (end < arr.length) {
		if (arr[end] > arr[end-1]) {
			maxLen = Math.max(maxLen, end - start + 1);
		} else {
			start = end;
		}
		end++;
	}
	return maxLen;
}

/**
	* Find the longest increasing subsequence
	*/

public int longestIncreasingSubsequence(int[] arr) {
	if (arr.length == 1) return 1;
	int len = arr.length;
	int[] dp = new int[len];
	for (int i = 0; i < len; i++) {
		dp[i] = 1;
	}
	for (int end = 1; end < len; end++) {
		for (int start = 0; start < end; start++) {
			if (arr[end] > arr[start]) {
				dp[end] = Math.max(dp[end], dp[start]+1);
			}
		}
	}
	int longest = 0;
	for (int i = 0; i < len; i++) {
		longest = Math.max(longest, dp[i]);
	}
	return longest;
}

/**
	* Given an array of integers and integer k, find the number of pairs of integers
	* in the array whose sum is equal to k
	*/

static int getPairsCount(int n, int sum) {
	HashMap<Integer, Integer> hm = new HashMap<>();

	// Store counts of all elements in map hm
	for (int i=0; i<n; i++) {
		// initializing value to 0, if key not found
		if(!hm.containsKey(arr[i])) {
			hm.put(arr[i],0);
		}
		hm.put(arr[i], hm.get(arr[i])+1);
	}
	int twice_count = 0;

	// iterate through each element and increment the
	// count (Notice that every pair is counted twice)
	for (int i=0; i<n; i++) {
		if(hm.get(sum-arr[i]) != null)
		twice_count += hm.get(sum-arr[i]);
		// if (arr[i], arr[i]) pair satisfies the condition,
		// then we need to ensure that the count is
		// decreased by one such that the (arr[i], arr[i])
		// pair is not considered
		if (sum - arr[i] == arr[i]) twice_count--;
	}
	// return the half of twice_count
	return twice_count/2;
}

/**
	* Given a number of size <= 999 billion, return its String representation
	* (for 123, return "One Hundred Twenty Three," not "123”)
	*/

String belowOneThousandToString(int num) {
	String result;
	String[] tens = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty",
									 "seventy", "eight", "ninety"};
	String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven",
									 "eight", "nine", "ten", "eleven", "twelve", "thirteen",
								 	 "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
								   "nineteen"}
	if (num % 100 < 20) {
		result = ones[num%100];
		num /= 100;
	} else {
		result = ones[num%10];
		num /= 10;
		result = tens[num%10] + result;
		num /= 10;
	}
	if (num == 0) return result;
	return ones[num] + " hundred" + result;
}

String convertNumberToString(int num) {
	String[] special = {"", "thousand", "million", "billion"};

	String prefix = "";
	if (num < 0) {
		num *= -1;
		prefix = "negative";
	}

	String result = "";
	int place = 0;

	do {
		int n = num % 1000;
		if (n != 0) {
			String str = belowOneThousandToString(n);
			result = str + special[place] + result;
		}
		place++;
		num /= 1000;
	} while(num > 0)

	return (prefix + result).trim();
}

/**
	* Create a copy of a linked list
	*/

Node deepCopyLinkedList(Node head) {
	if (head == null) return null;
	Node copyHead = new Node(head.val);
	Node it = copyHead;
	while (head.next != null) {
		head = head.next;
		it.next = new Node(head.val);
		it = it.next;
	}
	return copyHead;
}

/**
	* Create all possible subsets given a set (powerset)
	*/

List<Integer>[] returnPowerSet(int[] set) { 1 << 1 = 2; 1 << 2 = 4
	int powSize = 1 << set.length;
	List<Integer>[] powSet = new List<>()[powSize];
	for (int i = 0; i < powSize; i++) {
		powSet[i] = new ArrayList<>();
		for (int j = 0; j < set.length; j++) {
			if (i & (1 << j)) {
				powSet[i].add(set[j]);
			}
		}
	}
	return powSet;
}

/**
	* Create a copy of a linked list with a next pointer and arbitrary second
	* pointer that can point to any node in that linked list
	*
	* http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	*/

Node copyWeirdLinkedList(Node head) {
	if (head == null || head.next == null) return head;
	Node copyHead;
	Node it = head;
	while (it != null) {
		Node itNext = it.next;
		it.next = new Node(it.val);
		it.next.next = itNext;
		it = itNext;
	}
	copyHead = head.next;
	Node copyIt = copyHead;
	it = head;
	while (it != null) {
		copyIt.arbNext = it.arbNext.next;
		copyIt = copy.next.next;
		it = it.next.next;
	}
	copyIt = copyHead;
	it = head;
	while (it != null) {
		it.next = it.next.next;
		it = it.next;
		copyIt.next = copyIt.next.next;
		copyIt = copytIt.next;
	}
	return copyHead;
}

/**
	* Given a decimal number, find the number of 1s in its binary representation
	*/

int countOnes(int num) {
	int count = 0;
	while (num > 0) {
		count += num & 1;
		num >>= 1;
	}
	return count
}

/**
	* Return the distance of the closest leaf given a key and a binary tree
	*/

int closestLeaf(Node root) {
	if (root = null) {
		return Integer.MAX_VALUE;
	}
	else if (root.left == null && root.right == null) {
		return 1;
	}
	return 1 + Math.min(closestLeaf(root.left), closestLeaf(root.right));
}

int closestLeafRecurse(Node root, int k, Node[] ancestors, int index) {
	if (root = null) {
		return Integer.MAX_VALUE;
	}
	if (root.val = k) {
		int closestDist = closestLeaf(root);
		for (int i = index - 1; i >= 0; i--) {
			closestDist = Math.min(closestDist, closestLeaf(ancestors[i]))
		}
		return closestDist;
	}
	ancestors[index] = root;
	return Math.min(closestLeafRecurse(root.left, k, ancestors, index + 1),
									closestLeafRecurse(root.right, k, ancestors, index + 1));
}

int closestLeaf(Node root, int k) {
	Node[] ancestors = new Node[100]; // height of tree maxed at 100
	return closestLeafRecurse(root, k, ancestors, 0);
}

/**
  * Convert a binary tree into a linked list
  */

TreeNode prev = null;

void flatten(TreeNode root) {
  if (root == null)
    return;
  flatten(root.right);
  flatten(root.left);
  root.right = prev;
  root.left = null;
  prev = root;
}

/**
	* Given a binary tree, create a doubly linked list with data in the same order
	* as an In-Order Traversal through the tree
	*/

Node prev = null;
Node head = null;

// A simple recursive function to convert a given Binary tree
// to Doubly Linked List
// root --> Root of Binary Tree
Node BinaryTree2DoubleLinkedList(Node root) {
    // Base case
    if (root == null)
        return;

    Node head = null;
    // Recursively convert left subtree
    BinaryTree2DoubleLinkedList(root.left);
    // Now convert this node
    if (prev == null)
        head = root;
    else {
        root.left = prev;
        prev.right = root;
    }
    prev = root;
    // Finally convert right subtree
    BinaryTree2DoubleLinkedList(root.right);
}

/**
  * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
  */

List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
  int index = Collections.binarySearch(arr, x);
  if(index < 0) index = -(index + 1);
  int i = index - 1, j = index;
  while(k-- > 0){
    if (i < 0 || (j<arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x) ))j++;
    else i--;
  }
  return arr.subList(i+1, j);
}

/**
	* Convert Roman numeral string to integer representation
	*/

int romanNumeralToInteger(String romanNum) {
  int res = 0;
  for (int i = romanNum.length() - 1; i >= 0; i--) {
    char c = romanNum.charAt(i);
    switch (c) {
    case 'I':
      res += (res >= 5 ? -1 : 1);
      break;
    case 'V':
      res += 5;
      break;
    case 'X':
      res += 10 * (res >= 50 ? -1 : 1);
      break;
    case 'L':
      res += 50;
      break;
    case 'C':
      res += 100 * (res >= 500 ? -1 : 1);
      break;
    case 'D':
      res += 500;
      break;
    case 'M':
      res += 1000;
      break;
    }
  }
  return res;
}

/**
	* Convert integer to Roman numeral representation
	*/

String integerToRomanNum(int num) {
  String M[] = {"", "M", "MM", "MMM"};
  String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
  return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}

/**
	* Given list of (x,y) coordinates, an origin (o.x,o.y), and a number k find
	* the k-th closest coordinate to the origin
	*/



/**
	* Given an array of distinct elements, find triplets in array whose sum is zero
	*
	* THREE SUM
	*/

// SORTING METHOD
List<List<Integer>> tripletsSumToZero(int[] arr) {
  int mid, end;
  Arrays.sort(arr);
  List<List<Integer>> triplets = new ArrayList<>();
  for (int start = 0; start < arr.length-2; start++) {
    mid = start + 1;
    end = arr.length - 1;
    while (mid < end) {
      int sum = arr[start] + arr[mid] + arr[end];
      if (sum < 0) {
        mid++;
      } else if (sum > 0) {
        end--;
      } else {
        mid++;
        end--;
        triplets.add(new ArrayList<Integer>(Arrays.asList({arr[start],arr[mid],arr[end]})));
      }
    }
  }
  return triplets;
}

// HASHING METHOD


/**
	* Find the diameter of a binary tree. The diameter of a tree (sometimes called
	* the width) is the number of nodes on the longest path between two leaves in
	* the tree.
	*
	* Diameter of a tree T is the largest of the following quantities:
	* - The diameter of T's left subtree
	* - The diameter of T's right subtree
	* - The heights of the left and right subtree (path goes through root)
	*/

int returnDiameter(Node root) {
	if (root == null) return 0;
	int lh = height(root.left);
	int rh = height(root.right);
	int ld = returnDiameter(root.left);
	int rd = returnDiameter(root.right);
	return Math.max(lh + rh, Math.max(ld, rd));
}

int height(Node root) {
	if (root == null) return 0;
	return 1 + Math.max(height(root.left), height(root.right));
}

// ALTERNATE SOLUTION

class IntContainer {
  int val;

  public IntContainer(int val) {
    this.val = val;
  }
}

int returnDiameter(Node root) {
  IntContainer diameter = new IntContainer(0);
  returnDiameterHelper(root, diameter);
  return diameter.val;
}

int returnDiameterHelper(Node root, IntContainer diameter) {
  if (root == null) return 0;
  int lh = returnDiameterHelper(root.left, diameter);
  int rh = returnDiameterHelper(root.right, diameter);
  diameter.val = Math.max(diameter.val, lh + rh);
  return 1 + Math.max(lh, rh);
}

/**
	* Reverse a number
	* 1234 -> 4321
	*/

int reverseNum(int num) {
	int reversed = 0;
	while (num > 0) {
		reversed = reversed * 10;
		reversed += num % 10;
		num /= 10;
	}
	return reversed;
}

/**
 	* Interval scheduling/activity selection
	*/

List<int[]>

/**
	* Change making (DP or Greedy)
	*/

long countWays(int S[], int m, int n) {
  //Time complexity of this function: O(mn)
  //Space Complexity of this function: O(n)

  // table[i] will be storing the number of solutions
  // for value i. We need n+1 rows as the table is
  // constructed in bottom up manner using the base
  // case (n = 0)
  long[] table = new long[n+1];

  // Initialize all table values as 0
  Arrays.fill(table, 0);   //O(n)

  // Base case (If given value is 0)
  table[0] = 1;

  // Pick all coins one by one and update the table[]
  // values after the index greater than or equal to
  // the value of the picked coin
  for (int i=0; i<m; i++) {
    for (int j=S[i]; j<=n; j++) {
      table[j] += table[j-S[i]];
    }
  }

  return table[n];
}

/**
	* Given an array of integers and the +, -, *, and / operations with any two
	* numbers, find the max value possible
	*/

int getMaxNumber(int[] nums) {
	return getMaxNumberHelper(nums, nums[0], 0);
}

int getMaxNumberHelper(int[] nums, int cur, int idx) {
	if (idx = nums.length) {
		return cur;
	}
	max = Math.max(cur + getMaxNumberHelper(nums, nums[idx], idx+1),
								 Math.max(cur - getMaxNumberHelper(nums, nums[idx], idx+1),
								 					getMaxNumberHelper(nums, cur*nums[idx], idx+1)));
	if (nums[idx] != 0) {
		max = Math.max(max, getMaxNumberHelper(nums, cur/nums[idx], idx+1));
	}
	return max;
}

/**
	* Find the median of an unsorted integer array in average linear times
	*/



/**
	* Given an n-ary tree, its deep copy, and a random node in the original tree,
	* find the corresponding node in the deep copy
	*/

TreeNode returnCorrespondingCopyNode(TreeNode root, TreeNode copyRoot, TreeNode randNode) {
	if (rootNode == randNode) {
		return copyRoot;
	}
	TreeNode[] children = root.children();
	TreeNode[] copyChildren = copyRoot.children();
	TreeNode[] result = new TreeNode[children.length];
	for (int i = 0; i < children.length; i++) {
		result[i] = returnCorrespondingCopyNode(children[i], copyRoot[i], randNode);
	}
	for (TreeNode node : result) {
		if (node != null) return node;
	}
	return null;
}

/**
	* Given an array of integers and a target number, determine if an arithmetic
	* expression using these integers can be evaluated to the target number.
	* You are allowed to use the +, -, * and / operations.
	*/

// SOLUTION COULD BE FAULTY

boolean isReachable(ArrayList<Integer> list, int target) {
  if (list == null || list.size() == 0)
    return false;

  int i = 0;
  int j = list.size() - 1;

  ArrayList<Integer> results = getResults(list, i, j, target);

  for (int num : results) {
    if (num == target) {
      return true;
    }
  }

  return false;
}

ArrayList<Integer> getResults(ArrayList<Integer> list,int left, int right, int target) {
  ArrayList<Integer> result = new ArrayList<Integer>();

  if (left > right) {
    return result;
  } else if (left == right) {
    result.add(list.get(left));
    return result;
  }

  for (int i = left; i < right; i++) {

    ArrayList<Integer> result1 = getResults(list, left, i, target);
    ArrayList<Integer> result2 = getResults(list, i + 1, right, target);

    for (int x : result1) {
      for (int y : result2) {
        result.add(x + y);
        result.add(x - y);
        result.add(x * y);
        if (y != 0)
          result.add(x / y);
      }
    }
  }

  return result;
}

/**
  * We are given desired array target[] containing n elements. Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.
  */



/**
	* Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
	*/



/**
	* Find the sum of two infinitely large integers represented as strings
	*/

String addStrings(String num1, String num2) {
	int len1 = num1.length();
	int len2 = num2.length();
	String finalSum = "";
	int carry = 0;
	for (int i = len1-1, j = len2-1; i >= -1 || j >= -1; i--, j--) {
		if (i < 0 && j < 0) {
			if (carry > 0) {
				finalSum = String.valueOf(carry) + finalSum;
			}
			break;
		}
		int sum = 0;
		if (j < 0) {
			sum = carry + Character.getNumericValue(num1.charAt(i));
		} else if (i < 0) {
			sum = carry + Character.getNumericValue(num2.charAt(j));
		} else {
			sum = carry + Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j));
		}
		if (sum > 9) {
			carry = sum/10;
			sum %= 10;
		} else {
			carry = 0;
		}
		finalSum = String.valueOf(sum) + finalSum;
	}
	return finalSum;
}

/**
	* Find the product of two large integers represented as strings
	*/

public String multiply(String num1, String num2) {
  String a = new StringBuilder(num1).reverse().toString();
  String b = new StringBuilder(num2).reverse().toString();

  int[] sums = new int[a.length() + b.length()];
  for (int i = 0; i < a.length(); i++) {
    for (int j = 0; j < b.length(); j++) {
      sums[i+j] += (a.charAt(i) - '0')*(b.charAt(j) - '0');
    }
  }

  String product = "";
  for (int i = 0; i < sums.length; i++) {
    int mod = sums[i] % 10;
    int carry = sums[i]/10;
    if (i + 1 < sums.length) {
      sums[i+1] += carry;
    }
    product = String.valueOf(mod) + product;
  }

  int prependedZeroes = 0;
  while (prependedZeroes < product.length() - 1 && product.charAt(prependedZeroes) == '0') {
    prependedZeroes++;
  }
  product = product.substring(prependedZeroes);

  return product;
}

/**
	* Merge k sorted linked lists
	*/

public ListNode mergeKLists(ListNode[] lists) {
	return partition(lists, 0, lists.length-1);
}

ListNode partition(ListNode[] lists, int beg, int end) {
	if (beg == end) return lists[beg];
	if (beg < end) {
		int mid = (beg + end)/2;
		ListNode l1 = partition(lists, beg, mid);
		ListNode l2 = partition(lists, mid+1, end);
		return mergeTwoSortedLinkedList(l1, l2);
	} else { return null; }
}

ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
	if (l1 == null) return l2;
	if (l2 == null) return l1;
	ListNode merged = null;
	if (l1.val <= l2.val) {
		merged = l1;
		merged.next = mergeTwoSortedLinkedList(l1.next, l2);
	} else {
		merged = l2;
		merged.next = mergeTwoSortedLinkedList(l1, l2.next);
	}
	return merged;
}

/**
	* Find the maximum difference between two elements in an array such that the
	* larger number appears after the smaller number in the array
	*/

int maxDiff(int[] arr) {
	int min = Integer.MAX_VALUE;
	int profit = 0;
	for (int num : arr) {
		min = Math.min(num, min);
		profit = Math.max(profit, num - min);
	}
	return profit;
}

/**
	* Find the connected components in a graph
	*/



/**
	* Given a mapping of char representing a number to char array and an input
	* string S. Find all possible strings that can be generated. Every character
	* in the input string should be replaced by a character in its corresponding
	* mapped array of characters.
	*
	* Input: {'1' -> ['a','b'], '2' -> ['c']}, "12"
	* Output: ["ac", "bc"]
	*/

List<String> printLetterCombinations(String code, Map<Character, char[]> encoding) {
	StringBuilder tmp = new StringBuilder();
	List<String> fin = new ArrayList<>();
	printLetterCombinationsHelper(tmp, code, 0, encoding, fin);
	return fin;
}

void printLetterCombinationsHelper(StringBuilder tmp, String code, int idx, Map<Character, char[]> encoding, List<String> fin) {
	if (idx == code.length()) {
		fin.add(tmp.toString());
		return;
	}
	char key = code.charAt(idx);
	char[] chars = encoding.get(key);
	for (char c : chars) {
		tmp.append(c);
		printLetterCombinationsHelper(tmp, code, idx+1, encoding, fin);
		tmp.deleteCharAt(tmp.size()-1);
	}
}

/**
	* Given a dictionary and two words. Find the shortest path between two words
	* by modifying only one character at a time and using only words in the
	* dictionary.
	*/

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	LinkedList<String> queue = new LinkedList<>();
	Map<String, Integer> count = new HashMap<>();

	count.put(beginWord, 1);
	queue.add(beginWord);
	wordList.remove(beginWord);

	while (!queue.isEmpty()) {
		String word = queue.remove();

		if (word.equals(endWord)) {
			return count.get(endWord);
		}

		StringBuilder wordBuilder = new StringBuilder(word);
		for (int i = 0 ; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				char origChar = wordBuilder.charAt(i);

				wordBuilder.setCharAt(i,c);
				String newWord = wordBuilder.toString();

				if (wordList.contains(newWord)) {
					queue.add(newWord);
					count.put(newWord, count.get(word) + 1);
					wordList.remove(newWord);
				}

				wordBuilder.setCharAt(i,origChar);
			}
		}
	}
	return 0;
}

/**
	* Print binary tree in vertical order
	*/

void printVerticalOrder(Node head) {
	TreeMap<Integer, List<Integer>> map = new TreeMap<>();
	printOrderHelper(head, 0, map);
	Set<Integer> set = map.keySet();
	for (int key : set) {
		List<Integer> vert = map.get(key);
		for (int val : vert) {
			System.out.print(val);
		}
		System.out.println("");
	}
}

void  printVerticalOrderHelper(Node n, int offset, TreeMap<Integer, List<Integer>> map) {
	if (n == null)
	return;
	if (map.containsKey(offset)) {
		map.get(offset).add(n.val);
	} else {
		map.put(offset, new ArrayList<Integer>());
		map.get(offset).add(n.val);
	}
	printVerticalOrderHelper(n.left, offset-1, map);
	printVerticalOrderHelper(n.right, offset+1, map);
}

/**
	* Implement merge sort (recursive and iterative)
	*/



/**
	* Print out diagonals in a matrix
	*/



/**
	* Traverse through a b-tree and print elements
	*/

class BNode {
	BNode[] children;
	int[] data;
	int degree;
	boolean isLeaf;
}

void printAll(BNode root) {
	printAllHelper(root);
}

void printAllHelper(BNode n) {
	if (n == NULL)
		return;
	if (n.isLeaf) {
		for (int num : n.data) {
			System.out.println(num);
		}
	}
	else {
		for (int i = 0; i < n.degree; i++) {
			if (n.children[i] != null) {
				printAllHelper(n.children[i]);
			}
		}
	}
}

/**
	* Given a list of persons and a function knows(i, j), which returns true if
	* person i knows person j. Find a celebrity person such that this person doesn't
	* know anybody else but everybody else knows him.
	*
	* (Assume using 2-D array matrix to track relationships)
	*/

int findCelebrity(int numPeople) {
	int first = 0;
	int last = numPeople - 1;
	while (first < last) {
		if (knows(first,last)) { // if first knows last, first can't be a celebrity
			start++;
		} else { // if first doesn't know last, last can't be a celebrity
			last--;
		}
	}
	for (int i = 0; i < numPeople; i++) {
		// start isn't a celebrity if anyone doesn't them
		if (i != start && !knows(i,start)) return -1;
		// start isn't a celebrity if they know anyone
		if (i != start && knows(start,i)) return -1;
	}
	return start;
}

/**
	* Determine whether parenthesis are valid
	*/

boolean validParenthesis(String str) {
	int stack = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i) == '(') stack++;
		if (str.charAt(i) == ')') stack--;
		if (stack < 0) return false;
	}
	return stack == 0;
}

/**
	* Removed unbalanced parenthesis
	*/

List<String> removeInvalidParenthesis(String str) {
	List<String> fin = new ArrayList<>();
	removeInvalidParenthesisHelper(str, fin, 0, 0, new char[]{'(',')'});
	return fin;
}

void removeInvalidParenthesisHelper(String str, List<String> fin, int start, int removed, char[] par) {
	int stack = 0;
	for (int i = start; i < str.length(); i++) {
		if (str.charAt(i) == par[0]) stack++;
		if (str.charAt(i) == par[1]) stack--;
		if (stack >= 0) continue;
		for (int j = removed; j <= i; j++) {
			if (str.charAt(j) == par[1] && (j == removed || str.charAt(j-1) != par[1])) {
				removeInvalidParenthesisHelper(str.substring(0,j)+str.substring(j+1,str.length()), fin, i, j, par);
			}
		}
		return;
	}
	String reversed = new StringBuilder(str).reverse().toString();
	if (par[0] == '(') {
		removeInvalidParenthesisHelper(reversed, fin, 0, 0, new char[]{')','('});
	} else {
		fin.add(reversed);
	}
}

/**
	* Solve towers of hanoi
	*/


/**
	* Validate whether a sudoku board is correctly solved
	*/



/**
	* Given an array for which the i-th element is the price of a given stock on
	* day i. Design an algorithm to find the maximum profit if you may complete
	* as many transactions as you like.
	*/

int maxProfitStock(int[] stockPrices) {
	int profit = 0;
	for (int i = 0; i < stockPrices.length - 1; i++) {
		if (stockPrices[i+1] > stockPrices[i]) {
			profit += stockPrices[i+1] - stockPrices[i];
		}
	}
	return profit;
}

/**
	* Given an array for which the i-th element is the price of a given stock on
	* day i. Design an algorithm to find the maximum profit if you may complete
	* only two transactions over that time period.
	*/

int maxProfit(int[] prices) {
	int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
	int release1 = 0, release2 = 0;
	for(int i:prices){                              // Assume we only have 0 money at first
		release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
		hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
		release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
		hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
	}
	return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
}

/**
	* Jacob and Peter have their favorite number X and Y. We have given an array
	* with positive integer number and we need to find the long prefix index which
	* contain equal number of X and Y. Return -1 if there is no prefix with equal
	* number of X and Y.
	*
	* Input: [7,42,5,6,42,8,7,5,3,6,7], X = 7, Y = 42
	* Output: 9
	*/

int lengthOfLongestPrefixWithFaveNumbers(int arr, int x, int y) {
	int numX = 0;
	int numY = 0;
	int len = 0, longestLen = 0;
	for (int num : arr) {
		len++;
		if (num == x) {
			numX++;
			if (numX == numY) longestLen = len;
		}
		if (num == y) {
			numY++;
			if (numX == numY) longestLen = len;
		}
	}
	return longestLen;
}

/**
	* Perform level order traversal on a n-ary tree
	*/

void levelOrderTraversal(Node root) {
  if (root == null) return;
  List<Node> curLevel = new ArrayList<>();
  curLevel.add(root);
  while (curLevel.size() > 0) {
    for (Node n : curLevel) {
      if (n != null) System.out.print(n.val);
    }
    System.out.println("");
    List<Node> parentLevel = curLevel;
    curLevel = new ArrayList<>();
    for (Node parent : parentLevel) {
      if (parent.children != null) {
        for (Node child : parent.children) {
          curLevel.add(child);
        }
      }
    }
  }
}

/**
	* You are given an array/sequence of colors, find pairs of colors adjacent to
	* one another (same color) and remove it. After the removal, if there are
	* further pairs of the same color then remove them as well. Find the maximum
	* number of pairs given the array/sequence of colors.
	*/

int numPairs(String seq) {
  Stack<Character> s = new Stack<>();
  int pairs = 0;
  for (char c : seq.toCharArray()) {
    if (s.isEmpty()) {
      s.push(c);
    } else if (s.peek() == c) {
      s.pop();
      pairs++;
    } else {
      s.push(c);
    }
  }
  return pairs;
}

/**
	* Search for element in rotated sorted array
	*/

boolean rotatedBinarySearch(int[] arr) {

}

/**
	* Given an array, return true if it can be partitioned into two subarrays
	* whose sum of elements are the same, else return false.
	*
	* Input: {5,1,5,11}
	* Output: true (can be divided into {5,1,5} and {11} where 5 + 1 + 5 = 11
	*/

boolean dividedSum(int[] nums) {
  int sum = 0;
  for (int num : nums) {
    sum += num;
  }
  int lsum = 0;
  for (int num : nums) {
    lsum += num;
    if (lsum == sum - lsum) return true;
  }
  return false;
}

/**
	* Perform In-Order traversal through a binary tree without recursion
	*/

void inOrderIterative(Node root) {
  if (root == null) return;
  Stack<Node> s = new Stack<>();
  while (true) {
    while (root != null) {
      s.push(root);
      root = root.left;
    }
    if (s.isEmpty()) return;
    root = s.pop();
    System.out.println(root.val);
    root = root.right;
  }
}

/**
  * Perform Pre-Order traversal through a binary tree without recursion
  */

void preOrderIterative(Node root) {
  if (root == null) return;
  Stack<Node> s = new Stack<>();
  s.push(root);
  while (!s.isEmpty()) {
    Node n = s.pop();
    System.out.println(n.val);
    if (n.right != null) {
      s.push(n.right);
    }
    if (n.left != null) {
      s.push(n.left);
    }
  }
}

/**
  * Perform Post-Order traversal through a binary tree without recursion
  */

void postOrderIterative(Node root) {
  if (root == null) return;
  Stack<Node> s1 = new Stack<>();
  Stack<Node> s2 = new Stack<>();
  s1.push(root);
  while (!s1.isEmpty()) {
    Node n = s1.pop();
    s2.push(n);
    if (n.left != null) {
      s1.push(n.left);
    }
    if (n.right != null) {
      s2.push(n.right);
    }
  }
  while (!s2.isEmpty()) {
    Node n = s2.pop();
    System.out.println(n.val);
  }
}

/**
	* Serialize and deserialize a binary tree
	*/

List<String> serialize(Node root) {
  List<String> serialized = new ArrayList<>();
  if (root == null) {
    serialized.add("#");
  } else {
    serialized.add(String.valueOf(root.val));
    serialized.addAll(serialize(root.left));
    serialized.addAll(serialize(root.right));
  }
  return serialized;
}

Node deserialize(List<String> serialized) {
  if (serialized.size() == 0) return null;
  String val = serialized.get(0);
  serialized.remove(0);
  if (val.equals("#")) return null;
  Node n = new Node(Integer.parseInt(val));
  n.left = deserialize(serialized);
  n.right = deserialize(serialized);
  return n;
}

/**
  * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
  */

List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  levelHelper(res, root, 0);
  return res;
}

void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
  if (root == null) return;
  if (height >= res.size()) {
    res.add(new ArrayList<Integer>());
  }
  res.get(height).add(root.val);
  levelHelper(res, root.left, height+1);
  levelHelper(res, root.right, height+1);
}

/**
	* Print level order through a binary tree in reverse
	*/

void reverseLevelOrder(Node root) {
  Stack<Node> s = new Stack<>();
  Stack<Node> q = new Queue<>();
  q.add(root);
  while (!q.isEmpty()) {
    Node n = q.poll();
    s.push(n);
    if (n.left != null) {
      q.add(n.left);
    }
    if (n.right != null) {
      q.add(n.right);
    }
  }
  while (!s.isEmpty()) {
    Node n = s.pop();
    System.out.println(n.val);
  }
}

/**
	* Given a sorted dictionary (array of words) of an alien language, find order
	* of characters in the language.
	*
	* Input: {"caa", "aaa", "aab"}
	* Output: 'c', 'a', 'b'
	*/



/**
	* Given two arrays of integers, compute the pair of values (one value in each
	* array) with the smallest (non-negative) difference and return it.
	*
	* Input: {1,3,15,11,2},{23,127,235,19,8}
	* Output: 3
	*/



/**
  * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
  */



/**
  * Return the minimum depth of binary tree
  */

int minDepth(Node root) {
  if (root == null) return 0;
  int min = Integer.MAX_VALUE;
  if (root.left != null) {
    min = Math.min(min, minDepth(root.left));
  }
  if (root.right != null) {
    min = Math.min(min, minDepth(root.right));
  }
  if (min == Integer.MAX_VALUE) min = 0;
  return 1 + min;
}

/**
  * Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary expression to a binary tree.
  *
  * Input: a?b?c:d:e
  * Output:
  *           a
  *          / \
  *         b   e
  *        / \
  *       c   d
  */

Node ternaryToTree(String exp) {
  Stack<Node> s = new Stack<Node>();
  Node root = new Node(exp.charAt(0));
  s.push(root);
  for (int i = 1; i < exp.length(); i += 2) {
    Node n = new Node(exp.charAt(i+1));
    char op = exp.charAt(i);
    if (op == '?') {
      s.peek().left = n;
    }
    if (op == ':') {
			s.pop();
      while (s.peek().right != null) {
        s.pop();
      }
      s.peek().right = n;
    }
    s.push(n);
  }
  return root;
}

// Function to convert Ternary Expression to a Binary
// Tree. It return the root of tree
Node convertExpression(char[] expression, int i)
{
	// Base case
	if (i >= expression.length)
		return null;

	// store current character of expression_string
	// [ 'a' to 'z']
	Node root = new Node(expression[i]);

	// Move ahead in str
	++i;

	// if current character of ternary expression is '?'
	// then we add next character as a left child of
	// current node
	if (i < expression.length && expression[i]=='?')
		root.left = convertExpression(expression, i+1);

	// else we have to add it as a right child of
	// current node expression.at(0) == ':'
	else if (i < expression.length)
		root.right = convertExpression(expression, i+1);

	return root;
}

/**
  * Implement an atoi method
  */

int atoi(String num) {
  int fin = 0;
  int neg = 1;
  for (char c : num.toCharArray()) {
    if (c == '-') {
      neg = -1;
      continue;
    }
    fin *= 10;
    fin += Integer.valueOf(c);
  }
  return neg*fin;
}

/**
  * Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).
  */

/**
  * Merge intervals
  */

List<Interval> merge(List<Interval> intervals) {
  if (intervals.size() <= 1)
    return intervals;

  // Sort by ascending starting point using an anonymous Comparator
  intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

  List<Interval> result = new LinkedList<Interval>();
  int start = intervals.get(0).start;
  int end = intervals.get(0).end;

  for (Interval interval : intervals) {
    if (interval.start <= end) // Overlapping intervals, move the end if needed
      end = Math.max(end, interval.end);
    else {                     // Disjoint intervals, add the previous one and reset bounds
      result.add(new Interval(start, end));
      start = interval.start;
      end = interval.end;
    }
  }

  // Add the last interval
  result.add(new Interval(start, end));
  return result;
}

/**
  * Find interval overlaps
  */

/**
  * Find the point in which maximum intervals overlap
  * Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
  */

int maxIntervalsOverlap(int[] arrival, int[] exit) {
  Arrays.sort(arrival);
  Arrays.sort(exit);
  int guestsIn = 1, maxGuests = 1, time = arrival[0];
  int i = 1, j = 0;
  // Similar to merge in merge sort to process
  // all events in sorted order
  while (i < n && j < n) {
    // If next event in sorted order is arrival,
    // increment count of guests
    if (arrival[i] <= exit[j]) {
      guestsIn++;

      // Update max_guests if needed
      if (guestsIn > maxGuests) {
        maxGuests = guestsIn;
        time = arrival[i];
      }
      i++;  //increment index of arrival array
    } else {
      // If event is exit, decrement count
      // of guests.
      guestsIn--;
      j++;
    }
  }
  return maxGuests;
}

/**
  * Amazing number
  */

int diffCountArray(int[] idx, int[] arr) {
  int count = 0;
  for (size_t i = 0; i < N; i++) {
    if (arr[i] <= idx[i]) {
      count++;
    }
  }
  return count;
}

int findANSimple(int[] arr) {
  int start = 0;
  int len = arr.length;
  int[] idx = new int[len];
  int maxStart = -1;
  int maxCount = -1;

  for (start = 0; start < len; start++) {
    //set indices according to the start position
    for (int i = 0; i < len; i++) {
      idx[i] = (i - start) < 0 ? (i - start + len) : i-start; // circular mod
    }

    int currentCount = diffCountArray(idx, arr);
    if (currentCount > maxCount) {
      maxStart = start;
      maxCount = currentCount;
    }
  }

  return maxStart;
}

/**
 	* Implement an LRU cache
	*/
	
class LRUCache {
	private int cacheSize;
	private Map<Integer, Node> cache;
	private Node head;
	private Node tail;

	class Node {
		int pageKey;
		Object pageVal;
		Node prev;
		Node next;

		public Node(int pageKey, Object pageVal) {
			this.pageKey = pageKey;
			this.pageVal = pageVal;
			this.prev = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return String.format("key: %s, value: %s", pageKey, pageVal.toString());
		}
	}

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		this.cache = new HashMap<Integer, Node>();
	}

	public Object getPage(int pageKey) {
		Node pageNode;
		if (cache.containsKey(pageKey)) { // cache contains reference to page in memory
			pageNode = cache.get(pageKey);
			/* detach node from LL */
			if (pageNode.prev != null) {
				pageNode.prev.next = pageNode.next;
			}
			if (pageNode != head && pageNode.next != null) {
				pageNode.next.prev = pageNode.prev;
			}
		} else { // cache doesn't contain reference to page and retrieves from disk
			pageNode = getPageFromDisk(pageKey);
			if (cache.size() == cacheSize) { // cache size full, remove least recently used
				cache.remove(tail.pageKey);
				tail = tail.prev;
				tail.next = null;
			} 
			if (head == null) { // cache is empty
				head = pageNode;
				tail = pageNode;
			}
		}
		if (head != pageNode) { // update LL to reflect most recently used page
			head.prev = pageNode;
			pageNode.next = head;
			head = head.prev;
		}
		cache.put(pageKey, pageNode);
		return pageNode.pageVal;
	}

	public void printQueue() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp);
			tmp = tmp.next;
		}
	}

	public void printCache() {
		System.out.println(cache.toString());
	}

	private Node getPageFromDisk(int pageKey) {
		return new Node(pageKey, String.valueOf(pageKey));
	}
}

/**
 	* Implement a queue with one stack
	*/
	
class QueueOneStack {
	Stack<Integer> s;
	int retVal;

	public QueueOneStack() {
		s = new Stack<Integer>();
	}

	public void enqueue(int num) {
		s.push(num);
	}

	public int dequeue() {
		dequeueHelper();
		return retVal;
	}

	private void dequeueHelper() {
		if (s.size() == 0) {
			retVal = Integer.MIN_VALUE;
			return;
		}
		if (s.size() == 1) {
			retVal = s.pop();
			return;
		}
		int save = s.pop();
		dequeueHelper();
		s.push(save);
	}
}
