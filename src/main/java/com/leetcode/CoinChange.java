package com.leetcode;

import java.util.Arrays;

/**
 * LeetCode #322: Coin Change (Medium)
 * 
 * You are given an integer array coins representing coins of different denominations 
 * and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Time Complexity: O(amount * n) where n is the number of coin denominations
 * Space Complexity: O(amount) for the dp array
 */
public class CoinChange {
    
    /**
     * Finds the fewest number of coins needed to make up the given amount.
     * Uses a bottom-up dynamic programming approach.
     * 
     * @param coins array of coin denominations
     * @param amount the target amount
     * @return fewest number of coins needed, or -1 if not possible
     */
    public int coinChange(int[] coins, int amount) {
        // If amount is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }
        
        // If no coins are available, amount cannot be made
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        // dp[i] represents the fewest number of coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Initialize with a value larger than any possible result
        // Since we can have at most 'amount' coins (if all are 1), amount+1 is safe
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 amount requires 0 coins
        dp[0] = 0;
        
        // For each amount from 1 to target amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin denomination
            for (int coin : coins) {
                // If this coin can be used (not larger than current amount)
                // and using it would result in fewer coins
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still the initialized value, amount cannot be made
        return dp[amount] > amount ? -1 : dp[amount];
    }
}