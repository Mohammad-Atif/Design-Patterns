# Observer Pattern
1. This pattern is mainly used when there is a subject (Observable), depends on it's value change there are multiple observers where some operations needed to happend.
2. The Observer Pattern defines a one-to-many
   dependency between objects so that when one
   object changes state, all of its dependents are
   notified and updated automatically.
3. Example - NotifyMe click krne pe, jab bhi item stock me aata hai jis jis ne click kiya hota hai unko notification chale jata hai

## How it is implemented

1. One observable (subject) interface
```
Interface Observable {
void add(Observer observer);
void remove(Observer observer)
void notifyAllObservers() {
 iterate through each observers in list and call observer.update();
}
}
```
2. One observer interface
```
Interface Observer {
void update();
}
```
3. Now Subject like iphone stock will implement observable, and there will be a UserNotifcationService implementing observer as a observer.
