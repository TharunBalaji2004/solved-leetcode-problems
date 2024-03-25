class Solution:
    def winnerOfGame(self, colors: str) -> bool:
        alice, bob = 0, 0

        for i in range(2, len(colors)):
            if (colors[i-2]+colors[i-1]+colors[i] == "AAA"):
                alice += 1
            if (colors[i-2]+colors[i-1]+colors[i] == "BBB"):
                bob += 1
        
        if (alice > bob):
            return True

        return False