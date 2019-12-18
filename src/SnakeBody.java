// Alex Beamer
// December 17, 2019
// Galleta Games and Software

public class SnakeBody {

    private Point location;
    private SnakeBody next;
    private int direction;

    public SnakeBody(Point point, int dir, int startSize) {
        location = point.duplicate();
        direction = dir;
        if(startSize == 1) {
            return;
        }
        next = new SnakeBody(this, dir, startSize-1);
    }

    public SnakeBody(SnakeBody previous, int dir, int startSize) {
        location = previous.getLocation().duplicate();
        direction = dir;
        if(direction == Direction.UP) {
            location.setY(location.getY()+1);
        } else if(direction == Direction.RIGHT) {
            location.setX(location.getX()-1);
        } else if(direction == Direction.DOWN) {
            location.setY(location.getY()-1);
        } else if(direction == Direction.LEFT) {
            location.setX(location.getX()+1);
        }
        if(startSize == 1) {
            return;
        }
        next = new SnakeBody(this, direction, startSize-1);
    }

    private void move(int direction) {
        if(next != null) {
            next.move(this);
        }
        if(direction == Direction.UP) {
            location.setY(location.getY()-1);
        } else if(direction == Direction.RIGHT) {
            location.setX(location.getX()+1);
        } else if(direction == Direction.DOWN) {
            location.setY(location.getY()+1);
        } else if(direction == Direction.LEFT) {
            location.setX(location.getX()-1);
        }
    }

    /**
     * Reserved for head
     */
    public void move() {
        move(direction);
    }

    public void move(SnakeBody snakeBody) {
        if(next != null) {
            next.move(this);
        }
        location = snakeBody.getLocation().duplicate();
        direction = snakeBody.getDirection();

    }

    public Point getLocation() {
        return location;
    }

    public SnakeBody getNext() {
        return next;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int dir) {
        direction = dir;
    }

}
