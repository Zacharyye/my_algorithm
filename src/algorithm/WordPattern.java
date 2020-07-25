package algorithm;

import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter
 * in pattern and a non-empty word in str.
 */
public class WordPattern {
  public boolean wordPatternV1 (String pattern, String str) {
    HashMap<Character, String> map_char = new HashMap<>();
    HashMap<String, Character> map_word = new HashMap<>();
    String[] words = str.split(" ");

    if (words.length != pattern.length()) {
      return false;
    }

    for (int i = 0; i < words.length; i++) {
      char c = pattern.charAt(i);
      String w = words[i];
      if (!map_char.containsKey(c)) {
        if (map_word.containsKey(w)) {
          return false;
        } else {
          map_char.put(c, w);
          map_word.put(w, c);
        }
      } else {
        String mapped_word = map_char.get(c);
        if (!mapped_word.equals(w)) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean wordPatternV2 (String pattern, String str) {
    HashMap map_index = new HashMap();
    String[] words = str.split(" ");

    if (words.length != pattern.length()) {
      return false;
    }

    for (Integer i = 0; i < words.length; i++) {
      char c = pattern.charAt(i);
      String w = words[i];

      if (!map_index.containsKey(c)) {
        map_index.put(c, i);
      }
      if (!map_index.containsKey(w)) {
        map_index.put(w, i);
      }
      if (map_index.get(c) !=  map_index.get(w)) {
        return false;
      }
    }
    return true;
  }
}
