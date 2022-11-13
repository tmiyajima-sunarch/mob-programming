package com.example.mob.programming.minesweeper;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperService {

  /**
   * マインスイーパーの盤面を表す二次元配列を返す。
   * ボムの箇所には -1 を、その他の箇所には、その周辺のボムの数を数値で返すこと。
   */
  public List<List<Integer>> generate(
    int height,
    int width,
    List<Point> bombs
  ) {
    // TODO: ここを実装
    return List.of(
      List.of(0, 1, -1, 2, 1, 1, 2, -1),
      List.of(1, 2, 1, 2, -1, 1, 2, -1),
      List.of(-1, 1, 0, 1, 1, 1, 1, 1),
      List.of(1, 2, 1, 1, 0, 1, 1, 1),
      List.of(0, 1, -1, 1, 0, 1, -1, 1)
    );
  }
}
