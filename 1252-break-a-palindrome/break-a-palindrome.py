class Solution:
    def breakPalindrome(self, s: str) -> str:
        if (len(s) == 1):
            return ""

        L = list(s)
        for i in range(0, len(s)//2):
            if (L[i] != "a"):
                L[i] = "a"
                break

        print(L)
        if (L == L[::-1]):
            L[-1] = "b"
            return "".join(L)

        return "".join(L)