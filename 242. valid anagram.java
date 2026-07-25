class Solution {
    public boolean isAnagram(String s, String t) {
        // Anagrams must be of equal length
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency counter for 'a' through 'z'
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all character counts returned to zero
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
