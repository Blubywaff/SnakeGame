// Alex Beamer
// December 18, 2019
// Galleta Games and Software

public class Timer extends Thread {

    private int delay;
    private boolean isRunning;
    private Snake snake;
    private Game game;

    public Timer(int delay, Snake snake1, Game g) {
        this.delay = delay;
        snake = snake1;
        game = g;
    }

    @Override
    public void run() {
        super.run();
        isRunning = true;
        try {
            Thread.sleep(1000);
        } catch(Exception e){}
        while(isRunning) {
            //System.out.println(snake.getHead().getDirection());
            if(!snake.move()) {
                game.lost();
            }
            SnakeGameApplication.self.update();
            try {
                Thread.sleep(delay);
            } catch(Exception e){}
        }
    }

    public void end() {
        isRunning = false;
    }



}
