package com.amaze;

import java.util.ArrayList;
import java.util.Random;

public class MazeCreator
{	
	private int[] size;
	private Random randomInt;
	private ArrayList<Node> unvisitedSet;
	private ArrayList<Node> activeSet;
	private ArrayList<Node> visitedSet;
	
	
	public MazeCreator(int[] size)
	{
		this.unvisitedSet = new ArrayList<Node>();
		this.activeSet = new ArrayList<Node>();
		this.visitedSet = new ArrayList<Node>();
		this.size = size;
		this.randomInt = new Random();
	}
	
	public ArrayList<Node> getMaze()
	{
		return this.visitedSet;
	}
	
	public void createMaze()
	{
		this.createNodes();
		
		int activeIterator = 0;
		int tempInt = randomInt.nextInt(size[0]*size[1]);
		Node tempNode = this.unvisitedSet.get(tempInt);
		Node nextActiveNode = null;
		this.activeSet.add(tempNode);
		this.unvisitedSet.remove(tempInt);
		int[] dirTried = new int[3];
		dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
		
		while (this.activeSet.size() != 0)
		{
			tempInt = randomInt.nextInt(4)+1;
			while (tempInt == dirTried[0] || tempInt == dirTried[1] || tempInt == dirTried[2])
			{
				tempInt = randomInt.nextInt(4)+1;
			}
			nextActiveNode = new Node(this.activeSet.get(activeIterator).position[0], this.activeSet.get(activeIterator).position[1]);
			if (tempInt == 1)
			{
				nextActiveNode.setPos(this.activeSet.get(activeIterator).position[0], this.activeSet.get(activeIterator).position[1]-1);
				int nodeFound = -1;
				for (int i = 0; i < this.unvisitedSet.size(); i += 1)
				{
					boolean sameNode = this.equalNodePos(nextActiveNode, this.unvisitedSet.get(i));
					boolean notVisited = true;
					for (int j = 0; j < this.activeSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.activeSet.get(j)))
						{
							notVisited = false;
						}
					}
					for (int j = 0; j < this.visitedSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.visitedSet.get(j)))
						{
							notVisited = false;
						}
					}
					if (sameNode && notVisited)
					{
						nodeFound = i;
					}
				}
				if (nodeFound != -1)
				{
					this.activeSet.get(activeIterator).setConnector(tempInt);
					nextActiveNode.setConnector(3);
					this.activeSet.add(nextActiveNode);
					this.unvisitedSet.remove(nodeFound);
					activeIterator += 1;
					dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
				}
				else
				{
					if (dirTried[0] == 0)
					{
						dirTried[0] = 1;
					}
					else if (dirTried[1] == 0)
					{
						dirTried[1] = 1;
					}
					else if (dirTried[2] == 0)
					{
						dirTried[2] = 1;
					}
					else
					{
						this.visitedSet.add(this.activeSet.get(activeIterator));
						this.activeSet.remove(activeIterator);
						activeIterator -= 1;
						dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
					}
				}
			}
			else if (tempInt == 2)
			{
				nextActiveNode.setPos(this.activeSet.get(activeIterator).position[0]-1, this.activeSet.get(activeIterator).position[1]);
				int nodeFound = -1;
				for (int i = 0; i < this.unvisitedSet.size(); i += 1)
				{
					boolean sameNode = this.equalNodePos(nextActiveNode, this.unvisitedSet.get(i));
					boolean notVisited = true;
					for (int j = 0; j < this.activeSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.activeSet.get(j)))
						{
							notVisited = false;
						}
					}
					for (int j = 0; j < this.visitedSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.visitedSet.get(j)))
						{
							notVisited = false;
						}
					}
					if (sameNode && notVisited)
					{
						nodeFound = i;
					}
				}
				if (nodeFound != -1)
				{
					this.activeSet.get(activeIterator).setConnector(tempInt);
					nextActiveNode.setConnector(4);
					this.activeSet.add(nextActiveNode);
					this.unvisitedSet.remove(nodeFound);
					activeIterator += 1;
					dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
				}
				else
				{
					if (dirTried[0] == 0)
					{
						dirTried[0] = 2;
					}
					else if (dirTried[1] == 0)
					{
						dirTried[1] = 2;
					}
					else if (dirTried[2] == 0)
					{
						dirTried[2] = 2;
					}
					else
					{
						this.visitedSet.add(this.activeSet.get(activeIterator));
						this.activeSet.remove(activeIterator);
						activeIterator -= 1;
						dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
					}
				}
			}
			else if (tempInt == 3)
			{
				nextActiveNode.setPos(this.activeSet.get(activeIterator).position[0], this.activeSet.get(activeIterator).position[1]+1);
				int nodeFound = -1;
				for (int i = 0; i < this.unvisitedSet.size(); i += 1)
				{
					boolean sameNode = this.equalNodePos(nextActiveNode, this.unvisitedSet.get(i));
					boolean notVisited = true;
					for (int j = 0; j < this.activeSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.activeSet.get(j)))
						{
							notVisited = false;
						}
					}
					for (int j = 0; j < this.visitedSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.visitedSet.get(j)))
						{
							notVisited = false;
						}
					}
					if (sameNode && notVisited)
					{
						nodeFound = i;
					}
				}
				if (nodeFound != -1)
				{
					this.activeSet.get(activeIterator).setConnector(tempInt);
					nextActiveNode.setConnector(1);
					this.activeSet.add(nextActiveNode);
					this.unvisitedSet.remove(nodeFound);
					activeIterator += 1;
					dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
				}
				else
				{
					if (dirTried[0] == 0)
					{
						dirTried[0] = 3;
					}
					else if (dirTried[1] == 0)
					{
						dirTried[1] = 3;
					}
					else if (dirTried[2] == 0)
					{
						dirTried[2] = 3;
					}
					else
					{
						this.visitedSet.add(this.activeSet.get(activeIterator));
						this.activeSet.remove(activeIterator);
						activeIterator -= 1;
						dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
					}
				}
			}
			else if (tempInt == 4)
			{
				nextActiveNode.setPos(this.activeSet.get(activeIterator).position[0]+1, this.activeSet.get(activeIterator).position[1]);
				int nodeFound = -1;
				for (int i = 0; i < this.unvisitedSet.size(); i += 1)
				{
					boolean sameNode = this.equalNodePos(nextActiveNode, this.unvisitedSet.get(i));
					boolean notVisited = true;
					for (int j = 0; j < this.activeSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.activeSet.get(j)))
						{
							notVisited = false;
						}
					}
					for (int j = 0; j < this.visitedSet.size(); j += 1)
					{
						if (this.equalNodePos(nextActiveNode, this.visitedSet.get(j)))
						{
							notVisited = false;
						}
					}
					if (sameNode && notVisited)
					{
						nodeFound = i;
					}
				}
				if (nodeFound != -1)
				{
					this.activeSet.get(activeIterator).setConnector(tempInt);
					nextActiveNode.setConnector(2);
					this.activeSet.add(nextActiveNode);
					this.unvisitedSet.remove(nodeFound);
					activeIterator += 1;
					dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
				}
				else
				{
					if (dirTried[0] == 0)
					{
						dirTried[0] = 4;
					}
					else if (dirTried[1] == 0)
					{
						dirTried[1] = 4;
					}
					else if (dirTried[2] == 0)
					{
						dirTried[2] = 4;
					}
					else
					{
						this.visitedSet.add(this.activeSet.get(activeIterator));
						this.activeSet.remove(activeIterator);
						activeIterator -= 1;
						dirTried[0] = 0; dirTried[1] = 0; dirTried[2] = 0;
					}
				}
			}
		}
		for (int i = 0; i < this.visitedSet.size(); i += 1)
		{
			if (this.equalNodePos(new Node(0, 0), this.visitedSet.get(i)))
			{
				this.visitedSet.get(i).setConnector(2);
			}
			else if (this.equalNodePos(new Node(this.size[0]-1, this.size[1]-1), this.visitedSet.get(i)))
			{
				this.visitedSet.get(i).setConnector(4);
			}
		}
	}
	
	private void createNodes()
	{
		for (int x = 0; x < this.size[0]; x += 1)
		{
			for (int y = 0; y < this.size[1]; y += 1)
			{
				this.unvisitedSet.add(new Node(x, y));
			}
		}
	}
	
	private boolean equalNodePos(Node a, Node b)
	{
		if (a.position[0] == b.position[0] && a.position[1] == b.position[1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
