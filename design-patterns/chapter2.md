
## Structural Design Patterns

Structural design patterns focuses on using composition to realize relationships between entities.

### Adapter

Wrap incompatible object in an adapter class to make it compatible with another class, whether through inheritance or interfaces.

```java
public class Hunter {
  public void hunt(Lion lion){
    lion.roar();
  }
}

public class Wolf {
  public void bark(){
    System.out.println("BARK!");
  }
}

public class WolfAdapter extends Lion {
  private Wolf wolf;
  public WolfAdapter(Wolf wolf){
    this.wolf = wolf;
  }
  @Override
  public void roar(){
    this.wolf.bark();
  }
}
```

### Bridge

Bridge pattern is about preferring composition over inheritance.

### Composite

Use polymorphism via an interface to treat different objects in a uniform manner.

```java
public class Engineer extends Employee{
  @Override
  public void getPaid(){
    return;
  } 
}

public class Manager extends Employee{
  @Override
  public void getPaid(){
    return;
  } 
}

public class Company {
  public List<Employee> employees = new ArrayList<>();
  
  public void addEmployee(Employee e){
    employees.add(e);
    return;
  }
  
  public void payAllEmployees(){
    for (e: this.employees){
      e.getPaid();
    }
    return;
  }
}
```

### Decorator

Dynamically change the behavior of an object at run time by wrapping them in an object of a decorator class.

```java
public class Espresso {
  public int getCost(){
    return 3;
  }
}

public class Mocha {
  private Espresso e;
  public Mocha(Espresso shot){
    this.e = shot;
  }
  
  public int getCost(){
    return e.getCost() + 1;
  }
}
```

### Facade

Facade pattern provides a simplified interface to a complex subsystem.

```java
public class EspressoMachine {
  public void turnOn(){
    System.out.println("Machine on!");
  }

  public void turnOff(){
    System.out.println("Machine off!");
  }

  public void steamMilk(){
    System.out.println("Milk steamed!");
  }
  
  public void oneShot(){
    System.out.println("Espresso shot done!");
  }
  
  public void doubleShot(){
    System.out.println("Double shot done!");
  }
}

public class Barista {
  private EspressoMachine em;
  public Barista(EspressoMachine em){
    this.em = em;
  }
  public void makeMocha(){
    em.turnOn();
    em.steamMilk();
    em.oneShot();
  }
}
```

### Flyweight

Minimize memory usage/computational expenses by sharing as much as possible with similar objects.

### Proxy

A class represents the functionality of another class.

```java
public class Door(){
  public void open(){
    System.out.println("Open!");
  }
  public void close(){
    System.out.println("Closed!");
  }
}

public class Security(){
  private password = "secret";
  private Door door;
  public Security(Door door){
    this.door = door;
  }
  
  public void open(String password){
    if (password.equals(this.password)){
      this.door.open();
    }
    else {
      Sysytem.out.println("Wrong Password!");
    }
  }
  
  public void close(){
    this.door.close();
  }
}
```
