/**
 * This is a text based version of the sims that runs in the command line.
 * You, the player, have no autonomy and the sims entirely take care of themselves
 * inspired by that one video from gamemakers toolkit
 * 
 * @author usednapkin
 */

public class Game {
    //the actual game
    public static void main(String[] args) {    

        System.out.println("Welcome to... \n" );
        System.out.println("                        __                  __              _               ");
        System.out.println("   ________  ____ _____/ /     ____  ____  / /_  __   _____(_)___ ___  _____");
        System.out.println("  / ___/ _ \\/ __ `/ __  /_____/ __ \\/ __ \\/ / / / /  / ___/ / __ `__ \\/ ___/");
        System.out.println(" / /  /  __/ /_/ / /_/ /_____/ /_/ / / / / / /_/ /  (__  ) / / / / / (__  ) ");
        System.out.println("/_/   \\___/\\__,_/\\__,_/      \\____/_/ /_/_/\\__, /  /____/_/_/ /_/ /_/____/  ");
        System.out.println("                                          /____/                            \n");


        System.out.println("Generating a new household... \n");

        Household gameHousehold = new Household();

        System.out.println(gameHousehold.toString());

        gameHousehold.Sims.get(0).setNeedBladder(50, false);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(25, true);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(1000, true);


        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(1000, false);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(50, false);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(25, false);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());

        gameHousehold.Sims.get(0).setNeedBladder(1, false);

        System.out.println("Editing Sim 1's bladder need...");
        System.out.println(gameHousehold.Sims.get(0).toString());



    }


}