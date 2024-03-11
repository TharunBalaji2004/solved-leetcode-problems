class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = ""
        d = dict()

        for ch in s:
            d[ch] = d.get(ch, 0) + 1
        
        for ch in order:
            if (ch in d):
                res += ch * d[ch]
                del d[ch]
        
        for ch, freq in d.items():
            res += ch * freq

        return res