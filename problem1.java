package LeeCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 两数之和：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 * 可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
 */
public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = in.nextInt();
		}
		int target = in.nextInt();
		in.close();

		Solution solution = new Solution();
		int[] res = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}
}

class Solution {
	// 若不存在这样的两个数，会返回默认的[0, 0],为了避免歧义，在这里设置一个flag。
	public int flag = 0;

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums.length < 2 || nums == null) {
			return res;
		}

		HashMap<Integer, Integer> myMap = new HashMap<>();
		// hashMap查找复杂度为o(1)，以空间换时间。
		for (int i = 0; i < nums.length; i++) {
			if (myMap.get(target - nums[i]) != null) {
				res[0] = myMap.get(target - nums[i]);
				res[1] = i;
				flag = 1;
				break;
			}
			myMap.put(nums[i], i);
		}
		return res;
	}
}
