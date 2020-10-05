

/**
 * @author Jarvan
 * @version 1.0
 * @create 2020/9/29 14:46
 */
public class KMPMatch {
    private String MainString;

    public KMPMatch(String baseString) {
        this.MainString = baseString;
    }

    /**
     * 暴力匹配String.
     * 时间复杂度是 O(n2)
     * @param patternString
     * @return
     */
    public  int ForceMatch(String patternString){

        char[] mainChars = MainString.toCharArray();
        char[] patternChars = patternString.toCharArray();
        for (int i = 0; i < mainChars.length; i++) {
            //如果我们第一匹配就继续匹配
            if (mainChars[i] ==patternChars[0]){
                for (int j = 1; j < patternChars.length; j++) {
                    //如果有一个不匹配就跳出循环
                    if (mainChars[i+j]!=patternChars[j]) {
                        break;
                    }
                    if (j==(patternChars.length -1)){
                        //如果全部匹配还不跳出循环就证明匹配成功，我们直接返回匹配成功的下标。
                        return i;
                    }
                }

            }
        }
        //如果没有匹配成功返回 -1
        return  -1;


    }
    /**
     * 暴力匹配String.
     * 时间复杂度是 O(n2)
     * @param patternString
     * @return
     */
    public  int KMPMatch(String patternString){

        char[] mainChars = MainString.toCharArray();
        char[] patternChars = patternString.toCharArray();
        //我们新增一个变量来储存相同的字符，如果有第一个匹配成功就储存这个相同的字符，防止后面再次碰到，
        //如果后面没有再次碰到相同的字符就可以对i进行一个 ++ ，但是这样节约的时间是O(1)级别，
        // 因为如果第一个不匹配，I会自动 ++，不会进入循环。怎么说？
        char tempChar;
        for (int i = 0; i < mainChars.length; i++) {
            //如果我们第一匹配就继续匹配
            if (mainChars[i] ==patternChars[0]){
                for (int j = 1; j < patternChars.length; j++) {
                    //如果有一个不匹配就跳出循环
                    if (mainChars[i+j]!=patternChars[j]) {
                        break;
                    }
                    if (j==(patternChars.length -1)){
                        //如果全部匹配还不跳出循环就证明匹配成功，我们直接返回匹配成功的下标。
                        return i;
                    }
                }

            }
        }
        //如果没有匹配成功返回 -1
        return  -1;


    }
}
