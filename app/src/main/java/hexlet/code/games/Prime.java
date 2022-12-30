package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Prime {
    public static final int PRIME_GAME_SEQUENCE_NUMBER = 6;
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_UPPER_BORDER = 3571;
    //т.к. в Википедии дан список простых чисел до 3571, поставлю это число верх. границей

    public static void playPrimeGame() {
        String[] questions = new String[Engine.ROUND_COUNT];
        String[] correctAnswers = new String[Engine.ROUND_COUNT];
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            questions[i] = generatePrimeQuestion();
            correctAnswers[i] = generatePrimeCorrectAnswer(questions[i]);
        }
        Engine.runGame(PRIME_RULE, questions, correctAnswers);
    }

    public static String generatePrimeQuestion() {
        return String.valueOf(RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER, PRIME_UPPER_BORDER));
    }

    public static String generatePrimeCorrectAnswer(String question) {
        return isPrimeNumber(question);
    }

    public static String isPrimeNumber(String inputNumber) {
        String correctAnswer = "no";
        int noOneDividerCounts = 0;

        for (int i = 2; i <= PRIME_UPPER_BORDER; i++) {
            if (Integer.parseInt(inputNumber) % i == 0) {
                noOneDividerCounts++;
            }
        }

        if (Integer.parseInt(inputNumber) > 1 && noOneDividerCounts == 1) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
