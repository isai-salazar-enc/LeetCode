package Java;

class Solution {
    private Boolean memo[][];

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1]; // Memoization
        return dfs(0,0, s, p);
    }

    public boolean dfs(int stringPointer, int patternPointer, String s, String p){
        // If already calculated, return value
        if (memo[stringPointer][patternPointer] != null) {
            return memo[stringPointer][patternPointer];
        }

        // If both out of bounds, it is a perfect match
        if(stringPointer >= s.length() && patternPointer >= p.length()){
            return true;
        }

        // If only the pattern pointer is out of bounds, it is not a match (part of the string is missing validation)
        if(patternPointer >= p.length()){
            return false;
        }

        // Check if the character is valid (a match or ".")
        boolean match = stringPointer < s.length() && (s.charAt(stringPointer) == p.charAt(patternPointer) || p.charAt(patternPointer) == '.'); 

        // Check if there's a star loop
        if( patternPointer+1 < p.length() && p.charAt(patternPointer+1) == '*'){
            // If there is not a match, move pattern pointer 2 positions and continue. 
            // If there is a match, move stringPointer 1 position and continue using the star
            // But we have to check both because of test cases like "p = a*a, s = aaa", where it is the same letter but we are not using the star. -> This is the action that makes memoization necessary
            memo[stringPointer][patternPointer] = (dfs(stringPointer, patternPointer + 2, s, p) || (match && dfs(stringPointer + 1, patternPointer, s, p)));

            return memo[stringPointer][patternPointer];
        }

        // If not loop but match, move stringPointer
        if(match){
            memo[stringPointer][patternPointer] = (dfs(stringPointer+1, patternPointer+1, s, p));
            return memo[stringPointer][patternPointer];
        }

        // If not loop and not match
        memo[stringPointer][patternPointer] = false;
        return false;
    }
}
