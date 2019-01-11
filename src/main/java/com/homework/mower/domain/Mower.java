package com.homework.mower.domain;

public class Mower {
    
  private final Position position;
  private final Direction direction;

  public Mower(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Mower move() {
    Position newPosition = moveToPosition(direction);
    return new Mower(newPosition, direction);
  }

  public Mower turnRight() {
    Direction newDirection = Direction.orientations().get((Direction.orientations().indexOf(direction) + 1) % 4);
    return new Mower(position, newDirection);
  }

  public Mower turnLeft() {
    Direction newDirection = Direction.orientations().get((Direction.orientations().indexOf(direction) + 3) % 4);
    return new Mower(position, newDirection);
  }

  private Position moveToPosition(Direction direction) {
    switch(direction) {
      case NORTH : return new Position(position.getX(), position.getY() + 1);
      case SOUTH : return new Position(position.getX(), position.getY() - 1);
      case WEST : return new Position(position.getX() - 1, position.getY());
      case EAST : return new Position(position.getX() + 1, position.getY());
      default : return position;
    }
  }

  public Position getPosition() {
    return position;
  }

  public Direction getDirection() {
    return direction;
  }

  public String toString() {
    return position.getX() + " " + position.getY() + " " + direction.getId();
  }

  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Mower mower = (Mower) object;

    return position.equals(mower.position) &&
            direction.equals(mower.direction);
  }

  public int hashCode() {
    return java.util.Objects.hash(super.hashCode(), position, direction);
  }
}
