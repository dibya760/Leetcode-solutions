 import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Move left pointer past the last seen duplicate character
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Store or update the character's latest index
            map.put(currentChar, right);
            
            // Calculate window size and update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
