package application.player;

import javafx.node.task.movement.Right2DWithCamera;
import javafx.scene.Camera;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerMoveRight implements VoidTaskOfEntity<Player> {

	public PlayerMoveRight(final Camera camera, final double speed) {
		this.camera = camera;
		this.speed = speed;
	}
	
	@Override
	public void handle(final Player player) {
		player.cachedMovingNode.value().move(new Right2DWithCamera(this.camera, this.speed));
		if (this.speed != 0) {
			player.moveEvents.forEach(event -> {
				event.handle(player);
			});
		}
	}
	
	private final Camera camera;
	private final double speed;
}
