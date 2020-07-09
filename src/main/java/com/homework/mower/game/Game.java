package com.homework.mower.game;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.homework.mower.domain.Direction;
import com.homework.mower.domain.instruction.Instructions;
import com.homework.mower.domain.instruction.IdentityInstruction;
import com.homework.mower.domain.instruction.Instruction;
import com.homework.mower.domain.Lawn;
import com.homework.mower.domain.Mower;
import com.homework.mower.domain.Position;

public class Game {
  
  private final Lawn lawn;
  private final Map<Mower, Instructions> mowers;

  protected Game(Lawn lawn, Map<Mower, Instructions> mowers) {
    this.lawn = lawn;
    this.mowers = mowers;
  }


  /**
   * 
   * Another way to do this will be => 
   * instructions.getInstructions()
      .stream()
      .reduce(new IdentityInstruction(), (first, second) -> second.andThen(first))
      .apply(mower, lawn);
   */
  private Mower moveMower(Mower mower, Instructions instructions) {
    return instructions.getInstructions()
      .stream()
      .reduce(
        mower, 
        (first, instruction) -> instruction.apply(first, lawn),
        (first, second) -> second
      );
  }

  public List<Mower> play() {
    return mowers.entrySet().stream()
      .map(entry -> moveMower(entry.getKey(), entry.getValue()))
      .collect(Collectors.toList());
  }

}
