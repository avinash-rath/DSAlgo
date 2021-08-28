package machine_coding.game_2048;

import java.util.Scanner;


public class Game {
    private Grid grid;
    private int winNumber;
    private int baseNumber;
    private GameState gameState;
    
    private void setup() {
        // instantiates the game with configs and starts the game
        gameState = GameState.NotStarted;
        winNumber = 2048;
        baseNumber = 2;
        grid = new Grid(4, 4, winNumber, baseNumber);
    }

    public void start() {
        gameState = GameState.NotStarted;
        setup();
        updateGameState(); // changes gameState to [GameState.running]
        RNG.insertInitialNumbers(grid);
        Scanner sc = new Scanner(System.in);
        while(true) {
            updateGameState();
            // clearConsole();
            println(grid.toString());
            if(gameState == GameState.Ended) {
                println("Thanks for playing!");
                sc.close();
                return;
            }
            if(gameState == GameState.Running) {
                println("Enter your move and press `return`--> 0: left, 1: right, 2:top, 3:bottom");
                println("To exit game, press 99");
                handleMoveInput(sc.nextInt());
                RNG.insertNumberAtEmptySpot(grid);
            } else {
                break;
            }
        }
        if(gameState == GameState.Lost) {
            println("Game Over");
        }
        if(gameState == GameState.Won) {
            println("Congratulations you have won the game!");
        }
        sc.close();
    }

    static void clearConsole() {
        // try {
        //     String os = System.getProperty("os.name");
        //     Runtime runtime = Runtime.getRuntime();
        //     if(os.contains("Windows")) {
        //         runtime.exec("cls");
        //     } else {
        //         runtime.exec("clear");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    private void updateGameState() {
        
        if(gameState == GameState.Ended) {
            return;
        }

        // Has the player won?
        if(grid.getIsWinNumberAchieved()) {
            gameState = GameState.Won;
            return;
        }
        
        if(grid.getEmptySpots().size() == 0) {
            // check if the game is still playable or the player has lost?
            boolean isPlayable = grid.isPlayable();
            if(!isPlayable) gameState = GameState.Lost;
            return;
        }
        gameState = GameState.Running;
    }
    
    private void handleMoveInput(int input) {
        Moves moves = new Moves();
        switch(input) {
            case 0: moves.left(grid); break;
            case 1: moves.right(grid); break;
            case 2: moves.top(grid); break;
            case 3: moves.bottom(grid); break;
            case 99: this.gameState = GameState.Ended; break;
            default: println("Invalid move!");
        }
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String...s) {
        Game game = new Game();
        game.start();
    }
}
