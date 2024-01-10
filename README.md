# yalazy
Yet another lazy loader implementation for Java applications.

This is just a simple `Supplier<T>` wrapper that get's called once when the `get` function is called for the first time and then subsequently returns the resulting value.

## Usage
Simply wrap your object using a `Supplier<T>` function and call `get` when you need the value.

```java
public class Main {
    public static void main(String[] args) {
        var number = new Lazy<>(getNumbers);
        System.out.println("number is not loaded yet");
        System.out.println("number is: " + number.get());
    }
    
    private static Integer getNumber() {
        System.out.println("number is being loaded");
        return 1;
    }
}
```

This should print out the following:
```
number is not loaded yet
number is being loaded
number is: 1
```

