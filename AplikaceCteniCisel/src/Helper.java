public class Helper {
    /**
     *  Helpery pro třídu main. Vypíší hlášky při chybně zádaných vstupů
     */
    protected void writeMissingParameter() {
        System.out.print("Zadej aplikaci alespoň jeden parametr.\n" +
                "Do parametru zadej počet čísel, které budeš zadát na vstupu nebo \n" +
                "zadej cestu k souboru ze kterého chceš číst data");
    }

    protected void writeToManyParameters() {
        System.out.println("Pokoušíte se zadat příliš mnoho parametrů\n" +
                "zadejte 1 nebo 2 parametry oddělené mezerou");
    }
    protected void endingApp() {
        System.out.println("Z důvodu chybně nastavených parametrů ukončuji aplikaci");
        System.exit(0);
    }
    protected void sayReasonOfemptyResult() {
        System.out.println("");
    }
    protected void endingAppSuccess() {
        System.out.println("");
        System.exit(0);
    }
    protected void endingAppFailure() {
        System.out.println("");
        System.exit(0);
    }




}
