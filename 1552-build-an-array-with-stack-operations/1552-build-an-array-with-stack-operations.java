class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (currentIndex >= target.length) {
                break;
            }

            if (target[currentIndex] == i) {
          
                operations.add("Push");
                currentIndex++;
            } else {
                
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;
    }
}