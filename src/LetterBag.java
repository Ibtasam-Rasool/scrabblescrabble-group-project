import java.util.*;

/**
 * LetterBag class repersents the bag of letters that a player draws from to fill their tray
 *
 * @author Ibtasam Rasool
 * @version 1.0
 */
public class LetterBag {

    private HashMap<String, Integer> letterQuantities;

    /**
     * intializes the letter bag by
      */
    public LetterBag(){
        letterQuantities = new HashMap<>();

        for(Letters letter: Letters.values()){
            letterQuantities.put(letter.toString(), letter.getQuantity());
        }
    }
    public String drawRandomLetter() {
        String letter;
        Set<String> keySet = letterQuantities.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int randIndex = new Random().nextInt(keyList.size());
        letter = keyList.get(randIndex);

        decreaseLetterQuantity(letter);

        return letter;
    }

    private void removeLetter(String letter){

        letterQuantities.remove(letter);

    }

    private void decreaseLetterQuantity(String letter){

        if(letterQuantities.get(letter) == 1){

            removeLetter(letter);
        }
        else {
            letterQuantities.put(letter, letterQuantities.get(letter) - 1);
        }

    }

}
