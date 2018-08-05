package application.chunk;

import java.awt.Point;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;

/**
 * Execute something when chunk coordinate of player has been changed.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkOnPlayerCoordUpdate implements VoidTaskOfEntity<Chunk> {

	@SafeVarargs
	public ChunkOnPlayerCoordUpdate(final ParamEvent<Point>...events) {
		this.events = events;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		for (ParamEvent<Point> event: this.events) {
			chunk.playerChunkCoord.addEvent(event);
		}
	}
	
	private final ParamEvent<Point>[] events;
}
