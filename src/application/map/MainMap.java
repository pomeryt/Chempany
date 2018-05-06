package application.map;

import java.awt.Point;

public final class MainMap {
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
