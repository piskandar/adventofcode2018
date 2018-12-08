package com.acs.code.aoc2018.p2;

import com.acs.code.aoc2018.util.Tuple2;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Puzzle2Test {

    private Puzzle2 puzzle2;

    @Before
    public void setUp() throws Exception {
        puzzle2 = new Puzzle2();
    }

    @Test
    public void should_detectTwoOfOneLetterAndReturnNumber() {
        Tuple2<Boolean, Boolean> numberOfTwos = puzzle2.find2sAnd3sOfCharacter("abcdef");

        assertThat(numberOfTwos._0).isFalse();
        assertThat(numberOfTwos._1).isFalse();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("bababc");
        assertThat(numberOfTwos._0).isTrue();
        assertThat(numberOfTwos._1).isTrue();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("abbcde");
        assertThat(numberOfTwos._0).isTrue();
        assertThat(numberOfTwos._1).isFalse();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("abcccd");
        assertThat(numberOfTwos._0).isFalse();
        assertThat(numberOfTwos._1).isTrue();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("aabcdd");
        assertThat(numberOfTwos._0).isTrue();
        assertThat(numberOfTwos._1).isFalse();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("abcdee");
        assertThat(numberOfTwos._0).isTrue();
        assertThat(numberOfTwos._1).isFalse();

        numberOfTwos = puzzle2.find2sAnd3sOfCharacter("ababab");
        assertThat(numberOfTwos._0).isFalse();
        assertThat(numberOfTwos._1).isTrue();
    }

    @Test
    public void should_getCheckSum() {
        int checkSum = puzzle2.checkSum(Arrays.asList("abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab"));
        assertThat(checkSum).isEqualTo(12);
    }

    @Test
    public void should_findLetters() {
        int count = puzzle2.compareCharacters("abcde", "fghij");
        assertThat(count).isEqualTo(5);

        count = puzzle2.compareCharacters("abcde", "axcye");
        assertThat(count).isEqualTo(2);

        count = puzzle2.compareCharacters("fghij", "fguij");
        assertThat(count).isEqualTo(1);

    }

    @Test
    public void should_returnPositionOfDifferingCharacters() {
        List<Integer> diffPositions = puzzle2.getPositionsOfUniqueCharacters("fghij", "fguij");
        assertThat(diffPositions).containsExactly(2);
    }
}