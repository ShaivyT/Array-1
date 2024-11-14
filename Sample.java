// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return new int[]{};

        int[] result = new int[n];
        int rp = 1;
        result[0] = rp;

        //left product
        for(int i = 1; i < n; i++) {

            rp = rp * nums[i - 1];
            result[i] = rp;
        }
        // right product
        rp = 1;
        for(int i = n - 2; i >= 0; i--) {

            rp = rp * nums[i + 1];
            result[i] = result[i] * rp;
        }

        return result;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        boolean direction = true;
        int[] result = new int[m * n];
        int r = 0, c = 0;

        for(int i = 0; i < m * n; i++) {
            
            result[i] = mat[r][c]; 
            
            if(direction) {
                if(c == n - 1) {
                    r++;
                    direction = false;
                } else if(r == 0) {
                    c++;
                    direction = false;
                } else {
                    r--;
                    c++;
                }
            } else {
                if(r == m - 1) {
                    c++;
                    direction = true;
                } else if(c == 0) {
                    r++;
                    direction = true;
                } else {
                    r++;
                    c--;
                }
            }  
        }

        return result;
    }
}
