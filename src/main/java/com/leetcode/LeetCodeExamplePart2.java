package com.leetcode;

import java.util.Arrays;
import java.util.List;
import com.leetcode.arrays.TopKFrequentElements;
import com.leetcode.strings.WordBreak;
import com.leetcode.graphs.CourseSchedule;
import com.leetcode.strings.LongestSubstringWithoutRepeatingCharacters;
import com.leetcode.strings.DecodeString;
import com.leetcode.strings.ValidParentheses;
import com.leetcode.design.LRUCacheII;
import com.leetcode.strings.WordDictionary;


/**
 * Extension class for additional LeetCode examples.
 */
public class LeetCodeExamplePart2 {
    
    /**
     * Main method to run examples directly.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        runExample();
    }
    
    /**
     * Runs the example methods for the newly added LeetCode problems.
     */
    public static void runExample() {
        System.out.println("13. Top K Frequent Elements Example:");
        runTopKFrequentElementsExample();
        
        System.out.println("\n14. Word Break Example:");
        runWordBreakExample();
        
        System.out.println("\n15. Course Schedule Example:");
        runCourseScheduleExample();
        
        System.out.println("\n16. Longest Substring Without Repeating Characters Example:");
        runLongestSubstringExample();
        
        System.out.println("\n17. Decode String Example:");
        runDecodeStringExample();
        
        System.out.println("\n18. Valid Parentheses Example:");
        runValidParenthesesExample();
        
        System.out.println("\n19. LRU Cache II Example:");
        runLRUCacheIIExample();
        
        System.out.println("\n20. Word Dictionary Example:");
        runWordDictionaryExample();
    }

    /**
     * Demonstrates the Top K Frequent Elements implementation.
     */
    private static void runTopKFrequentElementsExample() {
        TopKFrequentElements solution = new TopKFrequentElements();
        
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("k: " + k);
        
        int[] result = solution.topKFrequent(nums, k);
        
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
        
        // Using bucket sort approach
        System.out.println("\nUsing bucket sort approach:");
        int[] resultBucketSort = solution.topKFrequentBucketSort(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(resultBucketSort));
    }
    
    /**
     * Demonstrates the Word Break implementation.
     */
    private static void runWordBreakExample() {
        WordBreak solution = new WordBreak();
        
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        
        System.out.println("String: " + s1);
        System.out.println("Word Dictionary: " + wordDict1);
        System.out.println("Can be segmented? " + solution.wordBreak(s1, wordDict1));
        
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        
        System.out.println("\nString: " + s2);
        System.out.println("Word Dictionary: " + wordDict2);
        System.out.println("Can be segmented? " + solution.wordBreak(s2, wordDict2));
        
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        
        System.out.println("\nString: " + s3);
        System.out.println("Word Dictionary: " + wordDict3);
        System.out.println("Can be segmented? " + solution.wordBreak(s3, wordDict3));
    }
    
    /**
     * Demonstrates the Course Schedule implementation.
     */
    private static void runCourseScheduleExample() {
        CourseSchedule solution = new CourseSchedule();
        
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        
        System.out.println("Number of courses: " + numCourses1);
        System.out.println("Prerequisites: " + Arrays.deepToString(prerequisites1));
        System.out.println("Can finish all courses? " + solution.canFinish(numCourses1, prerequisites1));
        
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        
        System.out.println("\nNumber of courses: " + numCourses2);
        System.out.println("Prerequisites: " + Arrays.deepToString(prerequisites2));
        System.out.println("Can finish all courses? " + solution.canFinish(numCourses2, prerequisites2));
    }
    
    /**
     * Demonstrates the Longest Substring Without Repeating Characters implementation.
     */
    private static void runLongestSubstringExample() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        String s1 = "abcabcbb";
        System.out.println("String: " + s1);
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s1));
        
        String s2 = "bbbbb";
        System.out.println("\nString: " + s2);
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s2));
        
        String s3 = "pwwkew";
        System.out.println("\nString: " + s3);
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(s3));
    }
    
    /**
     * Demonstrates the Decode String implementation.
     */
    private static void runDecodeStringExample() {
        DecodeString solution = new DecodeString();
        
        String s1 = "3[a]2[bc]";
        System.out.println("Encoded string: " + s1);
        System.out.println("Decoded string: " + solution.decodeString(s1));
        
        String s2 = "3[a2[c]]";
        System.out.println("\nEncoded string: " + s2);
        System.out.println("Decoded string: " + solution.decodeString(s2));
        
        String s3 = "2[abc]3[cd]ef";
        System.out.println("\nEncoded string: " + s3);
        System.out.println("Decoded string: " + solution.decodeString(s3));
    }
    
    /**
     * Demonstrates the Valid Parentheses implementation.
     */
    private static void runValidParenthesesExample() {
        ValidParentheses solution = new ValidParentheses();
        
        String s1 = "()";
        System.out.println("String: " + s1);
        System.out.println("Is valid? " + solution.isValid(s1));
        
        String s2 = "()[]{}";
        System.out.println("\nString: " + s2);
        System.out.println("Is valid? " + solution.isValid(s2));
        
        String s3 = "(]";
        System.out.println("\nString: " + s3);
        System.out.println("Is valid? " + solution.isValid(s3));
        
        String s4 = "([{}])";
        System.out.println("\nString: " + s4);
        System.out.println("Is valid? " + solution.isValid(s4));
    }
    
    /**
     * Demonstrates the LRU Cache II implementation.
     */
    private static void runLRUCacheIIExample() {
        LRUCacheII lruCache = new LRUCacheII(2);
        
        System.out.println("Create LRU Cache with capacity 2");
        System.out.println("Put (1, 1)");
        lruCache.put(1, 1);
        
        System.out.println("Put (2, 2)");
        lruCache.put(2, 2);
        
        System.out.println("Get key 1: " + lruCache.get(1));  // returns 1
        
        System.out.println("Put (3, 3) - This will evict key 2");
        lruCache.put(3, 3);
        
        System.out.println("Get key 2: " + lruCache.get(2));  // returns -1 (not found)
        
        System.out.println("Put (4, 4) - This will evict key 1");
        lruCache.put(4, 4);
        
        System.out.println("Get key 1: " + lruCache.get(1));  // returns -1 (not found)
        System.out.println("Get key 3: " + lruCache.get(3));  // returns 3
        System.out.println("Get key 4: " + lruCache.get(4));  // returns 4
    }
    
    /**
     * Demonstrates the Word Dictionary implementation.
     */
    private static void runWordDictionaryExample() {
        WordDictionary wordDictionary = new WordDictionary();
        
        System.out.println("Adding words to the dictionary: 'bad', 'dad', 'mad'");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        
        System.out.println("Dictionary state: " + wordDictionary);
        
        System.out.println("\nSearching for 'pad': " + wordDictionary.search("pad"));
        System.out.println("Searching for 'bad': " + wordDictionary.search("bad"));
        System.out.println("Searching for '.ad': " + wordDictionary.search(".ad"));
        System.out.println("Searching for 'b..': " + wordDictionary.search("b.."));
        
        System.out.println("\nAdding more words: 'bat', 'cat', 'rat'");
        wordDictionary.addWord("bat");
        wordDictionary.addWord("cat");
        wordDictionary.addWord("rat");
        
        System.out.println("Dictionary state: " + wordDictionary);
        
        System.out.println("\nAdvanced search tests:");
        System.out.println("Searching for '..t': " + wordDictionary.search("..t"));
        System.out.println("Searching for 'b.t': " + wordDictionary.search("b.t"));
        System.out.println("Searching for '...': " + wordDictionary.search("..."));
        System.out.println("Searching for 'b...': " + wordDictionary.search("b..."));
    }
}