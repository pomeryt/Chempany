package application.player;

import javafx.node.task.movement.Up2DWithCamera;
import javafx.scene.Camera;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerMoveUp implements VoidTaskOfEntity<Player> {

	public PlayerMoveUp(final Camera camera, final double speed) {
		this.camera = camera;
		this.speed = speed;
	}
	
	@Override
	public void handle(final Player player) {
		player.cachedMovingNode.value().move(new Up2DWithCamera(this.camera, this.speed));
		if (this.speed != 0) {
			player.moveEvents.forEach(event -> {
				event.handle(player);
			});
		}
	}
	
	private final Camera camera;
	private final double speed;
}
