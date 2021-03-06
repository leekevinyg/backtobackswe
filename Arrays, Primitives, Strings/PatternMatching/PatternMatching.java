/*
  Find and Replace Pattern - LeetCode: https://leetcode.com/problems/find-and-replace-pattern/
  This code passes all Leetcode test cases as of Nov. 22 2019
*/

public List<String> findAndReplacePattern(String[] words, String pattern) {
  List<String> matches = new ArrayList<>();

  for (String word: words) {
    if (isAligned(word, pattern)) {
      matches.add(word);
    }
  }

  return matches;
}

private boolean isAligned(String word, String pattern) {
  if (word.length() != pattern.length()) {
    return false;
  }

  // See https://www.ascii-code.com/ for ascii values
  int[] wordToPattern = new int[256];
  int[] patternToWord = new int[256];

  // Every step we build a cross mapping and see if it breaks
  for (int i = 0; i < word.length(); i++) {
    int wordChar = Character.getNumericValue(word.charAt(i));
    int patternChar = Character.getNumericValue(pattern.charAt(i));

    if (wordToPattern[wordChar] == 0) {
      wordToPattern[wordChar] = patternChar;
    }

    if (patternToWord[patternChar] == 0) {
      patternToWord[patternChar] = wordChar;
    }

    if (
      wordToPattern[wordChar] != patternChar ||
      patternToWord[patternChar] != wordChar
    ) {
      return false;
    }
  }

  return true;
}
