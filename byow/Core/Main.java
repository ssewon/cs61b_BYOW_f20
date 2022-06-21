package byow.Core;

import java.io.Serializable;

/** This is the main entry point for the program. This class simply parses
 *  the command line inputs, and lets the byow.Core.Engine class take over
 *  in either keyboard or input string mode.
 */
public class Main implements Serializable {
    public static void main(String[] args) {
        /*args = 7685817615627686380;
        if (args.length > 1) {
            System.out.println("Can only have one argument - the input string");
            System.exit(0);
        } else if (args.length == 1) {*/
        Engine engine = new Engine();
        /*engine.interactWithInputString("n7193300625454684331saaawasdaawdwsd");*/
        /* engine.interactWithInputString("n1234s:q");*/
        /*engine.interactWithInputString("lddddddddd");*/
        /*engine.interactWithInputString("n7193300625454684331saaawasdaawd:q");*/
        /*engine.interactWithInputString("n9127564470038628925s");*/
        /*engine.interactWithInputString("n9127564470038628925sdaddawwawaswasaasswadadaadds");*/
        engine.interactWithInputString("n9127564470038628925sdaddawwawas:q");
        engine.interactWithInputString("lwasaasswadada:q");
        engine.interactWithInputString("ladds");

        /*engine.interactWithInputString("LSSSss");*/


            /*while (true) {
                SaeyiSewonWorld.headsUpDisplay(SaeyiSewonWorld.ourTile);
                engine.move(SaeyiSewonWorld.ourTile,
                SaeyiSewonWorld.avatarX, SaeyiSewonWorld.avatarY);*/
    }
            /*System.out.println(engine.toString());
        } else {
            Engine engine = new Engine();
            engine.interactWithKeyboard();
        }*/
}
