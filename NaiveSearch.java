public class NaiveSearch {
 
    public static boolean naiveStringSearch(String txt, String pat) {
        int pattLen = pat.length(); 
        int txtLen = txt.length();  
 
        /* A loop to slide pat one by one */
        for (int i = 0; i <= textLen - pattLen; i++) {
 
            int j;
 
            /* For current index i, check for pattern
              match */
            for (j = 0; j < pattLen; j++)
                if (txt.charAt(i + j) != pattern.charAt(j))
                    break;
 
            if (j == pattLen) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                //System.out.println("Pattern found at index " + i);
                return true;
        }
    }
}
