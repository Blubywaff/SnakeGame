// Alex Beamer
// December 17, 2019
// Galleta Games and Software

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGameApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private GraphicsContext gc;
    /*private*/ int[] screenSize = {900, 900};
    /*private*/ int[] size = {30, 30};
    public static SnakeGameApplication self;

    @Override
    public void start(Stage primaryStage) throws Exception {
        self = this;
        primaryStage.setTitle("Snake Game");
        Group group = new Group();
        Canvas canvas = new Canvas(screenSize[0], screenSize[1]);
        gc = canvas.getGraphicsContext2D();
        group.getChildren().add(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        paint(gc);
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
    }

}
