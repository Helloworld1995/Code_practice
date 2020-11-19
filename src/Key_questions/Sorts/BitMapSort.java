package Key_questions.Sorts;

import java.util.HashSet;
import java.util.Random;

/**
 * bitmap排序
 */
public class BitMapSort {
    public static void main(String[] args) {
        int[] a={31,32,33,63,64};
        int[] bitmap=new int[64/32+1];  //一个int是四个byte，也就是32位，故表示一个n大小的数，需要整形数组n/32+1长度
        for (int i = 0; i <a.length ; i++) {
            int bit=a[i]>>5; //bitmap下标 a[i]/32；
            int index=a[i]&0x1f; //bitmap某个下标中的某一位代表一个数字a[i]%32，1~31%32=1~31
            bitmap[bit]=bitmap[bit]|(1<<index); //bitmap的某个每个元素代表32个数字，32个数字组成32种二进制排列。
        }
        for (int i = 0; i <bitmap.length ; i++) {
            for (int j = 0; j <32 ; j++) {
                if ((bitmap[i]&(1<<j))!=0){ //bitmap中的每个元素与1移位相与，倘若不是0则获得相应位有数字，根据i这个数组下标乘以32+j
                    System.out.print(i*32+j+" ");
                }
            }
        }
    }
}

