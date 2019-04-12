package exercise.exercise_0412;

/*
倒置字符串
题目描述
将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
输入描述:
每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
输出描述:
依次输出倒置之后的字符串,以空格分割
示例1
输入
I like beijing.
输出
beijing. like I
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=0; i<str.length(); i++){
            char t = str.charAt(i);
            if('a'<t && t>'z' && t!=' '){
                str = str.substring(0,i+1)+" "+str.substring(i+1);
                i++;
            }
        }
        String[] s = str.split(" ");
        String res = "";
        for(int i=s.length-1; i>=0; i--){
            if(i != s.length-1){
                res += " ";
            }
            res += s[i];
        }
        System.out.println(res);
    }
}*/

/*
暗黑的字符串
题目描述
一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
输入描述:
输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)
输出描述:
输出一个整数表示有多少个暗黑字符串
示例1
输入
2 3
输出
9 21
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            long[] num = new long[n];
            for(int i=0; i<n; i++){
                if(i==0){
                    num[i] = 3;
                }else if(i==1){
                    num[i] = 9;
                }else{
                    num[i] = 2*num[i-1] +num[i-2];
                }
            }
            System.out.println(num[n-1]);
        }
    }
}
*/

/*
回文序列
题目描述
如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
现在给出一个数字序列，允许使用一种转换操作：
选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
输入描述:
输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
输出描述:
输出一个数，表示最少需要的转换次数
示例1
输入
4 1 1 1 3
输出
2
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int i=0;
        int j=n-1;
        int count = 0;
        while(i<j){
            if(nums[i] == nums[j]){
                i++;
                j--;
            }else if(nums[i] < nums[j]){
                i++;
                count++;
                nums[i] += nums[i-1];
            }else{
                j--;
                count++;
                nums[j] += nums[j+1];
            }
        }
        System.out.println(count);
    }
}
*/

/*
进制转换
题目描述
给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
输入描述:
输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
输出描述:
为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
示例1
输入
7 2
输出
111
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        if(M>=0){
            System.out.println(solution(M,N));
        }else{
            System.out.println("-"+solution(-M,N));
        }
    }
    private static String solution(int M,int N){
        String res = "";
        while(M!=0){
            int d = M%N;
            M /= N;
            if(d >=10){
                res = String.valueOf((char)(55+d)) + res;
            }else{
                res = String.valueOf((char)(48+d)) + res;
            }
        }
        return res;
    }
}
