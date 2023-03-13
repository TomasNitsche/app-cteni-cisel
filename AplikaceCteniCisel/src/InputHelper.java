public class InputHelper extends Helper {
    @Override
    protected void sayReasonOfemptyResult() {
        System.out.println("Výsledek je prázdný soubor nebo výstup v konzoli.\n" +
                "zadaný soubor nebo vstup neobsahuje data");
    }
    @Override
    protected void endingAppSuccess() {
        System.out.println("Zadané úkony byly zpracovány.\n" +
                " Ukončuji aplikaci");
        System.exit(0);
    }
    @Override
    protected void endingAppFailure() {
        System.out.println("Zadané úkony nebyly zpracovány. Ukončuji aplikaci");
        System.exit(0);
    }
}
