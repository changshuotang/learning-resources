## 12) C and C++

### Classes and Inheritance

```c++
#include <iostream>
using namespace std;

#define NAME_SIZE 50  //defines a macro

class Person {
  int id;
  char name[NAME_SIZE];

public:
  void aboutMe() {
    cout << "I am a person.";
  }
};

class Student : public Person {
public:
  void aboutMe() {
    cout << "I am a student.";
  }
};

int main() {
  Student *p = new Student();
  p->aboutMe();   //prints "I am a student."
  delete p;       //de-allocates memory
  return 0;
}
```

NOTE: All data members and methods are private by default in C++. Use the ```public``` keyword to denote otherwise.

### Constructors and Destructors

A default constructor is called if we do not specify a constructor.

```c++
Person(int a) : id(a) {
  ...
}
```

A destructor cleans up upon object deletion and is automatically called when an object is destroyed. It can't take an argument as we don't explicitly call a destructor.

```c++
~Person() {
  delete obj; //free any memory allocated within class
}
```

### Virtual Functions

```c++
Person *p = new Student();
p->aboutMe();
```

In the above case ```aboutMe``` would print "I am a person." because the function is resolved at compile time, in a mechanism known as _static binding_. To ensure the ```Student``` implementation of ```aboutMe``` is called we need to define ```aboutMe``` in the ```Person``` class to be virtual.

```c++
class Person {
  ...
public:
  virtual void aboutMe() {
    cout << "I am a person.";
  }
};

class Student : public Person {
public:
  void aboutMe() {
    cout << "I am a student.";
  }
};
```

Another use for virtual functions is when leave the implementation of a method to the subclass.

```c++
class Person {
  ...
public:
  virtual void aboutMe() {
    cout << "I am a person." << endl;
  }
  virtual bool addCourse(string s) = 0;
};

class Student : public Person {
public:
  void aboutMe() {
    cout << "I am a student." << endl;
  }
  virtual bool addCourse(string s) {
    cout << "Added course " << s << " to student." << endl;
  }
};
```

### Virtual Destructor

```c++
Person *p = new Student();
delete p;
```

The above code will called the destructor for the ```Person``` class which may not clean up memory for ```Student```. We simply need to define the destructor for ```Person``` to be virtual.

```c++
class Person {
public:
  virtual ~Person() {
    cout << "Deleting a person." << endl;
  }
};

class Student {
public:
  virtual ~Student() {
    cout << "Deleting a student." << endl;
  }
};

int main() {
  Person *p = new Student();
  delete p;
}
```

The above will output the following:
```
Deleting a student.
Deleting a person.
```

### Default Values

Function can specify default values for parameters; they must be on the right side of the function declaration.

```c++
int func(int a, int b = 3){
  return a + b;
}

w = func(4);        //w = 7
z = function(4, 5); //z = 9
```

### Operator Overloading

Operator overlaoding lets us apply operators like ```+``` to objects that would otherwise not support it.

```c++
BookShelf Bookshelf::operator+(BookShelf &other) {
  ...
}
```

### Pointers and References

A pointer holds the address of a variable and can be used to perform any operations that can be directly done the variable itself. Two pointers can point to the same address, and changing one would change the other.

```c++
int *p = new int;
*p = 7;
int *q = p;
*p = 8;
cout << *q; //prints 8
```

#### References

A reference is an alias for a pre-existing object and does not have any memory of its own.

```c++
int a = 5
int &b = a;
b = 7;
cout << a;  //prints 7
```

You cannot create a reference without specifying where in memory it refers to. Unlike pointers, references cannot be null and cannot be reassigned to another piece of memory.

#### Pointer Arithmetic

```c++
int *p = new int[2];
p[0] = 0;
p[1] = 1;
p++;
cout << *p; //prints 1
```

Performing ```p++``` will move the pointer ```sizeof(int)``` bytes down the array. This will sky ahead as many bytes as the size of the data structure.

### Templates

Templates are ways of reusing code to apply the same class to different data types. For example we might a list-like data strcture which we would use for lists of various types.

```c++
template <class T> class ShiftedList {
  T* array;
  int offset, size;
public:
  ShiftedList<int sz> : offset(0), size(sz) {
    array = new T[size];
  }

  ~ShiftedList() {
    delete [] array;
  }

  void shiftBy(int n) {
    offset = (offset + n) % size;
  }

  T getAt(int i) {
    return array[convertIndex(i)] = item;
  }

  void setAt(T item, int i) {
    array[convertIndex(i)] = item;
  }
private:
  int convertIndex(int i) {
    int index = (i - offset) % size;
    while(index < 0) index += size;
    return index;
  }
};
```
