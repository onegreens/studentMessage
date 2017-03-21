package com.ssm.other.email;

import java.util.Random;

/**
 * Created by chensui on 2017/3/14.
 */
public class RandomNum {

    public static String randomNum()  {
        Random random = new Random();

        String result="";

        for(int i=0;i<6;i++){

        result+=random.nextInt(10);

        }

        return result;
    }

    }
