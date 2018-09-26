package LeeCode;

/*
 * 无重复字符的最长子串:
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
import java.util.HashMap;
import java.util.Map;

public class problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = new String();
		string = "abcabcbb";

		Solution3 solution3 = new Solution3();
		System.out.println(solution3.lengthOfLongestSubstring(string));
	}

}

class Solution3 {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = map.get(s.charAt(j));
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}