package com.acs.code.aoc2018.p1;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Puzzle1Test {

    private Puzzle1 puzzle1;

    @Before
    public void setUp() throws Exception {
        puzzle1 = new Puzzle1();
    }

    @Test
    public void should_returnCorrectFrequency() {
        int frequency = puzzle1.getFrequency(Arrays.asList("+1"));
        assertThat(frequency).isEqualTo(1);
        frequency = puzzle1.getFrequency(Arrays.asList("-2"));
        assertThat(frequency).isEqualTo(-2);

        frequency = puzzle1.getFrequency(Arrays.asList("+1", "-2", "+3","+1"));
        assertThat(frequency).isEqualTo(3);
        frequency = puzzle1.getFrequency(Arrays.asList("+1", "+1", "+1"));
        assertThat(frequency).isEqualTo(3);

        frequency = puzzle1.getFrequency(Arrays.asList("+1", "+1", "-2"));
        assertThat(frequency).isEqualTo(0);

        frequency = puzzle1.getFrequency(Arrays.asList("-1", "-2", "-3"));
        assertThat(frequency).isEqualTo(-6);


    }

    @Test
    public void should_returnListOfFrequencies() {
        List<Integer> frequency = puzzle1.getFrequencyHistory(Arrays.asList("+1", "-2", "+3","+1"));
        assertThat(frequency).containsExactly(1,-1,2,3);
    }

    @Test
    public void should_returnFirstDuplicate() {
//        int frequency = puzzle1.findFirstRepeatFrequency(Arrays.asList("+1","-1"));
//        assertThat(frequency).isEqualTo(0);

        int frequency = puzzle1.findFirstRepeatFrequency(Arrays.asList("+3", "+3", "+4", "-2", "-4"));
        assertThat(frequency).isEqualTo(10);

        frequency = puzzle1.findFirstRepeatFrequency(Arrays.asList("-6", "+3", "+8", "+5", "-6"));
        assertThat(frequency).isEqualTo(5);

        frequency = puzzle1.findFirstRepeatFrequency(Arrays.asList("+7", "+7", "-2", "-7", "-4"));
        assertThat(frequency).isEqualTo(14);
    }
}