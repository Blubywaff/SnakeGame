// Alex Beamer
// December 17, 2019
// Galleta Games and Software

import javafx.scene.input.KeyEvent;

public class Game {

    public static final int READY = 0, PLAYING = 1, LOST = 2;

    private Snake snake;
    private int status;
    private int score;
    /*private*/ Timer timer;
    private int defaultDelay = 500;

    public Game() {
        snake = new Snake();
        score = 0;
        status = READY;
        timer = new Timer(defaultDelay, snake, this);

    }

    public void keyPressed(KeyEvent keyEvent) {
        if(status == LOST) {
            return;
        }
        String key = keyEvent.getText();
        if(key.equals(" ")) {
            start();
        }
        if(status == READY) {
            return;
        }

        //System.out.println(key);
        if(key.equals("w")) {
            snake.setDirection(Direction.UP);
        } else if(key.equals("d")) {
            snake.setDirection(Direction.RIGHT);
        } else if(key.equals("s")) {
            snake.setDirection(Direction.DOWN);
        } else if(key.equals("a")) {
            snake.setDirection(Direction.LEFT);
        }
    }

    /*public void move(int direction) {
        snake.move(direction);
    }*/

    public void start() {
        timer.start();
        status = PLAYING;
    }

    public void stop() {
        timer.end();
    }

    public void lost() {
        status = LOST;
    }

    public static int getREADY() {
        return READY;
    }

    public static int getPLAYING() {
        return PLAYING;
    }

    public Snake getSnake() {
        return snake;
    }

    public int getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }
}
