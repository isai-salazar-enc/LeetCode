function isMatch(s: string, p: string): boolean {
    p.replace(".","[a-z]");
    const regExp = "^" + p + "$"
    
    if(s.match(RegExp(regExp)))    
        return true

    return false  
};