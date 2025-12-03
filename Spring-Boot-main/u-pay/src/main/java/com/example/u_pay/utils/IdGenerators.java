package com.example.u_pay.utils;

import java.util.Random;

public class IdGenerators {
    static Random random = new Random();

    public static String generateId() {
        StringBuilder sb = new StringBuilder();

        for(int a = 1; a <= 16; a++) {
            sb.append(random.nextInt(9));
        }

        return sb.toString();
    }
}
