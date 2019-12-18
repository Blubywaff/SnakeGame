// Alex Beamer
// December 17, 2019
// Galleta Games and Software

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.DISCARDING;

public class SnakeGameApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private GraphicsContext gc;
    /*private*/ int[] screenSize = {900, 900};
    /*private*/ int[] size = {30, 30};
    public static SnakeGameApplication self;
    private Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        self = this;
        primaryStage.setTitle("Snake Game");
        Group group = new Group();
        Canvas canvas = new Canvas(screenSize[0], screenSize[1]);
        gc = canvas.getGraphicsContext2D();
        canvas.setOnKeyPressed(this::keyPressed);
        group.getChildren().add(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        game = new Game();
        canvas.requestFocus();
        primaryStage.show();
        paint(gc);
    }

    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getText().equals("r")) {
            game.stop();
            game = new Game();
            update();
        }
        game.keyPressed(keyEvent);
    }

    private void paint(GraphicsContext g) {
        g.setFill(Color.color(0.2, 0.2, 0.2));
        g.fillRect(0, 0, screenSize[0], screenSize[1]);
        g.setStroke(Color.color(0.3, 0.3, 0.3));
        g.setLineWidth(2);
        for(int x = screenSize[0]/size[0]; x < screenSize[0]; x += screenSize[0]/size[0]) {
            g.strokeLine(x, 0, x, screenSize[1]);
        }
        for(int y = screenSize[1]/size[1]; y < screenSize[1]; y += screenSize[1]/size[1]) {
            g.strokeLine(0, y, screenSize[1], y);
        }

        g.setFill(Color.color(0.7, 0.7, 0.7));
        SnakeBody current = game.getSnake().getHead();
        while(current != null) {
            if(current == game.getSnake().getHead()) {
                g.setFill(Color.GREEN);
                if(game.getStatus() == Game.LOST) {
                    g.setFill(Color.RED);
                }
            } else {
                g.setFill(Color.color(0.7, 0.7, 0.7));
            }

            int xOff = 1, yOff = 1, xSmall = -2, ySmall = -2;
            if(current == game.getSnake().getHead());
            else if(current.getDirection() == Direction.UP) {
                yOff = -1;
                ySmall = 0;
            } else if(current.getDirection() == Direction.RIGHT) {
                xOff = 1;
                xSmall = 1;
            } else if(current.getDirection() == Direction.DOWN) {
                yOff = 1;
                ySmall = 0;
            } else if(current.getDirection() == Direction.LEFT) {
                xOff = -1;
                xSmall = 0;
            }
            g.fillRect(current.getLocation().getX() * (screenSize[0]/size[0])+xOff, current.getLocation().getY() * (screenSize[1]/size[1])+yOff, (screenSize[0]/size[0])+xSmall, (screenSize[1]/size[1])+ySmall);
            current = current.getNext();
        }

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        game.timer.end();
    }

    public void update() {
        paint(gc);
    }

}
