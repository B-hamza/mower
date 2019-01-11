package com.homework.mower.domain.instruction;

import java.util.Optional;
import java.util.function.Function;

import com.homework.mower.domain.Lawn;
import com.homework.mower.domain.Mower;

@FunctionalInterface
public interface Instruction {
  
  public Mower apply(Mower mower, Lawn lawn);

  default Instruction andThen(Instruction instruction) {
    return (mower, lawn) -> instruction.apply(apply(mower, lawn), lawn);
  }

}
