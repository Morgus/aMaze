package com.amaze;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Player 
{
	private static final Color playerColor = new Color(0, 100, 255);
	private static final int width = Game.BLOCK_SIZE-2;
	private static final int height = Game.BLOCK_SIZE-2;
	private int[] pos = new int[2];
	private Input playerInput = null;
	private ArrayList<Node> maze;
	
	public Player(ArrayList<Node> maze)
	{
		this.pos[0] = Game.BLOCK_OFFSET+1;
		this.pos[1] = Game.BLOCK_OFFSET+1;
		this.maze = maze;
	}
	
	public void drawPlayer(Graphics g)
	{
		g.setColor(playerColor);
		g.fillRect(pos[0], pos[1], Player.width, Player.height);
	}
	
	public void movePlayer(GameContainer cont)
	{
		this.playerInput = cont.getInput();
		if (this.playerInput.isKeyPressed(Input.KEY_UP))
		{
			for (int i = 0; i < this.maze.size(); i += 1)
			{
				if (this.pos[0] == this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1 && this.pos[1] == this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1)
				{
					if (this.maze.get(i).connectedUp)
					{
						this.pos[1] -= 20;
						break;
					}
				}
			}
		}
		else if (this.playerInput.isKeyPressed(Input.KEY_LEFT))
		{
			if (this.pos[0] == Game.BLOCK_OFFSET+1 && this.pos[1] == Game.BLOCK_OFFSET+1)
			{
				
			}
			else
			{
				for (int i = 0; i < this.maze.size(); i += 1)
				{
					if (this.pos[0] == this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1 && this.pos[1] == this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1)
					{
						if (this.maze.get(i).connectedLeft)
						{
							this.pos[0] -= 20;
							break;
						}
					}
				}
			}
		}
		else if (this.playerInput.isKeyPressed(Input.KEY_DOWN))
		{
			for (int i = 0; i < this.maze.size(); i += 1)
			{
				if (this.pos[0] == this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1 && this.pos[1] == this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1)
				{
					if (this.maze.get(i).connectedDown)
					{
						this.pos[1] += 20;
						break;
					}
				}
			}
		}
		else if (this.playerInput.isKeyPressed(Input.KEY_RIGHT))
		{
			for (int i = 0; i < this.maze.size(); i += 1)
			{
				if (this.pos[0] == this.maze.get(i).position[0]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1 && this.pos[1] == this.maze.get(i).position[1]*Game.BLOCK_SIZE+Game.BLOCK_OFFSET+1)
				{
					if (this.maze.get(i).connectedRight)
					{
						this.pos[0] += 20;
						break;
					}
				}
			}
		}
	}
	
	public boolean checkIfFinished()
	{
		if (this.pos[0] == Game.SCREEN_X-Game.BLOCK_OFFSET-Game.BLOCK_SIZE+1 && this.pos[1] == Game.SCREEN_Y-Game.BLOCK_OFFSET-Game.BLOCK_SIZE+1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
