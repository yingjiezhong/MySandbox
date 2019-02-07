package dynamicProgramming;

import java.util.*;

public class WordBreak {
    private static boolean solution(String s, List<String> wordDict) {

        Set<String> dict = new TreeSet(wordDict);
        WordTree root = new WordTree(s, 0, 0, dict);

        buildTree(root);

        return findSolution(root);
    }

    private static boolean findSolution(WordTree node) {

        if (node.children.size() == 0) {
            if (node.end == node.word.length()) {
                System.out.println("last word is: " + node);
                return true;
            }
        }

        if (node.children.size() > 0) {
            Collection<WordTree> children = node.children.values();
            for (WordTree c : children) {
                return findSolution(c);
            }
        }

        return false;

    }

    private static void buildTree(WordTree node) {
        node.findAndAddChildren();

        if (node.children.size() > 0) {
            Collection<WordTree> children = node.children.values();
            for (WordTree c : children) {
                buildTree(c);
            }
        }
    }


    public static void main(String[] argv) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(s + ": " + solution(s, wordDict));

        s = "catsanddog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(s + ": " + solution(s, wordDict));
    }

    private static class WordTree {
        private final Set<String> wordDict;
        private final int start;
        private final int end;
        Map<String, WordTree> children = new TreeMap();
        String word;

        /**
         * if the word end position is the length - 1, then it is solved
         *
         * @param word: the word to solve
         * @param start: start position of the word
         * @param end: end position of the word
         * @param wordDict: word dictionary
         */
        public WordTree(String word, int start, int end, Set<String> wordDict) {
            this.word = word;
            this.wordDict = wordDict;
            this.start = start;
            this.end = end;
        }

        /**
         * find the possible words in the dictionary
         * @return
         */
        public void findAndAddChildren() {
            String next = word.substring(end);
            for (String w : wordDict) {
                if (next.startsWith(w)) {
                    children.put(w, new WordTree(word, end, end+w.length(), wordDict));
                }
            }
        }

        public String toString() {
            return word.substring(start, end);
        }
    }
}
