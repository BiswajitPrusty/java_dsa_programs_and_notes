package questions.queue;

import java.util.Arrays;

public class RevealCardsIncreasingOrder950 {

    public static void main(String[] args) {
        deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
    }
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        int deckIndex = 0, resultIndex = 0;
        boolean skip = false;

        while (deckIndex < deck.length) {
            if (result[resultIndex] == 0) {
                if (!skip) {
                    result[resultIndex] = deck[deckIndex];
                    resultIndex++;
                }

                skip = !skip;
            }
            resultIndex = (resultIndex + 1) % deck.length;
        }
        return deck;
    }
}
