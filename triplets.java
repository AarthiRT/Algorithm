//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.

//Note: The solution set must not contain duplicate triplets.

//For example, given array S = [-1, 0, 1, 2, -1, -4],

//A solution set is:
//[
 // [-1, 0, 1],
 // [-1, -1, 2]
//]


import java.util.*;

public class triplets {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> pair = new ArrayList<>();
		List<Integer> triplets = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					triplets.add(nums[i]);
					triplets.add(nums[j]);
					triplets.add(nums[k]);
					pair.add(triplets);				
					triplets = new ArrayList<>();
					break;
				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					k--;
				}
			}				
		}
		return pair;
	}
}
