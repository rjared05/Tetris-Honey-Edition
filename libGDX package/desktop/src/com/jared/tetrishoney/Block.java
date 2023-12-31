package com.jared.tetrishoney;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.lang.reflect.Method;

public class Block extends TetrisHoney
{
    int randomKey;

    Class type = Class.forName("Type");
    Method typeCall;

    Square[][] currentBlock;
    Map<Integer, String> types = new HashMap<>();
    String currBlockType;

    //
    public Block() throws ClassNotFoundException
    {
        // Putting all the block types into a hash map.
        types.put(0, "I");
        types.put(1, "L");
        types.put(2, "J");
        types.put(3, "O");
        types.put(4, "S");
        types.put(5, "T");
        types.put(6, "Z");

        // Generating a new block type for the next call.
        randomKey = new Random().nextInt(6);
        currBlockType = types.get(randomKey);
    }

    // Generating a new block.
    public void getNewBlock(int xPos, int yPos) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
            // Need xPos and yPos to be based on a random square at the top of the grid...

        // Calls method of the block type generated randomly.
        typeCall = type.getDeclaredMethod(currBlockType, int.class, int.class);
        currentBlock = (Square[][]) typeCall.invoke(type, xPos, yPos);

        // Generating a new block type for the next call.
        while(types.get(randomKey) == currBlockType)
            randomKey = new Random().nextInt(6);
        currBlockType = types.get(randomKey);

    }

}

//
class Type
{
    //
    static Square[][] I (int xPos, int yPos)
    {
        // First [] = Possible positions
        // Second [] = Square placement
        Square[][] block = new Square[2][4];

        // Initializing the array.
        for(int row = 0; row < block.length; row++)
            for(int column = 0; column < block[row].length; column++)
                block[row][column] = new Square();

        // Defining the possible positions of the block.
        block[0][0].setSquare(xPos, yPos, true);                // Original / Vertical position.
        block[0][1].setSquare(xPos, yPos + (40 * 1), true);
        block[0][2].setSquare(xPos, yPos + (40 * 2), true);
        block[0][3].setSquare(xPos, yPos + (40 * 3), true);

        block[1][0].setSquare(xPos, yPos, true);                // Horizontal position.
        block[1][1].setSquare(xPos + (40 * 1), yPos, true);
        block[1][2].setSquare(xPos + (40 * 2), yPos, true);
        block[1][3].setSquare(xPos + (40 * 3), yPos, true);

            /*
                Need to figure out how to:
                - Make the block shapes into sprites.
                - Stop the rotation of a block from occurring if there is no space to.
                - Prevent a block from moving further down if there is no space left.
                - Implement the honey gimmick.
                - etc...
            */

        return block;
    }

    static Square[][] L (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];

        // Initializing the array.
        for(int row = 0; row < block.length; row++)
            for(int column = 0; column < block[row].length; column++)
                block[row][column] = new Square();

        // Defining the possible positions of the block.
        block[0][0].setSquare(xPos, yPos, true);                // Original position.
        block[0][1].setSquare(xPos, yPos + (40 * 1), true);
        block[0][2].setSquare(xPos, yPos + (40 * 2), true);
        block[0][3].setSquare(xPos + (40 * 1), yPos + (40 * 2), true);

        block[1][0].setSquare(xPos, yPos, true);                // Rotation 1 position.
        block[1][1].setSquare(xPos + (40 * 1), yPos, true);
        block[1][2].setSquare(xPos + (40 * 2), yPos, true);
        block[1][3].setSquare(xPos + (40 * 2), yPos + (40 * 1), true);

        block[2][0].setSquare(xPos, yPos, true);                // Rotation 2 position.
        block[2][1].setSquare(xPos - (40 * 1), yPos, true);
        block[2][2].setSquare(xPos - (40 * 2), yPos, true);
        block[2][3].setSquare(xPos - (40 * 2), yPos - (40 * 1), true);

        block[3][0].setSquare(xPos, yPos, true);                // Upside down position.
        block[3][1].setSquare(xPos - (40 * 1), yPos, true);
        block[3][2].setSquare(xPos, yPos + (40 * 1), true);
        block[3][3].setSquare(xPos, yPos + (40 * 2), true);

        return block;
    }

    static Square[][] J (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];



        return block;
    }

    static Square[][] O (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];



        return block;
    }

    static Square[][] S (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];



        return block;
    }

    static Square[][] T (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];



        return block;
    }

    static Square[][] Z (int xPos, int yPos)
    {
        Square[][] block = new Square[4][4];



        return block;
    }
}