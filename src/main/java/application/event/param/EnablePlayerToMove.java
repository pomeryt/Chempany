package application.event.param;

import java.util.Arrays;

import application.fx.scene.event.EsCamera;
import application.fx.scene.event.EsOnKeyPressed;
import application.fx.scene.event.EsOnKeyReleased;
import application.fx.scene.event.EventScene;
import application.player.Player;
import application.player.PlayerMoveDown;
import application.player.PlayerMoveLeft;
import application.player.PlayerMoveRight;
import application.player.PlayerMoveUp;
import application.player.PlayerSpeed;
import javafx.scene.input.KeyCode;
import plain.contract.event.ParamEvent;
import plain.map.FlagMap;
import plain.map.FormalMap;
import plain.map.task.ConditionalRunForMap;
import plain.validation.map.IsAllFalseInMap;

public final class EnablePlayerToMove implements ParamEvent<Player> {

	public EnablePlayerToMove(final EventScene eventScene, final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this.eventScene = eventScene;
		this.flagMap = flagMap;
	}
	
	@Override
	public void handle(final Player player) {
		// Move.
		this.eventScene.workOn(
			new EsOnKeyPressed(keyEvent -> {
				final Runnable runnable = () -> {
					// Go up.
					if (keyEvent.getCode().equals(KeyCode.W)) {
						player.workOn(
							new PlayerMoveUp(
								this.eventScene.valueOf(new EsCamera()), 
								player.valueOf(new PlayerSpeed())
							)
						);
						return;
					}

					// Go down.
					if (keyEvent.getCode().equals(KeyCode.S)) {
						player.workOn(
							new PlayerMoveDown(
								this.eventScene.valueOf(new EsCamera()), 
								player.valueOf(new PlayerSpeed())
							)
						);
						return;
					}

					// Go left.
					if (keyEvent.getCode().equals(KeyCode.A)) {
						player.workOn(
							new PlayerMoveLeft(
								this.eventScene.valueOf(new EsCamera()), 
								player.valueOf(new PlayerSpeed())
							)
						);
						return;
					}

					// Go right.
					if (keyEvent.getCode().equals(KeyCode.D)) {
						player.workOn(
							new PlayerMoveRight(
								this.eventScene.valueOf(new EsCamera()), 
								player.valueOf(new PlayerSpeed())
							)
						);
						return;
					}
				};
				
				this.flagMap.run(new ConditionalRunForMap<>(runnable, new IsAllFalseInMap<>(Arrays.asList("esc"))));
			})
		);
		
		// Stop.
		this.eventScene.workOn(
			new EsOnKeyReleased(keyEvent -> {
				// Stop up.
				if (keyEvent.getCode().equals(KeyCode.W)) {
					player.workOn(
						new PlayerMoveUp(
							this.eventScene.valueOf(new EsCamera()), 0
						)
					);
					return;
				}
				
				// Stop down.
				if (keyEvent.getCode().equals(KeyCode.S)) {
					player.workOn(
						new PlayerMoveDown(
							this.eventScene.valueOf(new EsCamera()), 0
						)
					);
					return;
				}
				
				// Stop left.
				if (keyEvent.getCode().equals(KeyCode.A)) {
					player.workOn(
						new PlayerMoveLeft(
							this.eventScene.valueOf(new EsCamera()), 0
						)
					);
					return;
				}
				
				// Stop right.
				if (keyEvent.getCode().equals(KeyCode.D)) {
					player.workOn(
						new PlayerMoveRight(
							this.eventScene.valueOf(new EsCamera()), 0
						)
					);
					return;
				}
			})
		);
	}
	
	private final EventScene eventScene;
	private final FlagMap<String, FormalMap<String, Boolean>> flagMap;
}
