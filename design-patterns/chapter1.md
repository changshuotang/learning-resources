## Creational Design Patterns

Creational design patterns are focused on how to handle the instantiation of objects or a group of related objects. Abstract away object creation to reduce complexity and gain additional control.

### Simple Factory

A Simple factory generates an instance of an object for the client without exposing instantiation logic. Pass the parameters into a function in the factory that will create and return the desired Object.

```java
public class Door{
  private int wood;
  public Door(wood){
    this.wood = wood;
  }
}
    
public class DoorFactory {
  public Door makeDoor(material){
    return new Door(material);
  }
}
```

### Factory Method

Factory methods uses inheritance delegate instantiation logic to child classes. 

```java
public class Carpenter {
  public Door makeDoor(){
    return new GoodDoor();
  }
}
    
public class Apprentice extends Carpenter {
  public Door makeDoor(){
    return new ShoddyDoor();
  }
}
```

### Abstract Factory

An abstract factory is a interface with factory methods. Using polymorphism you can create a family to related classes that use the same factory method name with different implementation.

```java
public interface DoorFactory {
  public Door makeDoor();
}

public class WoodDoorFactory implements DoorFactory {
  public Door makeDoor(){
    return new WoodDoor();
  }
}

public class SteelDoorFactory implements DoorFactory {
  public Door makeDoor(){
    return new SteelDoor();
  }
}
```

### Builder

Used to create different flavors of an object while avoiding constructor pollution. Class constructor takes in a "builder" class that shares the same instance variables. Should use Builder if creating the class is a multi-step process.

```java
public class Door{
  private int width, length;
  public Door(DoorBuilder db){
    this.width = db.width;
    this.height = db.height;
  }
}

public class DoorBuilder {
  private int width, length;
  public DoorBuilder() {
    this.width = 100;
    this.height = 400;
  }
  public void setWidth(int w){
    this.width = w;
  }
  public void setHeight(int h){
    this.height = h;
  }
}
```

### Prototype

Create object based on an existing object through cloning instead of creating a new object from scratch.

```java
class Door:
  def __init__(self, woodType):
    self.woodType = woodType
    
mapleDoor = Door('Maple)
mapleDoor2 = copy.copy(mapleDoor)
```

### Singleton

Ensure only one object of a particular class is ever created. 

```java
public enum Singleton {
  INSTANCE("abc", 123);
  
  private String str;
  private int i;
  
  Singleton(String str, int i){
    this.str = str;
    this.i = i;
  }
}
```