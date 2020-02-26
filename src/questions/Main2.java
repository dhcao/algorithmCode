package questions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String str){

        if(str.length() == 0 || str.length() == 1){
            return str.length();
        }

        char[] chars = str.toCharArray();

        int size = 0;
        Set set = new HashSet();
        for(int l = 0,r = 0;r < chars.length;){
            if(set.add(chars[r])){
                r ++;
                if(set.size() > size){
                    size = set.size();
                }
            }else{
                set.remove(chars[l ++]);
            }

        }

        return size;
    }

    public int JumpFloor(int target) {
        // 穷举找规律
        if(target == 0 || target == 1 || target == 2){
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}