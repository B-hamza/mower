package com.homework.mower.game;

public class GameError extends RuntimeException {
    
  static final long serialVersionUID = -1;

  public GameError(String error) {
    super(error);
  }

  public GameError(Throwable error) {
    super(error);
  }
}
