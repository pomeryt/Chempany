package application.player;

import javafx.scene.Camera;
import javafx.scene.Node;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerMoveUp implements VoidTaskOfEntity<Player> {

	public PlayerMoveUp(final Camera camera, final double speed) {
		this.camera = camera;
		this.speed = speed;
	}
	
	@Override
	public void handle(final Player player) {
		final Node playerBody = player.body.value();
		
		player.actionMap.update("up", () -> {
			playerBody.setTranslateY(playerBody.getTranslateY() - this.speed);
			this.camera.setTranslateY(this.camera.getTranslateY() - this.speed);
			
			if (this.speed != 0) {
				player.moveEvents.forEach(event -> event.handle(player));
			}
		});
	}
	
	private final Camera camera;
	private final double speed;
}
