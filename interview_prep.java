/**
  * Check if string consists of only unique characters
	*/

boolean isUnique(String s) {
	boolean[] characters = new boolean[128];
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
	int[] frequencies = new int[128];
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

// Recursively reverse  a linked list
// 1 -> 2 -> 3 -> 4 -> 5

Node reverse(Node head) {
	if (head == null) return null;
	if (head.next == null) return head;
	Node second = head.next;
	head.next = null;
	Node rest = reverse(second);
	second.next = head;
	return rest;
}

// Iteratively reverse a linked list

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

// Delete a ndoe given only that node (and if not last in a linked list)

void deleteNode(Node n) {
	n.val = n.next.val;
	n.next = n.next.next;
}

// Check if two strings are anagrams of each other

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

// Return the # of deletes in order to make two strings anagrams of each other

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

// Find the pair in a array that have the smallest absolute value difference

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

// Find the number of times a substring occurs in a string

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

// Add two binary numbers represented as strings

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

// Validate that a string containing different parenthesis is valid (closing in the right order)
// Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘, and ‘]’,
// determine if the input string is valid

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

// Print all possible permuatations of a string

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

// Return whether two strings are isomorphic
// egg, fee -> TRUE
// get, tet -> FALSE

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

// Find the minimum distanec between two words in an array of strings (duplicates exist)

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

// Return the unique items in a unsorted array

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

// Return the unique items in a sorted array

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

// Print out the duplicates in an unsorted array

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

// Print out duplicates in an sorted array

void printDuplicatesSorted(int[] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
		if (arr[i] == arr[i+1]) {
			System.out.println(arr[i]);
		}
	}
}

// Check if a string is just a rotation of another string

boolean checkRotation(String str1, String str2) {
	String combined = str1 + str2;
	if (combined.contains(str1)) {
		return true;
	}
	return false;
}

// Implement a function that returns x^n
// n is a positive/negative integer

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

// Find the missing number given given a list of n-1 integers, these integers
// are in the range 1 to n. One of the integers list is missing in the list and
// you have to find it

int missingNumber(int[] nums) {
	// sum = n(n+1)/2
	int n = nums.length;
	int sum = n*(n+1)/2;
	for (int num : nums) {
		sum -= num;
	}
	return sum;
}

// Find max sub-array sum of input array of positive and negative integers

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

// Return all factors of a number

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

// Move all zeroes in an array to the end
// {1,2,0,0,1,2,0} -> {1,2,1,2,0,0,0}
// {0,1,2,3,0,0} -> {1,2,3,0,0,0}

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

// Remove duplicates in linked list
// 1 -> 0 -> 0 -> 2 -> 3 -> 2

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

// Find if a linked list is looped

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

// Implement a queue with an array

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

// Implement a stack that returns the minimum value in constant time (no dups)

class Stack {
	private List<Integer> s = new ArrayList<>();
	private List<Integer> mins = new ArrayList<>();

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

Stack<Integer> sortStackWithStack(Stack<Integer> s1) {

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

List<Integer> kFrequent(int[] arr) {
  Queue<Integer> pq = new PriorityQueue<>();

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

int editDistanceHelper(String str1, String str2, int it1, it2) {
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

// DP SOLUTION


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
	* Given a set of non-negative integers, and a value sum, determine if there is
	* a subset of the given set with sum equal to given sum.
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

/**
	* Given a set of non-negative numbers, and a value sum, return all valid
	* subsets that add up to given sum
	*/

List<List<Integer>> returnSubsetSum(List<Integer> set, int sum) {

}

/**
  * Find the length of longest unique substring
	*/

public int lengthOfLongestSubstring(String s) {
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
			if (end - start + 1 > maxLen) {
				maxLen = end - start + 1;
			}
		} else {
			start = end;
		}
		end++;
	}
	return maxLen;
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

List<Integer>[] returnPowerSet(int[] set) {
	int powSize = 1 << set.length;
	List<Integer>[] powSet = new List<Integer>[powSize];
	for (int i = 0; i < powSet; i++) {
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
	* Given a binary tree, create a doubly linked list with data in the same order
	* as an In-Order Traversal through the tree
	*/

Node inOrderToDoublyLinkedList(Node head) {

}


/**
	* Convert Roman numeral string to integer representation
	*/

int romanNumeralToInteger(String romanNum) {

}

/**
	* Convert integer to Roman numeral representation
	*/

String integerToRomanNum(int num) {

}

/**
	* Given list of (x,y) coordinates, an origin (o.x,o.y), and a number k find
	* the k-th closest coordinate to the origin
	*/



/**
	* Given an array of distinct elements, find triplets in array whose sum is zero
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
	*/

int returnDiameter(Node head) {

}

/**
	* Reverse a number
	* 1234 -> 4321
	*/

int reverseNum(int num) {
	int reversed = 0;
	while (num > 0) {
		reversed = reversed * 10;
		reverse += num % 10;
		num /= 10;
	}
}

/**
 	* Interval scheduling/activity selection
	*/

List<Integer[]>

/**
	* Change making (DP or Greedy)
	*/

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

/**
	* Given an array of integers and a target number, determine if an arithmetic
	* expression using htese integers can be evaluated to the target number.
	* You are allowed to use the +, -, * and / operations.
	*/


/**
	* Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
	*/

/**
	* Find the sum of two infinitely large integers represented as strings
	*/

/**
	* Find the product of two large integers represented as strings
	*/

/**
	* Merge k sorted lists
	*/

	

/**
	* Find the maximum difference between two elements in an array such that the
	* larger number appears after the smaller number in the array
	*/
