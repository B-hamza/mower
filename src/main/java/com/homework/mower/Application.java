package com.homework.mower;

import java.util.List;

import com.homework.mower.domain.Mower;
import com.homework.mower.game.Game;
import com.homework.mower.game.GameBuilder;

public class Application {
    
  public static void main(String[] args) throws Exception {
    if(args.length == 0 | args.length > 1){
      throw new IllegalArgumentException();
    }

    Game game = new GameBuilder().fromFile(args[0]).build();

    List<Mower> mowers = game.play();
    mowers.stream().forEach(System.out::println);

  }
}
