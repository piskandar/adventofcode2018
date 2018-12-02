package com.acs.code.aoc2018.p1;

import com.acs.code.aoc2018.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Puzzle1 {


    public int getFrequency(List<String> input){
        int frequency = 0;

        for (String str : input) {
            int number = Integer.parseInt(str.substring(1));
            if(str.startsWith("+")){
                frequency += number;
            }else if(str.startsWith("-")){

                frequency -= number;
            }
        }
        return frequency;
    }

    public List<Integer> getFrequencyHistory(List<String> input){
        List<Integer> freq = new ArrayList<>();
        int frequency = 0;

        for (String str : input) {
            int number = Integer.parseInt(str.substring(1));
            if(str.startsWith("+")){
                frequency += number;
            }else if(str.startsWith("-")){

                frequency -= number;
            }
            freq.add(frequency);
        }
        return freq;
    }

    public int findFirstRepeatFrequency(List<String> input){
        List<Integer> freq = new ArrayList<>();
        int frequency = 0;
        boolean found = false;
        while(!found) {
            for (String str : input) {
                int number = Integer.parseInt(str.substring(1));
                if (str.startsWith("+")) {
                    frequency += number;
                } else if (str.startsWith("-")) {

                    frequency -= number;
                }
                if (freq.contains(frequency)) {
                    found = true;
                    break;
                } else {
                    freq.add(frequency);
                }
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        List<String> inputs = FileUtil.readStringList("file:///Users/piskandar/Development/advent-of-code-2018/inputs/puzzle1/p1input.txt");
        Puzzle1 puzzle1 = new Puzzle1();
        int frequency = puzzle1.getFrequency(inputs);
//        System.out.println(frequency);



         frequency = puzzle1.findFirstRepeatFrequency(inputs);
        System.out.println(frequency);
    }
}
