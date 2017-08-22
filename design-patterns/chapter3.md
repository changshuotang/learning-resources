
## Behavioral Design Patterns

Behavioral design patterns identifies common communication patterns between entities and realizes them.

### Chain of Responsibility

Build a chain of objects; request enters from one end and keeps going from object to object till it finds a suitable handler.

```java
public class Account {
	private Account next;
	private int balance;

	public void setNext(Account next){
		this.next = next;
	}

	public Boolean canPay(int amount){
		if (this.balance > amount){
			return True;
		} 
		else if (this.next != null){
			return this.next.canPay();
		}
		else {
			throw new Exception("No accounts have enough balance!")
		}
	}
}
```

In the example above each instance of the class Account can set another Account as a fallback. By chaining Account objects in this way we create a chain of responsibility.

### Command

An object is used to encapsulate all information needed to perform an action or trigger an event at a later time.

```java
public class Bulb{
	public void turnOn(){
		System.out.println("Light!");
	}

	public void turnOff(){
		System.out.println("Darkness!");
	}
}

public interface Command {
	public void execute();
}

public class turnOn implements Command{
	private Bulb bulb;

	public turnOn(Bulb bulb){
		this.bulb = bulb;
	}

	@Override
	public void execute(){
		this.bult.turnOn();
	}
}

public class turnOff implements Command{
	private Bulb bulb;

	public turnOn(Bulb bulb){
		this.bulb = bulb;
	}

	@Override
	public void execute(){
		this.bult.turnOff();
	}
}

public class RemoteControl {
	public void submit(Command command){
		command.execute();
	}
}
```

### Iterator

An iterator is used to traverse a container and access the container's elements.

### Mediator

A third party object is introduced to control the interaction between two objects.

### Memento

Captures and store the current state of a object in a manner that can be restored later on in a smooth manner.

### Observer

Defines a dependency between objects so that whenever an object changes its state, all its depedents are notified.

### Visitor

Add further operations to objects without having to modify them.

### Strategy

Allows you to switch the algorithm or strategy based upon the situation.

### State

Lets you change the behavior of a class when the state changes.

### Template Method

Defines the skeleton of how a certain algorithm could be performed, but defers the implementation of those steps to the children classes.


