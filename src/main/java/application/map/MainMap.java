package application.map;

import java.awt.Point;

public final class MainMap {
	/**
	 * Define default values: <br>
	 * block size - 50. <br>
	 * multiplier - 20. 
	 */
	public MainMap() {
		this(50, 20);
	}
	
	public MainMap(final double blockSize, final double multiplier) {
		this.blockSize = blockSize;
		this.multiplier = multiplier;
	}
	
	public Point currentChunkCoordOfUser(final double xCoordOfUser, final double yCoordOfUser) {
		final int xCoordOfChunk = (int) Math.floor(xCoordOfUser / (blockSize * multiplier));
		final int yCoordOfChunk = (int) Math.floor((yCoordOfUser / (blockSize * multiplier)));
		
		return new Point(xCoordOfChunk, yCoordOfChunk);
	}
	
	private final double blockSize; // Default: 50;
	private final double multiplier; // Default: 20;
}
