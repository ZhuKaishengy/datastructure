package chapter01;

/**
 * 判断一个字符串是否是回文字符串
 * abccba
 * 12321
 */
public class PalindromeString {

    /**
     * 迭代遍历
     * @param str
     * @return
     */
    public boolean isPalindromeString_recursive1(String str){

        int beginIndex = 0;
        int endIndex = str.length() -1;
        while (beginIndex <= endIndex) {
            // end condition
            // process
            if (str.charAt(beginIndex) != str.charAt(endIndex)) {
                return false;
            }
            // iterator
            beginIndex++;
            endIndex--;
        }
        return true;
    }

    /**
     * 递归
     * @param str
     * @return
     */
    public boolean isPalindromeString_recursive2(String str){
        int beginIndex = 0;
        int endIndex = str.length() -1;
        if (beginIndex <= endIndex){
            // process
            if (str.charAt(beginIndex) != str.charAt(endIndex)) {
                return false;
            } else {
                // recursive
                return this.isPalindromeString_recursive2(str.substring(beginIndex+1,endIndex));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abccba";
        String str2 = "123421";
        PalindromeString palindromeString = new PalindromeString();
        boolean b1 = palindromeString.isPalindromeString_recursive1(str1);
        boolean b2 = palindromeString.isPalindromeString_recursive1(str2);
        boolean b3 = palindromeString.isPalindromeString_recursive2(str1);
        boolean b4 = palindromeString.isPalindromeString_recursive2(str2);
        /**
         * true false true false
         */
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
