package com.homework.mower.domain.instruction;

import com.homework.mower.domain.Lawn;
import com.homework.mower.domain.Mower;

public class Left implements Instruction {

  @Override
  public Mower apply(Mower mower, Lawn lawn) {
    return mower.turnLeft();
  }
  
}
