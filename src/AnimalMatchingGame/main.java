package AnimalMatchingGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class main {

    public static void main(String args[])
    {

        JFrame frame = new JFrame("Animal Matching Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //create list of cards, 2 for each animal
        String[] animalList = {"bird","bird","dog","dog","cat","cat","monkey","monkey","wolf","wolf","mouse","mouse"};
        //shuffle
        Collections.shuffle(Arrays.asList(animalList));
        //System.out.print(Arrays.toString(animalList));

        //insert into 2d array
        int rowCounter = 0;
        int columnCounter = 0;
        String[][] animalCards = new String[3][4];
        for(String[] row:animalCards){
            for (String column:row){


            }
        }







        frame.pack();

        //frame.setVisible(true);


    }

}
