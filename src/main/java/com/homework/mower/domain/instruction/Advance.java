package com.homework.mower.domain.instruction;

import java.util.logging.Logger;

import com.homework.mower.domain.Direction;
import com.homework.mower.domain.Lawn;
import com.homework.mower.domain.Mower;
import com.homework.mower.domain.Position;

public class Advance implements Instruction {

  private final static Logger log = Logger.getLogger(Advance.class.getName());
  
  @Override
  public Mower apply(Mower mower, Lawn lawn) {
    if(!checkLawnBorn(mower, lawn))
      return mower.move();

    log.warning("Can not move beyond the bounds");
    return mower;
  }

  private Boolean checkLawnBorn(Mower mower, Lawn lawn) {
    Position position = mower.getPosition();

    return (position.getX() == lawn.getUpOrdinate() && mower.getDirection().equals(Direction.EAST)) ||
      (position.getX() == 0 && mower.getDirection().equals(Direction.WEST)) ||
      (position.getY() == lawn.getRightAbscissa() && mower.getDirection().equals(Direction.NORTH)) ||
      (position.getY() == 0 && mower.getDirection().equals(Direction.SOUTH));
  }

}
