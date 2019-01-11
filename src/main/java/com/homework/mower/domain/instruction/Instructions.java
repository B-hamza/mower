package com.homework.mower.domain.instruction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Instructions {
  
  private final List<Instruction> instructions;

  public Instructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public List<Instruction> getInstructions() {
    return instructions;
  }

  public static Instruction valueById(char value) {
    switch(value) {
      case 'F': return new Advance();
      case 'R': return new Right();
      case 'L': return new Left();
      default : throw new IllegalArgumentException("no instruction possible for the value : " + value);
    }
  }
  
}
