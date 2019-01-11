package com.homework.mower.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.homework.mower.domain.Mower;

import org.junit.jupiter.api.Test;

public class GameTest {
  
  List<F> list = Arrays.asList(new F("1 2 N", "5 5" , "LFLFLFLFF", "1 3 N"),
   new F("3 3 E", "5 5" , "FFRFFRFRRF", "5 1 E"),
   new F("0 0 S", "5 5" , "RFFLFFLFF", "2 0 E"));

  @Test
  public void shouldMoveMower() {
    list.stream().forEach(f -> {
      List<Mower> mowerList = new GameBuilder().withLawn(f.getBorne()).withMowerAndInstructions(f.getStart(), f.getInstrusctions()).build().play();
      assertEquals(mowerList.get(0).toString(), f.getFinish());
    });
  }

  public class F {
    private final String start;
    private final String finish;
    private final String borne;
    private final String instrusctions;

    public F(String start, String borne, String instructions, String finish) {
      this.start = start;
      this.finish = finish;
      this.instrusctions = instructions;
      this.borne = borne;
    } 

    public String getFinish() {
      return finish;
    }

    public String getStart() {
      return start;
    }

    public String getInstrusctions() {
      return instrusctions;
    }

    public String getBorne() {
      return borne;
    }
  }
}
