package application.turtle;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.validation.ValueValidation;
import plain.value.update.ThrowableUpdate;

/**
 * Look at the specified direction. <br>
 * Direction: 0 - North, 1 - East, 2 - South, 3 - West.
 * @author Rin
 * @version 1.0.0
 */
public final class TurtleLook implements VoidTaskOfEntity<Turtle> {

	public TurtleLook(final int direction) {
		this.direction = direction;
	}
	
	@Override
	public void handle(final Turtle turtle) {
		turtle.direction.update(new ThrowableUpdate<Integer>(
			this.direction, 
			this.direction+" is invalid direction. You must choose from the following: 0 - north, 1 - east, 2 - south, 3 - west", 
			new ValueValidation<Integer>() {
				@Override
				public boolean valid(final Integer value) {
					return (value >= 0 && value <= 3);
				}
			}
		));
	}
	
	private final int direction;
}
