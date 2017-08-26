## 7) Object-Oriented Design

### How to Approach

##### Step 1: Handle Ambiguity

OOD design questions are can be intentionally vague in order to test if you ask clarifying questions or make assumptions. Inquire who, what, where, when, how, why.

##### Step 2: Define the Core Objects

After understanding what we are designing, consider the "core objects" we will need i.e. for a restaurant we might need ```Table, Guest, Party, Order, Meal, Employee, Server, Host``` etc.

##### Step 3: Analyze Relationships

Decide the relationships between core objects (inheritance, many-to-one, one-to-many, etc.).

Like in the restaurant example:
- ```Party``` should have an array of ```Guests```
- ```Server``` and ```Host``` inherits from ```Employee```
- Each ```Table``` has one ```Party```, but each ```Party``` may have multiple ```Tables```
- One ```Host``` per restaurant

##### Step 4: Investigate Actions

Once we have a basic outline of our OOD, we need to decide on the key actions that the objects will take in relation to each other.

### Design Patterns

##### Singleton Class

The Singleton pattern ensures that a class has only one instance. This is useful when we need exactly one object to coordinate actions across the system.

##### Factory Method

The Factory Method offers an interface for creating an object, but lets the subclasses decide which class to instantiate. It is useful inthe following cases:
- A class cannot anticipate the type of objects it needs to create beforehand.
- A class requires its subclasses to specify the objects it creates.
- You want to localize the logic to instantiate a complex object.

