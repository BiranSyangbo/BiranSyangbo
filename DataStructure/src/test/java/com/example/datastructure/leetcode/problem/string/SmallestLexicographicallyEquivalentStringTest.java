package com.example.datastructure.leetcode.problem.string;

import org.junit.jupiter.api.Test;

import static com.example.datastructure.leetcode.problem.string.SmallestLexicographicallyEquivalentString.smallestEquivalentString;
import static org.junit.jupiter.api.Assertions.*;

class SmallestLexicographicallyEquivalentStringTest {

    @Test
    void testCase1() {
        assertEquals("aauaaaaada", smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    @Test
    void testCase2() {
        assertEquals("makkek", smallestEquivalentString("parker", "morris", "parser"));
    }

    @Test
    void testCase3() {
        assertEquals("hdld", smallestEquivalentString("hello", "world", "hold"));
    }


    @Test
    void testCase() {
        assertEquals("hold", smallestEquivalentString("abb", "aab", "hold"));
    }

    @Test
    void testCase4() {
        assertEquals("auqpqxmnajphtiserneattymtrydomxnwonfhfjlzzrfhosjct", smallestEquivalentString("aabbbabbbbbabbbbaabaabbaaabbbabaababaaaabbbbbabbaa", "aabbaabbbabaababaabaababbbababbbaaaabbbbbabbbaabaa", "buqpqxmnajphtisernebttymtrydomxnwonfhfjlzzrfhosjct"));
    }

    @Test
    void testCase5() {
        String first = "dfeffdfafbbebbebacbbdfcfdbcacdcbeeffdfebbdebbdafff";
        String second = "adcdfabadbeeafeabbadcefcaabdecabfecffbabbfcdfcaaae";
        String base = "myickvflcpfyqievitqtwvfpsrxigauvlqdtqhpfugguwfcpqv";
        assertEquals("myiakvalapayqiavitqtwvapsrxigauvlqatqhpaugguwaapqv", smallestEquivalentString(first, second, base));
    }

    @Test
    void testCase6() {
        String first = "sdqldcfrjsmdgdbfbnbmtqotjpkslbtenpdkqnqmipkgloldhu";
        String second ="ngmhdmanopnasmqslijqkmeffismuhstnggrfrkujnpgfaoqtb";
        String base = "hzczmpdghfcciknjnerrohwcrunovgvebhuexezwyziqtsvifd";
        assertEquals("azazaaaaaaaaaaaaaaaaaawaaaaavavaaaaaxazwyzaaaavaaa", smallestEquivalentString(first, second, base));
    }
}