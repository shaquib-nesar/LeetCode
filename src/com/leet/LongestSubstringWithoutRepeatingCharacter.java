package com.leet;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String string) {

        Set<Character> set = new HashSet<>();
        int globalL = 0, localL = 0;

        for (int e = 0, s = 0; e < string.length(); e++) {
            while (set.contains(string.charAt(e))) {
                set.remove(string.charAt(s++));
                localL--;
            }

            set.add(string.charAt(e));
            localL++;
            globalL = Math.max(globalL, localL);
        }

        return globalL;
    }
}
