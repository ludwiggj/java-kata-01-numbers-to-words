package com.bt.numberstowords;

public class NumbersToWords {

  private static final String[] units = new String[]{
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
  };

  public static String convert(int number) {
    if (numberIsLowerThanTwenty(number)) {
      return zeroToNineteen(number);
    }

    if (numberIsLowerThanOneHundred(number)) {
      return twoDigitNumber(number);
    }

    if (numberIsLowerThanOneThousand(number)) {
      return units[number / 100] + " hundred";
    }

    return "Cannot convert number";
  }

  private static boolean numberIsLowerThanTwenty(int number) {
    return number < 20;
  }

  private static String zeroToNineteen(int number) {
    final String[] tenToNineteen = new String[]{
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen"
    };

    final String[][] zeroToNineteen = new String[][]{
        units, tenToNineteen
    };

    return zeroToNineteen[number / 10][number % 10];
  }

  private static boolean numberIsLowerThanOneHundred(int number) {
    return number < 100;
  }

  private static String twoDigitNumber(int number) {
    return tens(number) + remainingUnits(number);
  }

  private static String tens(int number) {
    final String[] tens = new String[]{
        "Not Used", "Not Used", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    return tens[number / 10];
  }

  private static String remainingUnits(int number) {
    final String[] remainingUnits = new String[]{
        "", "-one", "-two", "-three", "-four", "-five", "-six", "-seven", "-eight", "-nine"
    };
    return remainingUnits[number % 10];
  }

  private static boolean numberIsLowerThanOneThousand(int number) {
    return number < 1000;
  }
}