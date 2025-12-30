package Recursion;

public class CountOccurrenceStringAnotherString {
    public static void main(String[] args) {
        String s = "abcc";
        String t = "cc";
        System.out.println(countOccurrences(t, s)); // Output: 1
    }

    static int countOccurrences(String t, String s) {
        return countOccurrencesHelper(t, s, 0);
    }

    static int countOccurrencesHelper(String t, String s, int i) {
        if (i > s.length() - t.length()) {
            return 0;
        }
        int subProblemKaAnswer = countOccurrencesHelper(t, s, i + 1);

        boolean doStartingCharsMatch = s.substring(i, i + t.length()).equals(t);

        if (doStartingCharsMatch) return subProblemKaAnswer + 1;
        else return subProblemKaAnswer;
    }
}
