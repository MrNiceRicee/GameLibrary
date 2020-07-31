package beans;

import java.util.Date;

public class Game {

	public int gameID;
	public String name;
	public String studio;
	public String genre;
	public float price;
	public Date datePublished;
	public int ratings;
	public int itemSold;
	public int playCount;
	
	//Game Constructor
	public Game(int gameID, String name, String studio, String genre, float price, Date datePublished, int ratings,
			int itemSold, int playCount) {
		super();
		this.gameID = gameID;
		this.name = name;
		this.studio = studio;
		this.genre = genre;
		this.price = price;
		this.datePublished = datePublished;
		this.ratings = ratings;
		this.itemSold = itemSold;
		this.playCount = playCount;
	}
	
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public int getItemSold() {
		return itemSold;
	}
	public void setItemSold(int itemSold) {
		this.itemSold = itemSold;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	
	public String getInsert() {
		return "INSERT INTO \"GameLibrary\".\"Games\" (id, \"GAME_NAME\", \"STUDIO\", \"GENRE\", \"PRICE\", \"DATE_PUBLISHED\", \"RATINGS\", \"ITEMS_SOLD\", \"PLAY_COUNT\") VALUES (DEFAULT, '"+this.name
				+"', '"+this.studio+"','"+this.genre+"', "+this.price+", '"+this.datePublished+"', "+this.ratings+", "+this.itemSold+", "+this.playCount+");";
	}
}
