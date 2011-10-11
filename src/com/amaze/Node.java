package com.amaze;

public class Node
{
	public boolean connectedUp = false;
	public boolean connectedLeft = false;
	public boolean connectedDown = false;
	public boolean connectedRight = false;
	
	public int[] position;
	
	public Node(int posX, int posY)
	{
		this.position = new int[2];
		this.position[0] = posX;
		this.position[1] = posY;
	}
	
	public void setConnector(int dir)
	{
		if (dir == 1)
		{
			this.connectedUp = true;
		}
		else if (dir == 2)
		{
			this.connectedLeft = true;
		}
		else if (dir == 3)
		{
			this.connectedDown = true;
		}
		else if (dir == 4)
		{
			this.connectedRight = true;
		}
		else if (dir == 5)
		{
			this.connectedUp = false;
		}
		else if (dir == 6)
		{
			this.connectedLeft = false;
		}
		else if (dir == 7)
		{
			this.connectedDown = false;
		}
		else if (dir == 8)
		{
			this.connectedRight = false;
		}
	}
	public void setPos(int posX, int posY)
	{
		this.position[0] = posX;
		this.position[1] = posY;
	}
}
