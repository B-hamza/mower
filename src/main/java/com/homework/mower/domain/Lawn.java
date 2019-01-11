package com.homework.mower.domain;

public class Lawn extends Position {

  public Lawn(int upOrdinate, int rightAbscissa) {
    super(upOrdinate, rightAbscissa);
  }

  public int getUpOrdinate() {
    return super.getX();
  }

  public int getRightAbscissa() {
    return super.getY();
  }

}
