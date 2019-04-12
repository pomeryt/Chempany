package application.overworld;

import application.chunks.Chunks;
import application.esc.EscScreen;
import application.player.Player;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Overworld.
 *
 * @author Rin
 */
public final class Overworld implements OverworldType {

    /**
     * Cached.
     *
     * @return Scene
     */
    @Override
    public Scene scene() {
        if (this.sceneBuilt) {
            return this.rawScene;
        }

        final StackPane root = new StackPane();

        this.rawScene = new Scene(root);

        final int playerSize = 50;

        final Pane panePlayerAndChunks = new Pane();
        panePlayerAndChunks.setMinSize(playerSize, playerSize);
        panePlayerAndChunks.setMaxSize(playerSize, playerSize);

        final Group groupChunks = new Group();

        final Player player = new Player(this.rawScene, groupChunks, playerSize);
        final Chunks chunks = new Chunks(player, groupChunks);

        panePlayerAndChunks.getChildren().addAll(player.body(), groupChunks);
        player.body().toFront();

        root.getChildren().add(panePlayerAndChunks);

        chunks.start();

        // FIXME This line should be below the initialization of this.rawScene.
        // FIXME The temporal coupling should be fixed somehow.
        this.buildEscScreen(this.rawScene, root);

        this.sceneBuilt = true;
        return this.rawScene;
    }

    /**
     * Initialize {@link EscScreen}.
     * The initialization point will be at {@link Overworld#scene()}.
     *
     * @param scene Event handler will be added to listen to the ESC key press.
     * @param root ESC screen will be injected into this root.
     */
    private void buildEscScreen(final Scene scene, final Pane root) {
        final EscScreen escScreen = new EscScreen();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
                if (root.getChildren().contains(escScreen.root())) {
                    root.getChildren().remove(escScreen.root());
                } else {
                    root.getChildren().add(escScreen.root());
                }
            }
        });
    }

    /**
     * Flag for caching the scene variable.
     * It should only be used in scene() method.
     */
    private boolean sceneBuilt;

    /**
     * It will be instantiated via scene() method and will be cached.
     * It should only be used in scene() method.
     */
    private Scene rawScene;
}
