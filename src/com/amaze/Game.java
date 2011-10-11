package com.amaze;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame
{
	public static final Color bgColor = new Color(0, 0, 0);
	public static int SCREEN_X = 800;
	public static int SCREEN_Y = 600;
	public static int BLOCK_SIZE = 20;
	public static int BLOCK_OFFSET = 0;
	private static int[] MAZE_SIZE;
	
	private Image arrow = null;
	private Maze maze;
	private Player pl = null;

	public Game(String title)
	{
		super(title);
	}

	@Override
	public void render(GameContainer cont, Graphics g) throws SlickException
	{
		g.setBackground(bgColor);
		this.maze.renderMaze();
		this.arrow.draw(Game.BLOCK_OFFSET-this.arrow.getWidth(), Game.BLOCK_OFFSET);
		this.arrow.draw(Game.SCREEN_X-this.arrow.getWidth()-(Game.BLOCK_OFFSET-this.arrow.getWidth()), Game.SCREEN_Y-this.arrow.getHeight()-Game.BLOCK_OFFSET);
		this.pl.drawPlayer(g);
	}

	@Override
	public void init(GameContainer cont) throws SlickException
	{
		this.maze = new Maze();
		this.maze.createMaze(Game.MAZE_SIZE);
		this.arrow = new Image("res/img/arrow.png");
		this.pl = new Player(this.maze.getMaze());
	}

	@Override
	public void update(GameContainer cont, int delta) throws SlickException
	{
		this.pl.movePlayer(cont);
		if (this.pl.checkIfFinished())
		{
			this.maze = new Maze();
			this.maze.createMaze(Game.MAZE_SIZE);
			this.pl = new Player(this.maze.getMaze());
		}
	}
	
	public static void main(String[] args)
	{
		try 
		{
			Game.MAZE_SIZE = new int[2];
			
			Game.MAZE_SIZE[0] = 30;
			Game.MAZE_SIZE[1] = 20;
			
			Game.SCREEN_X = Game.MAZE_SIZE[0]*Game.BLOCK_SIZE+60;
			Game.SCREEN_Y = Game.MAZE_SIZE[1]*Game.BLOCK_SIZE+60;
			Game.BLOCK_OFFSET = 60/2;
			
			AppGameContainer app = new AppGameContainer(new Game("aMaze"));
			app.setDisplayMode(Game.SCREEN_X, Game.SCREEN_Y, false);
			app.setShowFPS(false);
			app.start();
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
}
