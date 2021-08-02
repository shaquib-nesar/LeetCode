package com.leet;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();

        insertFirst(root, strs[0]);

        int lcs = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            lcs = Math.min(lcs, checkLCS(root, strs[i]));
        }
        
        if (lcs == 0) return "";
        return strs[0].substring(0, lcs);

    }

    class Trie {
        Trie[] child = new Trie[26];

        public Trie() {
            for (int i = 0; i < 26; i++)
                child[i] = null;
        }
    }

    public void insertFirst(Trie root, String s) {
        Trie temp = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (temp.child[index] == null) {
                temp.child[index] = new Trie();
            }
            temp = temp.child[index];
        }
    }

    public int checkLCS(Trie root, String s) {
        Trie temp = root;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (temp.child[index] == null) {
                return i;
            }
            temp = temp.child[index];
        }
        return s.length();
    }

}
