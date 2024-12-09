class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        substring = ""
        longest = 0
        for i in range (0, len(s)):
            if s[i] in substring:
                if len(substring) > longest:
                    longest = len(substring)
                    substring = s[i]
            else:
                substring += s[i]
        return longest
        