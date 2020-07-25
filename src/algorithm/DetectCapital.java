package algorithm;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *  1.All letters in this word are capitals, like "USA"
 *  2.All letters in this word are not capitals, like "leetcode".
 *  3.Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        boolean match1 = true, match2 = true, match3 = true;

        // case 1: All capital
        for(int i = 0; i < n; i++) {
            if(!Character.isUpperCase(word.charAt(i))) {
                match1 = false;
                break;
            }
        }
        if(match1) {
            return true;
        }

        // case 2: All not capital
        for(int i = 0; i < n; i++) {
            if(!Character.isLowerCase(word.charAt(i))) {
                match2 = false;
                break;
            }
        }
        if(match2) {
            return true;
        }
        // case 3: All not capital except first
        if(!Character.isUpperCase(word.charAt(0))) {
            match3 = false;
        }
        if(match3) {
            for(int i = 1; i < n; i++) {
                if(Character.isLowerCase(word.charAt(i))) {
                    match3 = false;
                    break;
                }
            }
        }
        if(match3) {
            return true;
        }
        // if not matching
        return false;
    }

    public boolean detectCapitalUseV2(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        // case 1: All capital
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
           for (int i = 2; i < n; i++) {
               if (Character.isLowerCase(word.charAt(i))) {
                   return false;
               }
           }
        // case 2 and case 3
        } else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        // if pass one of the cases
        return true;
    }

    public boolean detectCapitalUseV3(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
