package com.homework.mower.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public enum Direction {
    
  NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
  
  private final String id;

  Direction(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public static List<Direction> orientations() {
    return new ArrayList<>(EnumSet.of(NORTH, EAST, SOUTH, WEST));
  }

  public static Optional<Direction> valueById(String value) {
    return Arrays.stream(values())
        .filter(i -> i.id.equals(value))
        .findFirst();
  }

}
