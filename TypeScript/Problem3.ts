function lengthOfLongestSubstring(s: string): number {
    let substring = "";
    let longest = 0;

    for(let i = 0; i<= s.length; i++)
    {
        if(substring.includes(s[i]))
        {
            if(substring.length > longest)
            {
                longest = substring.length;
                substring = s[i];
            }
        }
        else
        {
            substring+=s[i];
        }
    }
    return longest;
};