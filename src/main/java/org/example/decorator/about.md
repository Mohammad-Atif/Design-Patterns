# Decorator Pattern

Decorator pattern attaches extra functionality to the object dynamically.

1. Decorators have same supertype as the objects they decorate.
2. Decorator have both has-a and is-a relationship with the objects
3. Decorators can save us from class Explosion
4. We can pass the decorators as objects to other decorators(since it also extend same supertype as the object it decoratess).

## Example

````
abstract class Bevarage {

}
````