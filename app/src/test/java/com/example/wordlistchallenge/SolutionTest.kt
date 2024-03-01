package com.example.wordlistchallenge

import org.junit.Test
import kotlin.test.assertContentEquals

class SolutionTest {
    private val solution = Solution()

    @Test
    // Test case 1: Wordlist contains all queries
    fun testSpellchecker_case1() {
        // Arrange
        val wordlist = arrayOf("yellow")
        val queries = arrayOf("YellOw", "yellow", "yllw")
        val expected = arrayOf("yellow", "yellow", "")
        // Act
        val actual = solution.spellChecker(wordlist, queries)
        // Assert
        assertContentEquals(expected, actual)
    }

    @Test
    // Test case 2: Wordlist contains some queries
    fun testSpellchecker_case2() {
        // Arrange
        val wordlist = arrayOf("Yellow")
        val queries = arrayOf("yellow")
        val expected = arrayOf("Yellow")
        // Act
        val actual = solution.spellChecker(wordlist, queries)
        // Assert
        assertContentEquals(expected, actual)
    }

    @Test
    // Test case 3: Wordlist contains none of the queries
    fun testSpellchecker_case3() {
        // Arrange
        val wordlist = arrayOf("YellOw")
        val queries = arrayOf("yollow", "yeellow", "yllw")
        val expected = arrayOf("YellOw", "", "")
        // Act
        val actual = solution.spellChecker(wordlist, queries)
        // Assert
        assertContentEquals(expected, actual)
    }

}