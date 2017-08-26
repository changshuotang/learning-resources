## 5) Bit Manipulation

### Bit Facts and Tricks

- x ^ 0's = x
- x ^ 1's = ~x
- x ^ x = 0
- x & 0's = 0
- x & 1's = x
- x & x = x
- x | 0's = x
- x | 1's = 1's
- x | x = x

### Two's Complement and Negative Numbers

Computers typically store integers in two's complement representation. It uses a signed bits to represent negative number. To find the two's complement of a number flip the bits and add 1. So 7 in binary ```0111``` will turn into ```1001``` which will represent -7.

### Arithmetic vs. Logical Right Shift

In a logical right shift, we shift the bits and put a 0 in the most significant bit. It can be seen as literally shifting all the bits right and and getting rid of the least significant bit. It is indicated with a ```>>>``` operator.

In an arithmetic right shift, we shift values to the right but fill in the new bits the value of the sign bit. This has the effect of roughly dividing by two. It is indicated with a ```>>``` operator.

### Common Bit Tasks

```java
int getBit(int num, int i) {
  return ((num & (1 << i)) != 0);
}

int setBit(int num, int i){
  return num | (1 << i);
}

int clearBit(int num, int i){
  int mask = ~(1 << i);
  return num & mask;
}

int clearBitsMostSignifcantBitThroughI(int num, int i){
  int mask = (1 << i) - 1;
  return num & mask;
}

int clearBitsIthrough0(int num, int i){
  int mask = (-1 << (i + 1));
  return num & mask;
}

int updateBit(int num, int i, boolean bitsIs1){
  int value = bitIs1 ? 1 : 0;
  int mask = ~(1 << i);
  return (num & mask) | (value << i);
}
```
