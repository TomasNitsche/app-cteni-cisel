
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Helper helper = new Helper();
        Database database = new Database();
        DataOutput dataOutput = new DataOutput(database);
        DataInput dataInput = new DataInput(database);

        /**
         * Co se má stát na základě počtů parametrů uvedených při spuštění aplikace.
         * Musí být přítomen minimálně parametr zda li se čísla budou načítat ze souboru nebo uživatelského vstupu
         */

        if (args.length == 0) {
            helper.writeMissingParameter();
            helper.endingApp(); // žádné argumenty vrátí nápovědu pro nastavení před spuštěním
        } else if (args.length == 1) {
            dataInput.gainNumbers(args[0]);
            dataInput.giveResult();
            dataOutput.printResult();
        } else if (args.length == 2) {
            dataInput.gainNumbers(args[0]);
            dataInput.giveResult();
            dataOutput.addToFile(args[1]);
        } else if (args.length > 2) {
            helper.writeToManyParameters(); // moc argumentů v nastavení. Zavolá nápovědu pro nastavení před spuštěním
            helper.endingApp();
        }
    }
}
