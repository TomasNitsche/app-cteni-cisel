import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
public class DataOutput {

    OutputHelper helper = new OutputHelper();
    private static File file;
    private final Database database;
    DataOutput(Database database)
    {
        this.database = database;
    }

    /**
     * Funkce uloží datý vstup do souboru na základě zadaného parametru při spuštění konzole
     * @param outputFileSave
     */
    protected void addToFile(String outputFileSave) {
        StringBuilder fileContent = new StringBuilder();
        File outputFile = new File(System.getProperty("user.dir") + File.separator + outputFileSave);

        for (int number : database.getResult()) {
            fileContent.append(number).append(", ");
        }
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(outputFile))) {
            printWriter.write(fileContent.toString());
            printWriter.flush();
            System.out.printf("Soubor %s je uložen. ", outputFile);
            System.out.println("");
            helper.endingAppSuccess();

        } catch (Exception e) {
            System.err.println("Zapisování do souboru neproběhlo správně");
            helper.endingAppFailure();
        }
    }

    /**
     * funkce vypíše do konzole výsledky načítaní dat sudých nebo lichých čísel
     */
    public void printResult() {
        System.out.println("Získané hodnoty k vypsání jsou: " + DataInput.evenOdd);
        if (database.getResult().isEmpty()) {
            helper.endingAppFailure();
        }
        database.getResult().forEach(System.out::println);
        helper.endingAppSuccess();

    }

    protected static boolean isFilePath(String filePath) {
        if (filePath.contains(File.separator)) {
            file = new File(filePath);
        } else {
            String directory = System.getProperty("user.dir");
            file = new File(directory + File.separator + filePath);
        }
        return file.exists();
    }

    /**
     * Přečte data s uloženýho souboru na základě argumentu a převede obsah na String.
     * @return
     * @throws IOException
     */
    protected static String bringDataFromFile() throws IOException {
        StringBuilder fileContent = new StringBuilder();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                fileContent.append(data);
            }

        } catch (Exception e) {
            System.err.println("Soubor se nepovedlo načíst ");

        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return fileContent.toString();
    }
}

