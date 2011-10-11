package com.amaze;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Maze
{
	private Image blockU = null;
	private Image blockUL = null;
	private Image blockUD = null;
	private Image blockUR = null;
	private Image blockULD = null;
	private Image blockULR = null;
	private Image blockUDR = null;
	private Image blockULDR = null;
	private Image blockL = null;
	private Image blockLD = null;
	private Image blockLR = null;
	private Image blockLDR = null;
	private Image blockD = null;
	private Image blockDR = null;
	private Image blockR = null;
	
	private MazeCreator creator = null;
	private ArrayList<Node> maze = null;
	
	public Maze() throws SlickException
	{
		maze = new ArrayList<Node>();
		
		this.blockU = new Image("res/img/blockU.png");
		this.blockUL = new Image("res/img/blockUL.png");
		this.blockUD = new Image("res/img/blockUD.png");
		this.blockUR = new Image("res/img/blockUR.png");
		this.blockULD = new Image("res/img/blockULD.png");
		this.blockULR = new Image("res/img/blockULR.png");
		this.blockUDR = new Image("res/img/blockUDR.png");
		this.blockULDR = new Image("res/img/blockULDR.png");
		this.blockL = new Image("res/img/blockL.png");
		this.blockLD = new Image("res/img/blockLD.png");
		this.blockLR = new Image("res/img/blockLR.png");
		this.blockLDR = new Image("res/img/blockLDR.png");
		this.blockD = new Image("res/img/blockD.png");
		this.blockDR = new Image("res/img/blockDR.png");
		this.blockR = new Image("res/img/blockR.png");		
	}
	
	public ArrayList<Node> getMaze()
	{
		return this.maze;
	}
	
	public void createMaze(int[] size)
	{
		creator = new MazeCreator(size);
		creator.createMaze();
		maze = creator.getMaze();
	}
	public void renderMaze()
	{
		for (int i = 0; i < this.maze.size(); i += 1)
		{
			if (this.maze.get(i).connectedUp)
			{
				if (this.maze.get(i).connectedLeft)
				{
					if (this.maze.get(i).connectedDown)
					{
						if (this.maze.get(i).connectedRight)
						{
							this.blockULDR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
						}
						else
						{
							this.blockULD.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
						}
					}
					else if (this.maze.get(i).connectedRight)
					{
						this.blockULR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
					else
					{
						this.blockUL.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
				}
				else if (this.maze.get(i).connectedDown)
				{
					if (this.maze.get(i).connectedRight)
					{
						this.blockUDR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
					else
					{
						this.blockUD.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
				}
				else if (this.maze.get(i).connectedRight)
				{
					this.blockUR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
				else
				{
					this.blockU.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
			}
			else if (this.maze.get(i).connectedLeft)
			{
				if (this.maze.get(i).connectedDown)
				{
					if (this.maze.get(i).connectedRight)
					{
						this.blockLDR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
					else
					{
						this.blockLD.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
					}
				}
				else if (this.maze.get(i).connectedRight)
				{
					this.blockLR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
				else
				{
					this.blockL.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
			}
			else if (this.maze.get(i).connectedDown)
			{
				if (this.maze.get(i).connectedRight)
				{
					this.blockDR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
				else
				{
					this.blockD.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
				}
			}
			else
			{
				this.blockR.draw(this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET, this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET);
			}
		}
	}
}
