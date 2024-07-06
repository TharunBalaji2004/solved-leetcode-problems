class Solution:
    def numberOfAlternatingGroups(self, colors: List[int]) -> int:
        n = len(colors)
        colors = colors * 2
        count = 0
        for i in range(0, n):
            if (colors[i] == colors[i+2] and colors[i] != colors[i+1]):
                count += 1

        return count 
