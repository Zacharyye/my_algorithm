package algorithm;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not
 * in the list of banned words. It is guaranteed there is at least one word that isn't banned,
 * and that answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation. Words in the
 * paragraph are not case sensitive. The answer is in lowercase.
 */
public class MostCommonWord {
  public String mostCommonWordV1(String paragraph, String[] banned) {
    String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
    String[] words = normalizedStr.split("\\s+");
    Set<String> bannedWords = new HashSet<>();
    for (String word : banned) {
      bannedWords.add(word);
    }

    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      if(!bannedWords.contains(word)) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }
    }
    return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
  }

  public String mostCommonWordV2(String paragraph, String[] banned) {
    Set<String> bannedWords = new HashSet<>();
    for (String word : banned) {
      bannedWords.add(word);
    }
    String ans = "";
    int maxCount = 0;
    Map<String, Integer> wordCount = new HashMap<>();
    StringBuilder wordBuffer = new StringBuilder();
    char[] chars = paragraph.toCharArray();
    for (int p = 0; p < chars.length; ++p) {
      char currChar = chars[p];

      if (Character.isLetter(currChar)) {
        wordBuffer.append(Character.toLowerCase(currChar));
        if (p != chars.length - 1) {
          continue;
        }
      }

      if (wordBuffer.length() > 0) {
        String word = wordBuffer.toString();
        if(!bannedWords.contains(word)) {
          int newCount = wordCount.getOrDefault(word, 0) + 1;
          wordCount.put(word, newCount);
          if (newCount > maxCount) {
            ans = word;
            maxCount = newCount;
          }
        }
        wordBuffer = new StringBuilder();
      }
    }
    return ans;
  }
}
