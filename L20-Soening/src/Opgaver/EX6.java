package Opgaver;

public class EX6 {

//    Exercise 6
//    Write a search method, named repeatedChars(), with two parameters: a string s, and a positive
//    int k.
//    The method must return a boolean indicating whether the same character is found in k
//    adjacent positions in the string. This is an advanced searching.
//            Examples:
//    repeatedChars("vnhstxxxaby",3) returns true, because the character x is found in 3 adjacent
//    places in the string.
//    repeatedChars("vnhstxxxaby",4) returns false.
    public static void main(String[] args) {
        String s1 = "vnhstxxxaby";
        System.out.println(repeatedChars(s1, 3)); // true

        String s2 = "vnhstxxxaby";
        System.out.println(repeatedChars(s2, 4)); // false
    }

    /**
     *
     * @pre k has to be positive
     * @return
     */
    public static boolean repeatedChars(String s, int k) {
        char target;
        boolean found;
        for (int i = 0; i <= s.length() - k; i++) {
            found = true;
            target = s.charAt(i);
            //now we need to check if the next X is repeated
            for(int j = 0; j < k; j++){
                //so we get to a char, then we check if the next chars (till size of k) is the same
                if (s.charAt(i + j) != target){
                    //we stop it
                    found = false;
                    break;
                }
            }
            if (found) {
                //we found something at this letter so we return true
                return true;
            }
        }
        return false;
    }


}
