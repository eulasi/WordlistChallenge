package com.example.wordlistchallenge

class Solution {
    fun spellChecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        /* For Matching words */
        // Set that contains all the words in the wordlist
        val exactMatch = wordlist.toSet()
        // map where the keys are the lowercase versions of the words in the wordlist, and the values are the original words.
        val caseInsensitiveMap = mutableMapOf<String, String>()
        // keys are the lowercase versions of the words with all vowels replaced by a placeholder "*" and the values are the original words
        val vowelErrorMap = mutableMapOf<String, String>()

        // populate caseInsensitiveMap and vowelErrorMap with the words from the wordlist.
        // use putIfAbsent to ensure the first occurrence of a word is stored in the case of multiple matches.
        for (word in wordlist) {
            val lowerCaseWordKey = word.lowercase()
            caseInsensitiveMap.putIfAbsent(lowerCaseWordKey, word)

            val vowelErrorKey = lowerCaseWordKey.replace(Regex("[aeiou]"), " ")
            vowelErrorMap.putIfAbsent(vowelErrorKey, word)

        }

        // Iterate through the queries and perform the spell check
        return queries.map { query ->
            when {
                exactMatch.contains(
                    query
                ) -> query

                caseInsensitiveMap.containsKey(
                    query.lowercase()
                ) -> caseInsensitiveMap[query.lowercase()]!!

                vowelErrorMap.containsKey(
                    query.lowercase().replace(Regex("[aeiou]"), " ")
                ) -> vowelErrorMap[query.lowercase().replace(Regex("[aeiou]"), " ")]!!

                else -> ""
            }
        }.toTypedArray()
    }
}
