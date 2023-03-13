public class OutputHelper extends Helper {
    @Override
    protected void endingAppSuccess() {
        System.out.println("Zadané úkony byly zpracovány.\n" +
                " Ukončuji aplikaci");
        System.exit(0);
    }
    @Override
    protected void endingAppFailure() {
        System.out.println("Zadané úkony nebyly zpracovány. Zkuste změnit vstupy. Ukončuji aplikaci");
        System.exit(0);
    }
    @Override
    protected void sayReasonOfemptyResult() {
        System.out.println("Výsledek je prázdný soubor nebo výstup v konzoli.\n" +
                "Důvodem může být například, že zadaný počet čísel je liché číslo, avšak\n" +
                "na vstupu se žádné liché číslo nenachází. Zkontrolujte, že jsou na vstupu nějaká zadána čísla");
    }
}
