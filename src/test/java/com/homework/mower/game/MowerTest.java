package com.homework.mower.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.homework.mower.domain.Direction;
import com.homework.mower.domain.Mower;
import com.homework.mower.domain.Position;

import org.junit.jupiter.api.Test;

public class MowerTest {

  List<F> listMoves = Arrays.asList(new F(new Mower(new Position(1,1), Direction.NORTH), new Mower(new Position(1,2), Direction.NORTH)),
                      new F(new Mower(new Position(1,1), Direction.EAST), new Mower(new Position(2,1), Direction.EAST)),
                      new F(new Mower(new Position(1,1), Direction.SOUTH), new Mower(new Position(1,0), Direction.SOUTH)),
                      new F(new Mower(new Position(1,1), Direction.WEST), new Mower(new Position(0,1), Direction.WEST)));

  @Test
  void shouldMove() {
    listMoves.stream().forEach(f -> 
      assertEquals(f.getStart().move(), f.getFinish())
    );
  }

  @Test
  void shouldTurnRight() {
    assertEquals(new Mower(new Position(0, 0), Direction.NORTH).turnRight(), new Mower(new Position(0, 0), Direction.EAST));
    assertEquals(new Mower(new Position(1, 1), Direction.NORTH).turnLeft(), new Mower(new Position(1, 1), Direction.WEST));

    assertEquals(new Mower(new Position(0, 0), Direction.EAST).turnRight(), new Mower(new Position(0, 0), Direction.SOUTH));
    assertEquals(new Mower(new Position(1, 1), Direction.EAST).turnLeft(), new Mower(new Position(1, 1), Direction.NORTH));

    assertEquals(new Mower(new Position(0, 0), Direction.SOUTH).turnRight(), new Mower(new Position(0, 0), Direction.WEST));
    assertEquals(new Mower(new Position(1, 1), Direction.SOUTH).turnLeft(), new Mower(new Position(1, 1), Direction.EAST));

    assertEquals(new Mower(new Position(0, 0), Direction.WEST).turnRight(), new Mower(new Position(0, 0), Direction.NORTH));
    assertEquals(new Mower(new Position(1, 1), Direction.WEST).turnLeft(), new Mower(new Position(1, 1), Direction.SOUTH));
  }

  @Test
  void shouldTurnLeft() {

  }

  public class F {
    private final Mower start;
    private final Mower finish;

    public F(Mower start, Mower finish) {
      this.start = start;
      this.finish = finish;
    } 

    public Mower getFinish() {
      return finish;
    }

    public Mower getStart() {
      return start;
    }
  }
}
