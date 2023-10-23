/**
 * ValidPalindrome
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i<j) {
            Character start = s.charAt(i);
            Character end = s.charAt(j);

            // if char at start is not letter/number. Increase the value and skip
            if(!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            // if char at end is not letter/number. Decrease the value and skip
            if(!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            //convert both start and end in lowercase and compare
            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        } 
        return true;  
    }

    public static void main(String[] args) {
         String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }
}