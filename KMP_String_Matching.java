class KMP_String_Matching {
    
    static boolean KMPSearch(String pattern, String txt) {
        int pattLen = pattern.length();   //M
        int txtLen = txt.length();   //N
  
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lpsArray[] = new int[pattLen];
        int j = 0; // index for pat[]
  
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pattern, pattLen, lpsArray);
  
        int i = 0; // index for txt[]
        while (i < txtLen) {
            if (pattern.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattLen) {
                return true;
                //System.out.println("Found pattern "
                                   //+ "at index " + (i - j));
                j = lpsArray[j - 1];
            }
            // mismatch after j matches
            else if (i < textLen && pattern.charAt(j) != txt.charAt(i)) {
                // Do not match lpsArray[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lpsArray[j - 1];
                else
                    i = i + 1;
            }
        }
    }
  
    void static computeLPSArray(String pattern, int pattLen, int lpsArray[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lpsArray[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pattLen) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lpsArray[i] = len;
                i++;
            } else {  // (pat[i] != pat[len])
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lpsArray[len - 1];
  
                    // Also, note that we do not increment
                    // i here
                } else { // if (len == 0) 
                    lpsArray[i] = len;
                    i++;
                }
            }
        }
    }
}
