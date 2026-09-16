class Solution:
    def isPalindrome(self, s: str) -> bool:
        final = ""
        for i in range(len(s)):
            if s[i].isalnum():
                final += s[i].lower()
        return final == final[::-1]