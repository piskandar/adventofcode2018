package com.acs.code.aoc2018.p2;

import com.acs.code.aoc2018.util.FileUtil;
import com.acs.code.aoc2018.util.Tuple2;

import java.util.*;

public class Puzzle2 {

    public Tuple2<Boolean,Boolean> find2sAnd3sOfCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                count++;
                map.replace(c,count);
            }else {
                map.put(c,1);
            }
        }
        Tuple2<Boolean,Boolean> tuple = new Tuple2<>(false,false);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2){
                tuple._0 = true;
            }

            if(entry.getValue() == 3){
                tuple._1 = true;
            }
        }
        return tuple;
    }

    public int checkSum(List<String> inputs){
        int twoSum = 0;
        int threeSum = 0;
        for (String input : inputs) {
            Tuple2<Boolean,Boolean> tuple = find2sAnd3sOfCharacter(input);
            if(tuple._0){
                twoSum++;
            }
            if(tuple._1){
                threeSum++;
            }
        }
        return twoSum * threeSum;
    }

    public static void main(String[] args) {
        List<String> inputList = FileUtil.readStringList("file:///Users/piskandar/Development/advent-of-code-2018/inputs/puzzle2/p2input.txt");

        Puzzle2 puzzle2 = new Puzzle2();
        int checkSum = puzzle2.checkSum(inputList);
        System.out.println(checkSum);


        for(int i = 0 ;i< inputList.size(); i++){
            for (int j = 0; j < inputList.size(); j++) {
                int diff = puzzle2.compareCharacters(inputList.get(i), inputList.get(j));
                if(diff == 1){
                    System.out.println(inputList.get(i) + "  " + inputList.get(j));
                    for (Integer positionOfUniqueCharacter : puzzle2.getPositionsOfUniqueCharacters(inputList.get(i), inputList.get(j))) {
                        System.out.println(positionOfUniqueCharacter);
                    }

                }
            }
        }

    }

    public int compareCharacters(String str1, String str2){
        if(str1.length() != str2.length())
            return -1;

        int diffCount = 0;
        for(int i = 0; i < str1.length() ; i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if(c1 != c2){
                diffCount++;
            }
        }


        return diffCount;
    }


    public List<Integer> getPositionsOfUniqueCharacters(String str1, String str2) {
        if(str1.length() != str2.length())
            return null;

        List<Integer> diffPositions = new ArrayList<>();

        for(int i = 0; i < str1.length() ; i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if(c1 != c2){
                diffPositions.add(i);
            }
        }
        return diffPositions;
    }
}
