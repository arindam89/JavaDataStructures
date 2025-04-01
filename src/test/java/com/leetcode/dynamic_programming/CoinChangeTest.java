package com.datastructures.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import com.leetcode.dynamic_programming.CoinChange;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CoinChange implementation.
 */
public class CoinChangeTest {

    @Test
    void testCoinChangeExample1() {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        assertEquals(3, solution.coinChange(coins, amount));
        // Explanation: 11 = 5 + 5 + 1
    }
    
    @Test
    void testCoinChangeExample2() {
        CoinChange solution = new CoinChange();
        int[] coins = {2};
        int amount = 3;
        
        assertEquals(-1, solution.coinChange(coins, amount));
        // Explanation: 3 cannot be made up by any combination of coin 2
    }
    
    @Test
    void testCoinChangeExample3() {
        CoinChange solution = new CoinChange();
        int[] coins = {1};
        int amount = 0;
        
        assertEquals(0, solution.coinChange(coins, amount));
        // Explanation: No coins needed for amount 0
    }
    
    @Test
    void testCoinChangeImpossible() {
        CoinChange solution = new CoinChange();
        int[] coins = {2, 5, 10};
        int amount = 3;
        
        assertEquals(-1, solution.coinChange(coins, amount));
        // Explanation: Cannot make 3 with any combination of these coins
    }
    
    @Test
    void testCoinChangeSingleCoin() {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 5;
        
        assertEquals(1, solution.coinChange(coins, amount));
        // Explanation: 5 = 5 (single coin)
    }
    
    @Test
    void testCoinChangeLargeAmount() {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5, 10};
        int amount = 100;
        
        assertEquals(10, solution.coinChange(coins, amount));
        // Explanation: 100 = 10*10 (10 coins of value 10)
    }
    
    @Test
    void testCoinChangeMultipleOptions() {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 3, 4, 5};
        int amount = 7;
        
        assertEquals(2, solution.coinChange(coins, amount));
        // Explanation: 7 = 3 + 4 (best option)
    }
    
    @Test
    void testCoinChangeNullCoins() {
        CoinChange solution = new CoinChange();
        int[] coins = null;
        int amount = 5;
        
        assertEquals(-1, solution.coinChange(coins, amount));
    }
    
    @Test
    void testCoinChangeEmptyCoins() {
        CoinChange solution = new CoinChange();
        int[] coins = {};
        int amount = 5;
        
        assertEquals(-1, solution.coinChange(coins, amount));
    }
}