class Solution:
    def sortSentence(self, s: str) -> str:
        s = s.split()
        L = [""] * len(s)

        for word in s:
            num = int(word[-1])
            L[num-1] = word[:-1]

        return " ".join(L)