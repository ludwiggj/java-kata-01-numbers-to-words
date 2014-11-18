package com.bt.numberstowords;

public class NumbersToWords {

  private static final String[] units = new String[]{
      "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
  };

  public static String convert(int number) {
    if (number > 999999) {
      throw new IllegalArgumentException("");
    }

    int lastThreeNumbers = number % 1000;
    String lastThreeDigits = threeDigitGroup(lastThreeNumbers);

    String thousandDigits = thousandDigits(number);

    if (thousandDigits.equals("")) {
      return lastThreeDigits;
    }

    if (lastThreeDigits.equals("zero")) {
      return thousandDigits;
    }

    if (numberIsLowerThanOneHundred(lastThreeNumbers)) {
      return thousandDigits + " and " + lastThreeDigits;
    } else {
      return thousandDigits + " " + lastThreeDigits;
    }
  }

  private static String thousandDigits(int number) {
    int thousands = number / 1000;
    return (thousands > 0) ? threeDigitGroup(thousands) + " thousand" : "";
  }

  private static String threeDigitGroup(int number) {
    if (numberIsLowerThanOneHundred(number)) {
      return numberLessThanOneHundred(number);
    } else {
      return threeDigitNumber(number);
    }
  }

  private static boolean numberIsLowerThanTwenty(int number) {
    return number < 20;
  }

  private static boolean numberIsLowerThanOneHundred(int number) {
    return number < 100;
  }

  private static String numberLessThanOneHundred(int number) {
    if (numberIsLowerThanTwenty(number)) {
      return zeroToNineteen(number);
    } else {
      return twoDigitNumber(number);
    }
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

  private static String twoDigitNumber(int number) {
    String lastDigit = numberLessThanOneHundred(number % 10);
    String remainder = lastDigit.equals("zero") ? "" : "-" + lastDigit;

    return tens(number) + remainder;
  }

  private static String tens(int number) {
    final String[] tens = new String[]{
        "Not Used", "Not Used", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    return tens[number / 10];
  }

  private static String threeDigitNumber(int number) {
    String lastTwoDigits = numberLessThanOneHundred(number % 100);
    String remainder = lastTwoDigits.equals("zero") ? "" : " and " + lastTwoDigits;

    return hundreds(number) + remainder;
  }

  private static String hundreds(int number) {
    return units[number / 100] + " hundred";
  }
}