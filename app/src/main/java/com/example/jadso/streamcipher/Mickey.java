package com.example.jadso.streamcipher;



public class Mickey {
    public static int[] COMP0 = {0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0,
            1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0,
            0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0,
            1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0,
            0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0};
    public static int[] COMP1 = {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0,
            0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1,
            0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0,
            1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0,
            1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public static int[] FB0 = {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1,
            0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0,
            1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0,
            1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1,
            1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1};
    public static int[] FB1 = {1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1,
            0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0,
            0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0,
            1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0,
            1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0};
    public static int[] RTAPS = {0, 4, 5, 8, 10, 11, 14, 16, 20, 25, 30, 32, 35, 36, 38, 42, 43, 46, 50, 51, 53, 54, 55, 56, 57, 60, 61, 62,
            63, 65, 66, 69, 73, 74, 76, 79, 80, 81, 82, 85, 86, 90, 91, 92, 95, 97, 100, 101, 105, 106, 107, 108,
            109, 111, 112, 113, 115, 116, 117, 127, 128, 129, 130, 131, 133, 135, 136, 137, 140, 142, 145, 148,
            150, 152, 153, 154, 156, 157};
    final static int[] r = new int[160];
    final static int[] s = new int[160];

    private static void initR() {
        for (int i = 0; i < 160; i++) {
            r[i] = 0;
        }
    }

    private static void initS() {
        for (int i = 0; i < 160; i++) {
            s[i] = 0;
        }
    }

    public static void CLOCK_R(int[] r, int input_bit_r, int control_bit_r) {
        int Feedback_bit;
        int i;
        int[] rb = r;
        Feedback_bit = r[159] ^ input_bit_r;
        for (i = 159; i > 0; i--) {
            r[i] = r[i - 1];
        }
        r[0] = 0;
        for (i = 159; i >= 0; i--) {
            for (int j = RTAPS.length - 1; j >= 0; j--) {
                if (RTAPS[j] == i) {
                    r[i] = r[i] ^ Feedback_bit;
                }
            }
        }
        if (control_bit_r == 1) {
            for (int j = 159; j >= 0; j--) {
                r[j] = r[j] ^ rb[j];
            }
        }
    }
    public static void CLOCK_S(int[] s, int input_bit_s, int control_bit_s) {
        int[] s_hat = new int[160];
        int Feedback_bit;
        int i;
        Feedback_bit = s[159] ^ input_bit_s;

        for (i = 158; i > 0; i--) {
            s_hat[i] = s[i - 1] ^ ((s[i] ^ COMP0[i]) & (s[i + 1] ^ COMP1[i]));
        }
        s_hat[0] = 0;
        s_hat[159] = s[158];

        for (i = 0; i < 160; i++) {
            s[i] = s_hat[i];
        }
        if (control_bit_s == 1) {
            for (i = 0; i < 160; i++) {
                s[i] = s_hat[i] ^ (FB1[i] & Feedback_bit);
            }
        } else if (control_bit_s == 0) {
            for (i = 0; i < 160; i++) {
                s[i] = s_hat[i] ^ (FB0[i] & Feedback_bit);
            }
        }
    }
    //System.out.println(Arrays.toString(s));


    public static void CLOCK_KG(int[] r, int[] s, boolean mixing, int input_bit) {
        int control_bit_r;
        int control_bit_s;

        control_bit_r = s[54] ^ r[106];
        control_bit_s = s[106] ^ r[53];

        if (mixing == true) {
            CLOCK_R(r, input_bit ^ s[80], control_bit_r);
            CLOCK_S(s, input_bit, control_bit_s);
        } else {
            CLOCK_R(r, input_bit, control_bit_r);
            CLOCK_S(s, input_bit, control_bit_s);
        }
    }

    public static void keyInit(int[] vector, int[] key) {
        initS();
        initR();
        for (int i = 0; i < vector.length; i++) {
            CLOCK_KG(r, s, true, vector[i]);
        }
        for (int i = 0; i < 128; i++) {
            CLOCK_KG(r, s, true, key[i]);
        }
        for (int i = 0; i < 160; i++) {
            CLOCK_KG(r, s, true, 0);
        }
    }

    static int z;

    public static int genKeyStream() {
        z = r[0] ^ s[0];
        //System.out.println(z);
        CLOCK_KG(r, s, false, 0);
        return z;
    }

    static int[] key = new int[128];
    static int[] vector = new int[128];

    public static void genKey() {
        for (int i = 0; i < key.length; i++) {
            key[i] = (byte) (Math.random() * (2));
            vector[i] = (byte) (Math.random() * (2));

        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (byte) (Math.random() * (2));

        }
    }
}
