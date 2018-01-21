package com.example.jadso.streamcipher.Snow;



import java.math.BigInteger;
import java.util.Random;

public class SnowMain {


    public static long[] key_arr = new long[8];
    public static long[] key_arr_sml = new long[4];
    static long[] vector_arr = new long[4];
    static long[][] s_arr = new long[2][];
    public static BigInteger test_896_bit;
    static BigInteger test_512_bit;
    static long startTime;
    static long finishTime;

    public static void creare_arr128(BigInteger key, BigInteger vector) {

        key_arr_sml = SnowFunc.split_arrForInit(key, 4, 32);
        vector_arr = SnowFunc.split_arrForInit(vector, 4, 32);
    }

    public static void creare_arr256(BigInteger key, BigInteger vector) {
        key_arr = SnowFunc.split_arrForInit(key, 8, 32);
        vector_arr = SnowFunc.split_arrForInit(vector, 4, 32);
    }

    public static void init(long[] key, long[] vec) {
        long[] val = new long[16];
        if (key.length == 4) {
            val[15] = key[3];
            val[11] = SnowFunc.inv(key[3]);
            val[7] = key[3];
            val[3] = SnowFunc.inv(key[3]);

            val[14] = key[2];
            val[10] = SnowFunc.inv(key[2]);
            val[6] = key[2];
            val[2] = SnowFunc.inv(key[2]);

            val[13] = key[1];
            val[9] = SnowFunc.inv(key[1]);
            val[5] = key[1];
            val[1] = SnowFunc.inv(key[1]);

            val[12] = key[0];
            val[8] = SnowFunc.inv(key[0]);
            val[4] = key[0];
            val[0] = SnowFunc.inv(key[0]);
            s_arr[0] = val;
        } else {
            val[15] = key[7];
            val[7] = SnowFunc.inv(key[7]);

            val[14] = key[6];
            val[6] = SnowFunc.inv(key[6]);

            val[13] = key[5];
            val[5] = SnowFunc.inv(key[5]);

            val[12] = key[4];
            val[4] = SnowFunc.inv(key[4]);

            val[11] = key[3];
            val[3] = SnowFunc.inv(key[3]);

            val[10] = key[2];
            val[2] = SnowFunc.inv(key[2]);

            val[9] = key[1];
            val[1] = SnowFunc.inv(key[1]);

            val[8] = key[0];
            val[0] = SnowFunc.inv(key[0]);
            s_arr[0] = val;
        }
        val[9] = val[9] ^ (vector_arr[3]);
        val[10] = val[10] ^ (vector_arr[2]);
        val[12] = val[12] ^ (vector_arr[1]);
        val[15] = val[15] ^ (vector_arr[0]);
        s_arr[0] = val;
        long[] zr = new long[2];
        zr[0] = 0;
        zr[1] = 0;
        s_arr[1] = zr;
    }

    static byte[] message;

    public static byte[] generationMSG(int leng) {
        Random r = new Random();
        message = new byte[leng];
        r.nextBytes(message);
        return message;
    }

    public static void init_next() {
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
        //System.out.println("s_arr[0] = " + Arrays.toString(s_arr[0]));
        //System.out.println("s_arr[1] = " + Arrays.toString(s_arr[1]));
    }

    public static void genKey128() {
        byte[] bytes = new byte[16];    // 512 bits
        new Random().nextBytes(bytes);
        bytes[0] |= 0x80;               // set the most significant bit
        test_896_bit = new BigInteger(1, bytes);
    }

    public static void genVector() {
        byte[] bytes = new byte[16];    // 128 bits
        new Random().nextBytes(bytes);
        bytes[0] |= 0x80;               // set the most significant bit
        test_512_bit = new BigInteger(1, bytes);
    }

    public static void genKey256() {
        byte[] bytes = new byte[32];    // 256 bits
        new Random().nextBytes(bytes);
        bytes[0] |= 0x80;               // set the most significant bit
        test_896_bit = new BigInteger(1, bytes);
    }

    public static void Streamlet128() {
        //genKey512();
        //genVector();
        creare_arr128(test_512_bit, test_512_bit);
        init(key_arr_sml, vector_arr);

        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
    }

    public static void Streamlet256() {
        //genKey1024();
        //genVector();
        creare_arr256(test_896_bit, test_512_bit);
        init(key_arr, vector_arr);
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();
        SnowFunc.NextForInit();

    }
}