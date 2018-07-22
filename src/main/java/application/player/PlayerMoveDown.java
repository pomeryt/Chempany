package application.player;

import javafx.node.task.movement.Down2DWithCamera;
import javafx.scene.Camera;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerMoveDown implements VoidTaskOfEntity<Player> {

	public PlayerMoveDown(final Camera camera, final double speed) {
		this.camera = camera;
		this.speed = speed;
	}
	
	@Override
	public void handle(final Player player) {
		player.cachedMovingNode.value().move(new Down2DWithCamera(this.camera, this.speed));
		if (this.speed != 0) {
			player.moveEvents.forEach(event -> {
				event.handle(player);
			});
		}
	}
	
	private final Camera camera;
	private final double speed;
}
