package application.turtle;

public interface Turtle<P> {
	void workOn(TurtleVoidTask<P> task);
	<T> T valueOf(TurtleReturnTask<T, P> task);
}
