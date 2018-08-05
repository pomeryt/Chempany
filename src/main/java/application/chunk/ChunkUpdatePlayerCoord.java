package application.chunk;

import java.awt.Point;

import application.player.Player;
import application.player.PlayerXPos;
import application.player.PlayerYPos;
import application.utility.point.ChunkPointOfPlayer;
import plain.contract.entity.VoidTaskOfEntity;

/**
 * Update chunk coordinates of the user.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkUpdatePlayerCoord implements VoidTaskOfEntity<Chunk> {

	public ChunkUpdatePlayerCoord(final Player player) {
		this.player = player;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		final Point latestPlayerChunk = new ChunkPointOfPlayer(
			this.player.valueOf(new PlayerXPos()), 
			this.player.valueOf(new PlayerYPos()), 
			chunk.blockSize, 
			chunk.multiplier
		).value();
		
		if (chunk.playerChunkCoord.value().equals(latestPlayerChunk) == false) {
			chunk.playerChunkCoord.update(latestPlayerChunk);
		}
	}
	
	private final Player player;
}
