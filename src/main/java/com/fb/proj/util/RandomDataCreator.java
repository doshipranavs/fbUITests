package com.fb.proj.util;

import org.apache.commons.text.RandomStringGenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RandomDataCreator {


    public static String getRandomAplhabetsOfGivenSize(int size) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String randomWord = "Test" + generator.generate(size);
        return randomWord;
    }

    public static String getRandomNumberOfGivenSize(int size) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('1', '9').build();
        String randomNumbers = generator.generate(size);
        return randomNumbers;
    }


    public static String getRandomPrefix() {
        String[] allPrefix = {"Mr", "Mrs", "Miss", "Master", "Ms"};
        int generator = RandomDataCreator.getRandomNumberRange(0, allPrefix.length - 1);
        String prefix = allPrefix[generator];
        return prefix;
    }


    public static String getRandomPostCode() {
        String[] allPostcode = {"AB1 0AB", "AL10 0QQ", "B1 1TA", "B99 1DY", "CA1 1AA", "CA28 6AQ", "DA1 1AQ", "DA1 1AQ",
                "E1 0SF", "E20 3PS"};
        int generator = RandomDataCreator.getRandomNumberRange(0, allPostcode.length - 1);
        //int index = Integer.parseInt(generator.generate(1));
        String postCode = allPostcode[generator];
        return postCode;
    }

    public static int getRandomNumberRange(int lowerLimit, int upperLimit) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(upperLimit) + lowerLimit;
        System.out.println("Random number generated is : " + randomInt);
        return randomInt;
    }


    public static void main(String[] args) {


        System.out.println(RandomDataCreator.getRandomAplhabetsOfGivenSize(10));
        System.out.println(RandomDataCreator.getRandomNumberOfGivenSize(11));
        System.out.println(RandomDataCreator.getRandomPrefix());
        System.out.println(RandomDataCreator.getRandomNumberRange(3, 125));
        //currentDate();
    }
    public static String currentDate(int days) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return df.format(cal.getTime());
    }
}
