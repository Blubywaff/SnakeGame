// Alex Beamer
// December 17, 2019
// Galleta Games and Software

public class SnakeBody {

    private Point location;
    private SnakeBody next;

    public SnakeBody(Point point, int direction) {

    }

    public void move(int direction) {
        if(direction == Direction.UP) {
            location.setY(location.getY()-1);
        } else if(direction == Direction.RIGHT) {
            location.setX(location.getX()+1);
        } else if(direction == Direction.DOWN) {
            location.setY(location.getY()+1);
        } else if(direction == Direction.LEFT) {
            location.setX(location.getX()-1);
        }
        if(next != null) {
            next.move(this);
        }
    }

    public void move(SnakeBody snakeBody) {
        location = snakeBody.getLocation().duplicate();
        if(next != null) {
            next.move(this);
        }
    }

    public Point getLocation() {
        return location;
    }

}
