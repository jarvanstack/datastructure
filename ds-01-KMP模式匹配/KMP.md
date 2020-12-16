**KMP模式匹配似乎需要一个model。**

getnext模式
```java
private static int[] getNext(String pattern)
{
	//获取两串的字符数组，以便遍历
    char patternOfChars[] = pattern.toCharArray();
    //创建next数组
    int[] next = new int[pattern.length()];
    int nextValue = -1, loopOfPattern = 0;//初始化next值及模式串下标
    next[0] = -1;//这里采用-1做标识
    while(loopOfPattern < pattern.length() -1)
    {
	    //获取next数组
        if(nextValue == -1 || patternOfChars[loopOfPattern] == patternOfChars[nextValue])
        {
            nextValue++;
            loopOfPattern++;
            next[loopOfPattern] = nextValue;
        } else {
            nextValue = next[nextValue];
        }
    }
    return next;
}

```
匹配算法
```java

public static int KMP(String str, String pattern) {
	//如果主串长度不小于模式串，则进入模式匹配
    if (str.length() >= pattern.length()) {
    	//获取next数组
    	int next[] = getNext(pattern);
    
        //获取两串的字符数组，以便遍历
        char strOfChars[] = str.toCharArray();
        char patternOfChars[] = pattern.toCharArray();

        //两个循环控制变量
        int loopOfStr, loopOfPattern;
        //遍历主串，任意一串遍历结束，则匹配结束
        for (loopOfStr = 0, loopOfPattern = 0 ; loopOfStr < str.length() && loopOfPattern < pattern.length() ;) {
            //如果两元素相同，或模式串全部匹配失败，比较下一个元素
            if (loopOfPattern == -1 || strOfChars[loopOfStr] == patternOfChars[loopOfPattern]) {
                loopOfStr++;
                loopOfPattern++;
            } else {
                loopOfPattern = next[loopOfPattern];//模式串下标置为next值
            }
        }

        //模式串匹配结束，表示匹配成功
        if (loopOfPattern == pattern.length()) {
            return loopOfStr - loopOfPattern;//主串中模式串第一次出现的位置
        }
    }

    //模式匹配失败
    return -1; 
}

```
