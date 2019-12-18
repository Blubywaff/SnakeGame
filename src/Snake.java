// Alex Beamer
// December 17, 2019
// Galleta Games and Software

public class Snake {

    private SnakeBody head;
    private static int startSize = 20;

    public Snake() {
        Point point = new Point((int)(Math.random()*(SnakeGameApplication.self.size[0]-2)+1), (int)(Math.random()*(SnakeGameApplication.self.size[1]-2)+1));
        int dir = Direction.UP;
        if(point.getX() < SnakeGameApplication.self.size[0]/2) {
            dir = Direction.RIGHT;
        } else {
            dir = Direction.LEFT;
        }
        head = new SnakeBody(point, dir, startSize);
    }

    public Snake(Point location, int direction) {
        head = new SnakeBody(location, direction, startSize);
    }

    private boolean isValidMove(int direction) {
        if((direction == Direction.UP && head.getLocation().getY() == 0) || (direction == Direction.RIGHT && head.getLocation().getX() == SnakeGameApplication.self.size[0]-1) || (direction == Direction.DOWN && head.getLocation().getY() == SnakeGameApplication.self.size[1]-1) || (direction == Direction.LEFT && head.getLocation().getX() == 0)) {
            return false;
        }
        SnakeBody current = head.getNext();
        while(current != null && current.getNext() != null) {
            if((direction == Direction.UP && head.getLocation().getX() == current.getLocation().getX() && head.getLocation().getY()-1 == current.getLocation().getY()) || (direction == Direction.RIGHT && head.getLocation().getY() == current.getLocation().getY() && head.getLocation().getX()+1 == current.getLocation().getX()) || (direction == Direction.DOWN && head.getLocation().getX() == current.getLocation().getX() && head.getLocation().getY()+1 == current.getLocation().getY()) || (direction == Direction.LEFT && head.getLocation().getY() == current.getLocation().getY() && head.getLocation().getX()-1 == current.getLocation().getX())) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /*private boolean isDead() {
        SnakeBody current = head.getNext();
        while(current != null) {

        }
        return false;
    }*/


    /*
     * Shouldn't really be used
     * @param direction
     * @return
     *//*
    public boolean move(int direction) {
        //System.out.println(isValidMove(direction));
        if(!isValidMove(direction)) {
            return false;
        }
        head.move(direction);
        return true;
    }*/

    public boolean move() {
        if(!isValidMove(head.getDirection())) {
            return false;
        }
        head.move();
        return true;
    }

    public void setDirection(int direction) {
        head.setDirection(direction);
    }

    public SnakeBody getHead() {
        return head;
    }

}
