package AnimalMatchingGame;

import java.util.Arrays;
import java.util.Collections;

/**
 * The game of Concentration (also called Memory or Match Match)
 * 
 * Create a gameboard of tiles. Each tile contains a card that has exactly
 * one match on the board. Cards are originally show "face down" on the board.
 * 
 * Player chooses two random cards from the board. The chosen cards
 * are temporarily shown face up. If the cards match, they are removed from board.
 * 
 * Play continues, matching two cards at a time, until all cards have been matched.
 */
public class Concentration extends Board
{
    // create the game board
    private Tile[][] gameboard = makeBoard();


    int matchedPairs = 0;


    //counters for the for loop
    private int rowCounter = 0;
    private int columnCounter = 0;
    private int index = 0;

    //The cards that will be placed in the tiles
    private String[] cards = new String[] {"dog", "dog", "cat", "cat", "mouse", "mouse",
            "wolf", "wolf", "monkey", "monkey", "bird", "bird"};


    public Tile[][] getGameboard() {
        return gameboard;
    }

    /**
     * The constructor for the game. Creates the 2-dim gameboard
     * by populating it with tiles.
     */


    public Concentration() {
        rowCounter = 0;
        columnCounter = 0;
        index = 0;
        //shuffle cards
        Collections.shuffle(Arrays.asList(cards));
        //add values to board
        for(Tile[] row:gameboard){
            for(Tile column:row){

                Tile tile = new Tile(cards[index]);
                gameboard[rowCounter][columnCounter] = tile;
                columnCounter++;
                index++;

            }
            //reset columnCounter and go to next row
            columnCounter = 0;
            rowCounter++;

        }


    }

    public void printBoard(){
        this.gameboard = getGameboard();
        rowCounter = 0;
        columnCounter = 0;
        for(Tile[] row:gameboard){


            for(Tile column:row){

                if(gameboard[rowCounter][columnCounter].isFaceUp() || gameboard[rowCounter][columnCounter].matched()){
                    System.out.print("|"+gameboard[rowCounter][columnCounter].getFace()+"|");
                }else{
                    System.out.print(gameboard[rowCounter][columnCounter].getBack());
                }
                columnCounter++;

            }
            columnCounter = 0;
            rowCounter++;
            System.out.println("");

        }
    }


    /**
     * Determine if the board is full of cards that have all been matched,
     * indicating the game is over
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return true if all pairs of cards have been matched, false otherwse
     */
    public boolean allTilesMatch() {
        
        if(matchedPairs == 6){
            return true;
        }
        
        return false;
    }

    //flip all cards down
    public void allCardsDown(int i1, int j1, int i2, int j2){
        gameboard[i1][j1].faceUp(false);
        gameboard[i2][j2].faceUp(false);
    }

    /**
     * Check for a match between the cards in the two tile locations.
     * For matched cards, remove from the board. For unmatched cares, them face down again.
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row1 the row value of Tile 1
     * @param column1 the column value of Tile 1
     * @param row2 the row value of Tile 2
     * @param column2 the column vlue of Tile 2
     * @return a message indicating whether or not a match occured
     */
    public String checkForMatch(int row1, int column1, int row2, int column2) {
        
        if(gameboard[row1][column1].getFace() == gameboard[row2][column2].getFace()){
            gameboard[row1][column1].foundMatch();
            gameboard[row2][column2].foundMatch();
            matchedPairs++;
            return "match";
        }
        
        return "nope";
    }

    /**
     * Set  tile to show its card in the face up state
     * 
     * Precondition: gameboard is populated with tiles,
     * row values (i values) must be in the range of 0 to gameboard.length,
     * column values (j values) must be in the range of 0 to gameboard[0].length
     * 
     * @param row the row value of Tile
     * @param column the column value of Tile
     */
    public void showFaceUp (int row, int column) {
        gameboard[row][column].faceUp(true);

    }

    /**
     * Returns a string representation of the board. A tab is placed between tiles,
     * and a newline is placed at the end of a row
     * 
     * Precondition: gameboard is populated with tiles
     * 
     * @return a string represetation of the board
     */
    public String toString() {
        
        // to do
        
        return "";
    }

}

