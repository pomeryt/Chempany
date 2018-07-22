package application.block;

import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;

public final class Block implements MyEntity<Block> {

	@Override
	public void workOn(final VoidTaskOfEntity<Block> task) {
		task.handle(this);
	}

	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, Block> task) {
		return task.handle(this);
	}
	
}
