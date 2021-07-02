package jp.co.supply_net.game.othello.board;

import java.util.List;

import jp.co.supply_net.game.othello.gameMaster.OtheloBoard;
import jp.co.supply_net.game.othello.gameMaster.StoneType;

public class Board implements OtheloBoard {

  // ゲーム実行中フラグ
  private boolean game = true;

  // オセロ版に対応した多次元配列
  private StoneType[][] board;

  // static final String EMPTY = " ";
  // static final String BLACK = "●";
  // static final String WHITE = "○";

  // String stone;
  // String rev_stone;

  private void initialize() {

    // オセロ版の要素を全てクリアする
    for (int x = 0; x < 8; x++) {

      for (int y = 0; y < 8; y++) {

        board[x][y] = StoneType.EMPTY;

      }

    }

    // 初期状態の配置
    board[3][3] = StoneType.BLACK;
    board[3][4] = StoneType.WHITE;
    board[4][3] = StoneType.WHITE;
    board[4][4] = StoneType.BLACK;

    // 次うつ駒の色を指定
    // stone = StoneType.BLACK;
    // rev_stone = StoneType.WHITE;

    // ゲーム実行中フラグ
    // game = true;

  }

  // private void showBoard() {

  // //まだ空いている座標があるか
  // int existempty = 0;
  // //黒い駒の数集計用
  // int cnt_black = 0;
  // //白い駒の数集計用
  // int cnt_white = 0;

  // //オセロ版を描写する
  // int i = 0;
  // System.out.println(" |0 |1 |2 |3 |4 |5 |6 |7 |");
  // System.out.println("――――――――――――――");
  // for (String[] sarr : board) {

  // System.out.print(i + " |");
  // for (String s : sarr) {

  // System.out.print(s);
  // System.out.print("|");

  // //空いている座標があるか、各駒数の集計
  // if (s.equals(EMPTY)) {
  // existempty = true;
  // } else if (s.equals(BLACK)) {
  // cnt_black++;
  // } else if (s.equals(WHITE)) {
  // cnt_white++;
  // }

  // }
  // System.out.println();
  // System.out.println("――――――――――――――");

  // i++;

  // }

  // System.out.println(BLACK + ":" + cnt_black);
  // System.out.println(WHITE + ":" + cnt_white);
  // System.out.println("――――――――――――――");

  // if (existempty) {

  // System.out.println(stone + "のターンです");
  // } else {
  // System.out.println(stone + "ゲーム終了！");
  // game = false;
  // }

  // }

  private void setStone(int x, int y, StoneType stone) {

    // 版外の座標を指定した場合
    if (x > 7 || y > 7) {
      System.out.println("その位置に駒はおけません");
    }

    // 駒を配置できる場合
    if (board[y][x].equals(StoneType.EMPTY)) {
      board[y][x] = stone;

      // ひっくり返す処理
      turnStone(x, y, stone);

      // // 次うつ駒の設定
      // String next_rev_storn = stone;
      // stone = rev_stone;
      // rev_stone = next_rev_storn;

      // オセロ版の描写
      // showBoard();

    } else {

      // 既に駒がおいてある位置を指定した場合
      System.out.println("その位置に駒はおけません");
    }

  }

  private void turnStone(int x, int y, StoneType stoneType) {

    StoneType stone = stoneType;
    StoneType rev_stone = stone == StoneType.WHITE ? StoneType.BLACK : StoneType.WHITE;
    // 8方向の駒の配置を確認し、ひっくり返す

    turnLeftUp(x, y, stone, rev_stone);
    turnUp(x, y, stone, rev_stone);
    turnRightUp(x, y, stone, rev_stone);
    turnLeft(x, y, stone, rev_stone);
    turnRight(x, y, stone, rev_stone);
    turnLeftDown(x, y, stone, rev_stone);
    turnDown(x, y, stone, rev_stone);
    turnRightDown(x, y, stone, rev_stone);

  }

  private void turnLeftUp(int x, int y, StoneType stone, StoneType rev_stone) {

    if (y > 1 && x > 1) {

      // となりの駒
      StoneType next = board[y - 1][x - 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || y - i < 0 || board[y - i][x - i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y - i][x - i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y - t][x - t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnUp(int x, int y, StoneType stone, StoneType rev_stone) {
    if (y > 1) {

      // となりの駒
      StoneType next = board[y - 1][x];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (y - i < 0 || board[y - i][x].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y - i][x].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y - t][x] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnRightUp(int x, int y, StoneType stone, StoneType rev_stone) {
    if (y > 1 && x < 6) {

      // となりの駒
      StoneType next = board[y - 1][x + 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || y - i < 0 || board[y - i][x + i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y - i][x + i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y - t][x + t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnDown(int x, int y, StoneType stone, StoneType rev_stone) {
    if (y < 6) {

      // となりの駒
      StoneType next = board[y + 1][x];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (y + i > 7 || board[y + i][x].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y + i][x].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y + t][x] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnRight(int x, int y, StoneType stone, StoneType rev_stone) {
    if (x < 6) {

      // となりの駒
      StoneType next = board[y][x + 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || board[y][x + i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y][x + i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y][x + t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnLeftDown(int x, int y, StoneType stone, StoneType rev_stone) {
    if (y < 6 && x > 1) {

      // となりの駒
      StoneType next = board[y + 1][x - 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || y + i > 7 || board[y + i][x - i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y + i][x - i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y + t][x - t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnLeft(int x, int y, StoneType stone, StoneType rev_stone) {
    if (x > 1) {

      // となりの駒
      StoneType next = board[y][x - 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || board[y][x - i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y][x - i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y][x - t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  private void turnRightDown(int x, int y, StoneType stone, StoneType rev_stone) {
    if (y < 6 && x < 6) {

      // となりの駒
      StoneType next = board[y + 1][x + 1];

      // となりの駒が裏駒の場合
      if (next.equals(rev_stone)) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || y + i > 7 || board[y + i][x + i].equals(StoneType.EMPTY)) {
            // 駒がない場合終了
            break;
          } else if (board[y + i][x + i].equals(stone)) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              board[y + t][x + t] = stone;
            }
            break;
          }
        }
      }

    }
  }

  @Override
  public int getWhiteStone() {
    // 白石集計
    int cnt_white = 0;
    int x = board.length;
    int y = board[0].length;

    for (int countx = 0; countx < x; countx++) {
      for (int county = 0; county < y; county++) {
        if (board[countx][county] == StoneType.WHITE) {
          cnt_white = cnt_white + 1;
        }
      }
    }
    return cnt_white;
  }

  @Override
  public int getBlackStone() {
    // 黒石集計
    int cnt_black = 0;
    int x = board.length;
    int y = board[0].length;

    for (int countx = 0; countx < x; countx++) {
      for (int county = 0; county < y; county++) {
        if (board[countx][county] == StoneType.BLACK) {
          cnt_black = cnt_black + 1;
        }
      }
    }
    return cnt_black;
  }

  @Override
  public int getEmptySpace() {
    // 空欄集計
    int cnt_empty = 0;
    int x = board.length;
    int y = board[0].length;

    for (int countx = 0; countx < x; countx++) {
      for (int county = 0; county < y; county++) {
        if (board[countx][county] == StoneType.EMPTY) {
          cnt_empty = cnt_empty + 1;
        }
      }
    }
    return cnt_empty;
  }

  @Override
  public Boolean isPutEnablePosition(int x, int y, StoneType stoneType) {
    // TODO Auto-generated method stub

    // turnStone(x, y, stoneType);

    return true;
  }

  @Override
  public void putStone(int x, int y, StoneType stoneType, List<Grid> gridList) {
    // TODO Auto-generated method stub
    // 二次元配列に変換してsetstoneに渡す
    setStone(x, y, stoneType);

  }

  @Override
  public StoneType[][] getBoardImage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int countTurnStone(int x, int y, StoneType stoneType) {
    // TODO Auto-generated method stub
    return 0;
  }

}
