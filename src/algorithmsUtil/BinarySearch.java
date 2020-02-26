package algorithmsUtil;

/**
 * 二分查找法
 * @Author: dhcao
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int a = 8;
        char b = (char)(a + 48);
        System.out.println(b);
    }

    /**
     * 二分查找法
     * 循环不变量：维护好这个不变量，就可以了。
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int n, int target){

        // 在[l, r]的范围内查找target
        int l = 0;
        int r = n - 1;

        while(l <= r){
            int mid = (l + r)/2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return -1;
    }
}
