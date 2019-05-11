package cn.wmyskz.springboot.lintcode;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年05月10日 19:36
 */
public class Day2 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        int res=a;
        int xor=a^b;//得到原位和
        int forward=(a&b)<<1;//得到进位和
        if(forward!=0){//若进位和不为0，则递归求原位和+进位和
            res=aplusb(xor, forward);
        }else{
            res=xor;//若进位和为0，则此时原位和为所求和
        }
        return res;
    }
}
