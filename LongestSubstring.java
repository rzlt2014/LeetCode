package leetcodeDetail;
import java.util.*;
/*
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring1(String s) {
        char[] cA = s.toCharArray();
        int[] loc = new int[128];
        Arrays.fill(loc, -1);
        int result = 0, start = 0;
        
        for (int i = 0; i < cA.length; i++) {
            if (loc[cA[i] - ' '] >= start) {
                result = Math.max(result, i - start);
                start = loc[cA[i] - ' '] + 1;
            }
            
            loc[cA[i] - ' '] = i;
        }
        
        return result = Math.max(result, cA.length - start);
    }
	
	public int lengthOfLongestSubstring2(String s) {
        char[] cA = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0, start = 0;
        
        for (int i = 0; i < cA.length; i++) {
            if (map.containsKey(cA[i]) && map.get(cA[i]) >= start) {
                result = Math.max(result, i - start);
                start = map.get(cA[i]) + 1;
            }
            map.put(cA[i], i);
        }
        
        return result = Math.max(result, cA.length - start);
    }
	
	public static void main(String[] args) {
		LongestSubstring r = new LongestSubstring();
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(r.lengthOfLongestSubstring1(s));
		System.out.println(r.lengthOfLongestSubstring2(s));
		
	}
}
