class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        special = set()

        for ch in word:
            if (ch.lower() in word and ch.upper() in word):
                special.add(ch.lower())

        return len(special)
        