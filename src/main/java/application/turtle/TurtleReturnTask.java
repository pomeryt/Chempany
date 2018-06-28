package application.turtle;

public interface TurtleReturnTask<T, P> {
	T handle(P param);
}
