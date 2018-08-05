package application.utility.point;

import java.awt.Point;

import plain.contract.give.PlainGiveable;

/**
 * Give top-left Point of the specified chunk.
 * @author Rin
 * @version 1.0.0
 */
public final class FirstPointOfChunk implements PlainGiveable<Point> {

	public FirstPointOfChunk(final Point chunkCoordinate, final double multiplier) {
		this.chunkCoordinate = chunkCoordinate;
		this.multiplier = multiplier;
	}
	
	@Override
	public Point value() {
		return new Point(
			this.chunkCoordinate.x * (int) this.multiplier,
			this.chunkCoordinate.y * (int) this.multiplier
		);
	}
	
	private final Point chunkCoordinate;
	private final double multiplier;
}
