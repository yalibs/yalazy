package dk.yalibs.yalazy;

import java.util.Optional;
import java.util.function.Supplier;

public class Lazy<T> {
	private Optional<T> result;
	private Supplier<T> supplier;

	public Lazy(Supplier<T> supplier) {
		this.result = Optional.empty();
		this.supplier = supplier;
	}

	public boolean isPresent() {
		return result.isPresent();
	}

	public boolean isEmpty() {
		return result.isEmpty();
	}

	public T get() {
		if(isPresent())
			return result.get();
		result = Optional.of(supplier.get());
		return result.get();
	}
}
