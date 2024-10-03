package levels;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Bablu;
import main.Game;
import object.Coin;
import utilities.HelpMethods;

import static utilities.HelpMethods.*;

public class Level {
	private BufferedImage img;
	private int[][] lvlData;
	private ArrayList<Bablu> bablus;
	private ArrayList<Coin> coins;
	private int lvlTilesWide;
	private int lvlTilesTall;
	private int maxTilesOffsetX;
	private int maxTilesOffsetY;
	private int maxLvlOffsetX;
	private int maxLvlOffsetY;
	private Point playerSpawn;
	private int coinsCollected;

	public Level(BufferedImage img) {
		this.img = img;
		createLvlData();
		createEnimies();
		createCoins();
		calcLvlOffsets();
		calcPlayerSpawn();
	}

	private void createCoins() {
		coins = HelpMethods.GetCoins(img);
	}

	private void calcPlayerSpawn() {
		playerSpawn = GetPlayerSpawn(img);
	}

	private void calcLvlOffsets() {
		lvlTilesWide = img.getWidth();
		lvlTilesTall = img.getHeight();
		maxTilesOffsetX = lvlTilesWide - Game.TILES_IN_WIDTH;
		maxTilesOffsetY = lvlTilesTall - Game.TILES_IN_HEIGHT;
		maxLvlOffsetX = maxTilesOffsetX * Game.TILES_SIZE;
		maxLvlOffsetY = maxTilesOffsetY * Game.TILES_SIZE;
	}

	private void createEnimies() {
		bablus = GetBablu(img);
	}

	private void createLvlData() {
		lvlData = GetLevelData(img);
	}

	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	public int[][] getLvlData() {
		return lvlData;
	}

	public int getXLvlOffset() {
		return maxLvlOffsetX;
	}

	public int getYLvlOffset() {
		return maxLvlOffsetY;
	}

	public ArrayList<Bablu> getBablus() {
		return bablus;
	}

	public Point getPlayerSpawn() {
		return playerSpawn;
	}

	public void addCoinCollected() {
		this.coinsCollected++;
	}

	public int getCoinsCollected() {
		return coinsCollected;
	}

	public ArrayList<Coin> getCoins() {
		return coins;
	}

}
