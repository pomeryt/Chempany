package application.utility.point;

import java.awt.Point;

import plain.contract.give.PlainGiveable;

public final class ChunkPointOfPlayer implements PlainGiveable<Point> {

	public ChunkPointOfPlayer(final double playerXPos, final double playerYPos, final double blockSize, final double multiplier) {
		this.playerXPos = playerXPos;
		this.playerYPos = playerYPos;
		this.blockSize = blockSize;
		this.multiplier = multiplier;
	}
	
	@Override
	public Point value() {
		return new Point(
			(int) Math.floor(
				this.playerXPos / (this.blockSize * this.multiplier)
			), 
			(int) Math.floor(
				this.playerYPos / (this.blockSize * this.multiplier)
			)
		);
	}
	
	private final double playerXPos;
	private final double playerYPos;
	private final double blockSize;
	private final double multiplier;
}
