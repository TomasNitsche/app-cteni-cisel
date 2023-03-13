
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class DataInput {
    private InputHelper helper = new InputHelper();
    private final Scanner userInput = new Scanner(System.in, "Windows-1250");
    private final Database database;
    private int[] dataInput;
    private enum TypeOfEntry {NUMBER, FILE}
    protected static String evenOdd = "žádná data k zobrazení";

    DataInput(Database database) {
        this.database = database;
    }

    /**
     * Hlavní metoda třídy. Zjistí přes pomocnou funkci entryFinfOut, jestli je argument number.
     * Pokud ne pracuje s ním jako se souborem.
     * @param typeOfEntry
     * @throws IOException
     */
    protected void gainNumbers(String typeOfEntry) throws IOException {
        if (entryFindOutType(typeOfEntry).equals(TypeOfEntry.NUMBER.toString())) {
            gainNumbersFromUser(typeOfEntry);
        } else {
            gainDataFromFile(typeOfEntry);
        }
    }

    /**
     * Průvodce uživatele při zadávání čísel do konzole
     * @param index
     * @return
     */
    private int gainValue(int index) {

        int value;
        System.out.println("");
        while (true) {
            try {
                System.out.printf("%d. číslo: ", index+1);
                value = userInput.nextInt();
                break;
            } catch (InputMismatchException ime) {
                System.err.printf("Zadaná hodnota je chybně. Zadejte %d. číslo znovu: ", index+1);
                System.out.println();
                userInput.nextLine();
            }
        }
        return value;
    }
    // zjistí typ argumetnu: soubor nebo číslo
    private String entryFindOutType(String typeOfEntry) {
        try {
            Integer.parseInt(typeOfEntry);
            return TypeOfEntry.NUMBER.toString();
        } catch (Exception e) {
            return TypeOfEntry.FILE.toString();
        }
    }

    /**
     * Funkce pro získání vstupu od uživatele
     * @param count získá na základě vstupního parametru počet čísel k zadání
     */
    private void gainNumbersFromUser(String count) {
        System.out.println("Zadejte celé kladné číslo");
        int amount = Integer.parseInt(count);
        int countDown = amount;
        try {
            dataInput = new int[amount];
        } catch (Exception e) {
            System.err.println("Zadejte do parametru kladné celé číslo");
            helper.endingAppFailure();
        }

        for (int i = 0; i < amount; i++) {
            int number = gainValue(i);
            dataInput[i] = number;
            countDown--;
            System.out.printf("Počet čísel, které zbývá zadat: %d ", countDown);
        }
    }

    /**
     * Funkce na základě vstupu určí jeslli si bude ukládat sudá nebo lichá čísla, které poté předá
     * vypíše zda se jedná o sudá nebo lichá čísla
     */
    protected void giveResult() {
        if (dataInput.length == 0) {
            helper.sayReasonOfemptyResult();
        }
        for (int number : dataInput) {
            if (dataInput.length % 2 == 0) {
                if (number % 2 == 0) {
                    database.result.add(number);
                }
                evenOdd = "sudá čísla";
            } else {
                if (number % 2 > 0) {
                    database.result.add(number);
                }
                evenOdd = "lichá čísla";
            }
        }
    }

    /**
     * Zjistí cestu k souboru ve třídě DataOutput
     */
    private void gainDataFromFile(String filePath) throws IOException {
        if (DataOutput.isFilePath(filePath))
        {
            String stringNumbers = DataOutput.bringDataFromFile();
            gainNumbersFromFile(stringNumbers);
        } else {
            System.err.println("Chyba v cestě k souboru " + filePath);
            helper.endingAppFailure();
        }
    }

    /**
     * Získává data ze souboru. Projde soubor jako String který pak rozdělí a převede na kolekci.
     * @param numbers ze souboru
     */
    private void gainNumbersFromFile(String numbers) {
        String[] splitData = numbers.split(", ");
        List<Integer> intList = new ArrayList<>();

        for (String str : splitData) {
            String trimmedStr = str.trim();
            try {
                int parsedInt = Integer.parseInt(trimmedStr);
                intList.add(parsedInt);
            } catch (NumberFormatException e) {

            }
        }
        dataInput = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            dataInput[i] = intList.get(i);
        }
    }
}
