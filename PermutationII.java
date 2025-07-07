// https://leetcode.com/problems/permutations-ii/description/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        solve(nums, result,0);
        return new ArrayList<>(result);
        
    }

    void solve(int [] nums, Set<List<Integer>> result, int index) {

        if(index== nums.length) {
                List<Integer> x = Arrays.stream(nums).boxed().toList();
                result.add(x);
                return;
        }


        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i]==nums[index]) continue;
            swap(nums, index,i);
            solve(nums, result, index+1);
            swap(nums, index,i);
        }
    }

    void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

