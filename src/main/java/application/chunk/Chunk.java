package application.chunk;

import java.awt.Point;

import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.value.EventValue;

public final class Chunk implements MyEntity<Chunk> {

	@Override
	public void workOn(final VoidTaskOfEntity<Chunk> task) {
		task.handle(this);
	}

	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, Chunk> task) {
		return task.handle(this);
	}
	
	final double blockSize = 50;
	final double multiplier = 20;
	final EventValue<Point> playerChunkCoord = new EventValue<Point>(new Point(0, 0));
}
