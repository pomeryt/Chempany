package application.chunk;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.block.Block;
import javafx.scene.layout.StackPane;
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
	final Map<Point, Block> blocks = new HashMap<>();
	final List<Point> loadedChunks = new ArrayList<>();
	final Map<Point, StackPane> chunkBoundaries = new HashMap<>();
}
