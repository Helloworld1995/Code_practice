package Key_questions.PreparedForHuaWei;

/**
 * leet
 */
public abstract class LeetCode12 {
    public static String intToRoman(int num) {
        String[] s = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int len = s.length;
        int temp = 0;
        StringBuffer result = new StringBuffer();
        for (int i = temp; i < len; i++) {
            if (num >= nums[i]) {
                num -= nums[i];
                result.append(s[i]);
                i--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args)
    {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


