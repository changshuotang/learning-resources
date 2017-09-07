## 6) Math and Logic Puzzles

### Prime Numbers

Every positive integer can be decomposed into a product of primes, for example:

$$
84 = 2^2 * 3^1 * 5^0 * 7^1 * 11^0 * 13^0 * 17^0 * ...
$$

##### Divisibility

In order for $$x$$ to be divisible by $$y$$ all primes in $$x$$'s prime factorization must be in $$y$$'s prime factorization. In fact...

$$
Let\ x = 2^{j0} * 3^{j1} * 5^{j2} * ...
$$

$$
Let\ y = 2^{k0} * 3^{k1} * 5^{k2} * ...
$$

$$
gcd(x, y)\ = 2^{min(i0,\ j0)} * 3^{min(i1,\ j1)} * 5^{min(i2,\ j2)} * ...
$$

$$
lcd(x, y)\ = 2^{max(i0,\ j0)} * 3^{max(i1,\ j1)} * 5^{max(i2,\ j2)} * ...
$$

$$
gcd * lcd = x * y
$$

##### Checking for Primality

A naive method of checking primality would be iterate from ```2``` to ```n-1``` and checking the divisibility of each iteration. A slightly better approach would be to only iterate to the square root of ```n```. This is because for every number ```a``` that divided ```n``` evenly there is a complement ```b```; ```a * b = n```. If ```a > sqrt(n)``` then ```b < sqrt(n)```.

##### Generating a List of Primes: The Sieve of Eratosthenes

The sieve of Eratosthenes is a highly efficient way to generate a list primes, based on the fact that all non-prime numbers are divisible by a prime number. We start with a list of all numbers up to some value ```max```. We first cross off all numbers divisible by 2. Then we start crossing off numbers divisible by prime numbers, increasing until we are left with a list of prime numbers from 2 through ```max```.

### Probability

$$
Bayes'\ Theorem:\ P(A\ and\ B) = P(B\ given\ A)\ P(A)
$$

$$
P(A\ or\ B) = P(A)\ +\ P(B)\ -\ P(A\ and\ B)
$$

$$
If\ A\ and\ B\ independent:\ P(A\ and\ B) = P(A)\ P(B)
$$

$$
If\ A\ and\ B\ mutually\ exclusive:\ P(A\ and\ B) = P(A)\ or\ P(B)
$$