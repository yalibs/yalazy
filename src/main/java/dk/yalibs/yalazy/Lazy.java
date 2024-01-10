package dk.yalibs.yalazy;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Lazy loading wrapper for some T
 * @param <T> the type to wrap
 */
public class Lazy<T> {
	private Optional<T> result;
	private final Supplier<T> supplier;

	/**
	 * Constructs a new Lazy with a supplier function
	 * @param supplier a function that can generate a T result. This will be invoked when the resource is requested
	 */
	public Lazy(Supplier<T> supplier) {
		this.result = Optional.empty();
		this.supplier = supplier;
	}

	/**
	 * If a value is present, returns true, otherwise false.
	 * @return true if a value is present, otherwise false
	 */
	public boolean isPresent() {
		return result.isPresent();
	}

	/**
	 * If a value is not present, returns true, otherwise false.
	 * @return true if a value is not present, otherwise false
	 */
	public boolean isEmpty() {
		return result.isEmpty();
	}

	/**
	 * If a value is present, returns the value, otherwise calls the supplier function and then returns the resulting value.
	 * @return A non-null value of type T
	 */
	public T get() {
		if(isPresent())
			return result.get();
		result = Optional.of(supplier.get());
		return result.get();
	}
}
