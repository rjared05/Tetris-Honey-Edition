package com.jared.tetrishoney;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.utils.*;

import java.awt.*;

/*

What needs to be done...
- Create method that adds all the assets in
- Making the grid for the blocks + next block window
- How to select which block will be next
- Honey mechanic
- Controlling the block (moving it left and right, rotations, etc.)
- How to know when to clear a line

*/

public class TetrisHoney extends ApplicationAdapter
{
    private OrthographicCamera camera;
    private ShapeRenderer shape;
    private SpriteBatch batch;

    Square[][] grid = new Square[20][10];

    int windowWidth;
    int windowHeight;

    @Override
    public void create()
    {

        // Creating the camera.
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 900, 900);

        // Creating the shape renderer.
        shape = new ShapeRenderer();

    }

    @Override
    public void render()
    {
        // Setting background color.
        ScreenUtils.clear(245/255f, 225/255f, 199/255f, 0.8f);

        // Camera updates its matrices.
        camera.update();

            // testing
            /* Rectangle rect = new Rectangle(0,0,10,10);
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.rect(rect.x,rect.y,rect.width, rect.height);
            shape.end(); */

        // Getting window width and height.
        windowWidth = Gdx.graphics.getWidth();
        windowHeight = Gdx.graphics.getHeight();

        // Creating the grid.
        shape = new ShapeRenderer();

        // makeGrid(0, 0, 0, 0);
        makeGrid(250, 50, 0, 0);
        for(int row = 0; row < grid.length; row++)
            for(int column = 0; column < grid[row].length; column++)
            {
                    // testing
                    //System.out.println("current square info: " + grid[row][column].xPos + ", " + grid[row][column].yPos + ", " + grid[row][column].width + ", " + grid[row][column].height);

                shape.setProjectionMatrix(camera.combined);
                shape.begin(ShapeRenderer.ShapeType.Filled);
                shape.setColor(Color.WHITE);
                shape.rect(grid[row][column].xPos, grid[row][column].yPos, grid[row][column].width, grid[row][column].height);
                shape.end();

                shape.setProjectionMatrix(camera.combined);
                shape.begin(ShapeRenderer.ShapeType.Line);
                shape.setColor(Color.BLACK);
                shape.rect(grid[row][column].xPos, grid[row][column].yPos, grid[row][column].width, grid[row][column].height);
                shape.end();
            }

        // Creating the blocks.
        batch = new SpriteBatch();


    }

    @Override
    public void dispose()
    {
        shape.dispose();

    }

    // Method that assigns positions values to the squares in the grid.
    public void makeGrid(int xPos, int yPos, int row, int column)
    {
        // Initializing the square object.
        grid[row][column] = new Square();

        // Setting the position values of a square on the grid.
        grid[row][column].setSquare(xPos, yPos, false);

        // Looping the method until all squares have position values.
        row++;
        if(row != 20)
            makeGrid(xPos, yPos + 40, row, column);
        else
        {
            column++;
            if(column != 10)
                makeGrid(xPos + 40, 50, 0, column);
                // makeGrid(xPos + 40, 0, 0, column);
        }
    }
}
