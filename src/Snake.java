// Alex Beamer
// December 17, 2019
// Galleta Games and Software

public class Snake {

    private SnakeBody head;

    public Snake(Point location, int direction) {
        head = new SnakeBody(location, direction);
    }

    private boolean isValidMove(int direction) {
        return !((direction == Direction.UP && head.getLocation().getY() == 0) || (direction == Direction.RIGHT && head.getLocation().getX() == SnakeGameApplication.self.size[0]-1) || (direction == Direction.DOWN && head.getLocation().getY() == SnakeGameApplication.self.size[1]-1) || (direction == Direction.LEFT && head.getLocation().getX() == 0));
    }

    public boolean move(int direction) {
        if(!isValidMove(direction)) {
            return false;
        }
        head.move(direction);
        return true;
    }

    public SnakeBody getHead() {
        return head;
    }

}
