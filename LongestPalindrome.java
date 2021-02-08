class LongestPalindrome {
    public String longestPalindrome(String s) {
        
        ArrayList<String> allPalins= new ArrayList<String>();
        int maxLength = 1;
        String palindrome = s.substring(0,1);
        for (Character c: s.toCharArray()) {
            ListIterator<String> iterator = allPalins.listIterator();
            // for(String substring: allPalins ) {
            while(iterator.hasNext()){
                String substring = iterator.next();
                iterator.remove();
                substring = substring+c;
                iterator.add(substring);
                // allPalins.add(substring);
                if(isPalin(substring)) {
                    if(maxLength<substring.length()) {
                        maxLength = substring.length();
                        palindrome = substring;
                    }
                }
            }
            allPalins.add(c.toString());
        }
        return palindrome;
        
    }
    
    public boolean isPalin(String substring) {
        return substring.equalsIgnoreCase(new StringBuilder(substring).reverse().toString());
    }
    
    public String idealSolution(String s) {
      if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
    
    }
}
