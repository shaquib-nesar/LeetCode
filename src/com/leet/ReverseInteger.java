package com.leet;

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        boolean negativeFlag = x < 0;
        if (negativeFlag) x = -1 * x;

        while (x > 0) {
            int temp = rev * 10 + x % 10;
            if (((temp - x % 10) / 10) != rev) return 0;
            x /= 10;
            rev = temp;
        }

        if (negativeFlag) rev = -1 * rev;
        return rev;
    }
}
