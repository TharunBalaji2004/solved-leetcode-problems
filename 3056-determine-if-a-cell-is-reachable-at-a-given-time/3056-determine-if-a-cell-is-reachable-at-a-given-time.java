class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diffx = Math.abs(fx - sx);
        int diffy = Math.abs(fy - sy);

        if (diffx == 0 && diffy == 0 && t == 1) return false;

        return Math.max(diffx, diffy) <= t;
    }
}