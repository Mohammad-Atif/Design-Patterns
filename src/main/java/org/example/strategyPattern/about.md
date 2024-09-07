# Strategy Pattern
1. This pattern is generally used when you have a parent class (Say vehicle), and it has multipe child class (Sports Vehicle, Commercial, OffRoad), now each class will extends the capabilty of base class but few of the child class provide same type of functionality(suppose Sports Vehicle provide its own Drive(), but drive() of Commercial and Offroad is same), so this will lead to _code duplication_. To avoid we will create a _Interface(Called Strategy)_ and the parent class will now wants the implementation from whatever class extending it, so common functality child class can pass same interface
2. It is also used to change behaviour at runtime, suppose you have a class with functionality A() now a perform a task, now client can decide(by passing strategy) how A() will be done.


