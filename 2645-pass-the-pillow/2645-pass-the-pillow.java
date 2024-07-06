class Solution {
    public int passThePillow(int n, int time) {
        // time / (n-1) steps require fullPass
        int fullPass = time / (n - 1);
        // time % (n-1) steps remaining after fullPass
        int extraPass = time % (n - 1);
        
        // If fullPass is even, then pillow is at (extraPass + 1) position
        if (fullPass % 2 == 0) return extraPass + 1;
        // If fullPass is odd, then pillow is at (n - extraPass) position
        return (n - extraPass);
    }   
}