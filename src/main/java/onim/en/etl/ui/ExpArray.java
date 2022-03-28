package onim.en.etl.ui;

public class ExpArray {

  private static int[] EXP_LIST = new int[] {
      48, // 0 -> 1
      110,
      204,
      331,
      492,
      690, // 5 -> 6
      926,
      1201,
      1515,
      1870,
      2267, // 10 -> 11
      2706,
      3188,
      3714,
      4285,
      4900, // 15 -> 16
      5561,
      6268,
      7021,
      7822,
      8670, // 20 -> 21
      9567,
      10512,
      11505,
      12548,
      13641, // 25 -> 26
      14784,
      15977,
      17221,
      18517,
      19864, // 30 -> 31
      21263,
      22714,
      24217,
      25774,
      27383, // 35 -> 36
      29046,
      30763,
      32534,
      34359,
      36238, // 40 -> 41
      38172,
      40162,
      42207,
      44307,
      46463, // 45 -> 46
      48676,
      50945,
      53270,
      55652,
      58091, // 50 -> 51
      60587,
      63141,
      65753,
      68422,
      71150, // 55 -> 56
      73936,
      76780,
      79683,
      82646,
      85667, // 60 -> 61
      88747,
      91888,
      95087,
      98347,
      101667, // 65 -> 66
      105047,
      108488,
      111989,
      115551,
      119174, // 70 ->71
      122858,
      126603,
      130410,
      134278,
      138209, // 75 -> 76
      142201,
      146256,
      150372,
      154552,
      158793
  };

  public static int ExpArrays(int level, int exp, int reinc) {
    if (reinc > 7 && level != 80) {
      return (int) (EXP_LIST[level] * 1.7 - exp);
    } else if (level >= 80) {
      return 0;
    } else {
      return (int) (Math.round(EXP_LIST[level] * (reinc * 0.07 + 1.0) - exp));
    }
  }
}
