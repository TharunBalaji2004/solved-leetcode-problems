class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = "aeiouAEIOU"
        arr = [word for word in s if (word in vowels)]
        arr.sort()
        res = ""
        pos = 0
        for word in s:
            if (word in vowels):
                res += arr[pos]
                pos += 1
            else:
                res += word
        return res