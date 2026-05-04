//we take hashmap with key:value pair and pair up
// like for each index we can take difference between the target - val and store it in key value
//pair and for the pair with which it matches key val then return the value 

class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer , Integer> indices = new HashMap<>();

       for(int i = 0; i < nums.length; i++){
        indices.put(nums[i], i);
       }

       for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[]{i, indices.get(diff)};
            }
        }

        return new int[0];
    }
}
