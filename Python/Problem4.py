class Solution:
    def __init__(self):
        self.memo = None

    def isMatch(self, s: str, p: str) -> bool:
        # Initialize memoization table
        self.memo = [[None] * (len(p) + 1) for _ in range(len(s) + 1)]
        return self.dfs(0, 0, s, p)

    def dfs(self, stringPointer: int, patternPointer: int, s: str, p: str) -> bool:
        # If already calculated, return the stored value
        if self.memo[stringPointer][patternPointer] is not None:
            return self.memo[stringPointer][patternPointer]

        # If both pointers are out of bounds, it's a match
        if stringPointer >= len(s) and patternPointer >= len(p):
            return True

        # If pattern is out of bounds but string is not, it's not a match
        if patternPointer >= len(p):
            return False

        # Check if current characters match or pattern has '.'
        match = (stringPointer < len(s) and 
                 (s[stringPointer] == p[patternPointer] or p[patternPointer] == '.'))

        # Check if there's a star (*) in the pattern
        if patternPointer + 1 < len(p) and p[patternPointer + 1] == '*':
            # Either skip the star (move pattern pointer by 2) or use the star (move string pointer by 1)
            self.memo[stringPointer][patternPointer] = (
                self.dfs(stringPointer, patternPointer + 2, s, p) or 
                (match and self.dfs(stringPointer + 1, patternPointer, s, p))
            )
            return self.memo[stringPointer][patternPointer]

        # If it's a match, move both pointers
        if match:
            self.memo[stringPointer][patternPointer] = self.dfs(stringPointer + 1, patternPointer + 1, s, p)
            return self.memo[stringPointer][patternPointer]

        # If not a match
        self.memo[stringPointer][patternPointer] = False
        return False
