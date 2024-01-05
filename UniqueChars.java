/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }
    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String newStr = "";
        int length = s.length();
        for (int i = 0; i < length; i++){
            char currentChar = s.charAt(i);
            if (newStr.indexOf(currentChar)  == -1) {
                newStr = newStr + s.charAt(i);
            }
            else if (s.charAt(i) == ' ') {
                newStr = newStr + s.charAt(i);
            }
        }
        return newStr;
    }
}
