package beans;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class CustomRandomizer {

	Random random = new Random();
	
	public String[] prefixName = { "First", "Second", "Alpha", "Zero", "One" , "Duex", "Mind","Grand",
            "Space", "King", "Queen", "Duke", "Legend of", "Arena", "Gauntlet","Golden",
            "QWERTY" , "Green"};
	

	public String[] SuffixName = { "Break" , "Horizon", "Hero", "AntiHero", "Villian", "Origins",
                                        "Clutch", "Crowd", "Theft", "Invaders", "Command", "Kong", "Hazards",
                                        "Bros"};
	
	public String[] Genres = { "Action","FPS", "Adventure", "Simulator", "Puzzle", "Racing", "MMORPG", "RPG", "Horror", "Suspense", "Thriller", "Mystry", "RTS","Hack-n-Slash"};

	public String[] PreStudios = { "Unreal", "Red", "Black" , "Bloody", "Crimson", "Dark" , "Epic", "End",
            "Get", "Hello", "Level Up", "First"};

	public String[] SufStudios = { "Games", "Gaming" , "Studio", "Reality", "Final", "Go", "World"};
	
	
	public String generateGameName() {
		return (prefixName[random.nextInt(prefixName.length)] +" "+SuffixName[random.nextInt(SuffixName.length)]);
	}
	
	public String generateStudioName() {
		return (PreStudios[random.nextInt(PreStudios.length)] +" "+SufStudios[random.nextInt(SufStudios.length)]);
	}
	
	public String generateGenre() {
		return Genres[random.nextInt(Genres.length)];
	}
	
    public float generatePrice()
    {
        int baseprice = (random.nextInt(8)+2) *10;
        int secondprice = random.nextInt(2) * 5; //either 0 or 5
        return (float) ((baseprice+secondprice) + 0.99);
    }
    
    //found a set up how to do a date time range, and then implemented it into a randomizer
    public Date generateDate() {
    	long beginTime = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
    	long endTime = Timestamp.valueOf(LocalDateTime.now()).getTime();
    	long diff = endTime - beginTime +1;
    	return new Date(beginTime + (long) (Math.random()*diff));
    }
    
    public int generateRating() {
    	return (random.nextInt(100));
    }
    
    public int generateSold(int ratings) {
    	return (random.nextInt(9999899)+100) ;
    }
    
    public List<Game> generateGames(int amount) {
    	List<Game> returnList = new ArrayList<Game>();
    	for (int i = 0; i < amount; i++) {
    		int ratings = generateRating();
			returnList.add(new Game(i+1, generateGameName(), generateStudioName(), generateGenre(), generatePrice(), generateDate(), ratings, generateSold(ratings), 0));
		}
    	return returnList;
    }
}
