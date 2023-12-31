package com.jared.tetrishoney;

public class Square extends TetrisHoney
{
    int xPos;
    int yPos;

    int width = 40;
    int height = 40;

    boolean isFilled = false;

    public void setSquare(int x, int y, boolean fill)
    {
        xPos = x;
        yPos = y;
        isFilled = fill;
    }

}
