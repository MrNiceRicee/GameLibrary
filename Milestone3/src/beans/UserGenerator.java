package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator {

    private String[] firstNameList = {"Andre","James", "John", "Robert", "Micheal", "William",

            "Ariana","Mary", "Patricia", "Jennifer", "Linda", "Elizabeth",

            "Joshua", "Nicole", "Cristal","Christian","Charles","David","Daniel","Joanna","Joe","Joseph",

            "Anna","Andrew","Benjamin","Betty","Charlie","DK","Danielle","Ester","Eugene","Frank","Fran","George","Geo",
            "Henry","Hwasa","Ian","Irelia","Jason","Jessica","Killmonger","Katarina","Lucian","Lissandra","Lanna","Monica","Matt",
            "Nathaniel","Natasha","Ophelia","Orlando","Patrick","Patricia","Queso","Quiche","Rachel","Randy","Sandy","Samuel","Tammy","Thomas",
            "Udyr","Ursula","Violet","Vince","Winston","Wanda","Wendy","Xena","Xander","Zadie","Zayne"
            }; //Most common first names male and female

        private String[] lastNameList = {"Smith", "Johnson", "Williams", " Jones", "Brown",
            "Davis", "Miller", "Wilson", "Moore", "Taylor"};    //Most common last names
        
        private String[] streetList = {"Park", "Main", "Oak", "Pine", "Maple", "Cedar",
                "View", "Washington", "Lake", "Hill", "Mill"};

        private String[] streetOrientationList = {"N", "S", "E", "W"};

        private String[] streetTypeList = {"Dr","Ave"};
        
        private String[] cityList = {"Kingston", "Oakland", "Waverly", "Burlington", "Dayton", "Phoenix",
                "Las Vegas", "Los Angeles", "New York City", "Riverside", "Surprise"};

        private String[] stateList = {"Alabama", "Alaska", "Arizona", "Arkansas","California","Colorado",
                "Connecticut", "Delaware", "Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa",
                "Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota",
                "Mississippi","Missouri","Montana","Nebraska","Nevada","New Hamsphire","New Jersey","New Mexico",
                "New York","North Carolina", "North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island",
                "South Carolina", " North Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington",
                "West Virginia","Wisconsin","Wyoming"};
        
        private String[] shortStateList = {"AL", "AK", "AZ", "AR","CA","CO","CT","DE","FL","GA","HI",
                "ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM"
                ,"NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
        
        private String[] emailDomain = {"Potato", "FrenchFries", "Oops", "GetMoreRam", "NotAScam",
                "TotallyAScam","Yikes","Oof","Poke", }; //the @something.com
        
        Random random = new Random();
        
        public String generateFirstName() {
        	return firstNameList[random.nextInt(firstNameList.length)];
        }
        
        public String generateLastName() {
        	return lastNameList[random.nextInt(lastNameList.length)];
        }
        
        public int generateAge() {
        	return random.nextInt(81)+18;	//make it max of 99
        }
        
        public String generatePhoneNumber() {
            String phoneNumber = "";
            int num;
            num = random.nextInt(899) + 100;
            phoneNumber = "(" + num + ")";
            num = random.nextInt(899) + 100;
            phoneNumber += num + "-";
            num = random.nextInt(8999) + 1000;
            phoneNumber += num;
            return phoneNumber;
        }
        
        public String generateAddress() {            
            return((random.nextInt(9998)+1) + " " + streetOrientationList[random.nextInt(streetOrientationList.length)]
                    + " " +streetList[random.nextInt(streetList.length)]+ " "+streetTypeList[random.nextInt(streetTypeList.length)]+","+shortStateList[random.nextInt(shortStateList.length)]+
                    ","+Integer.toString(random.nextInt(89999)+10000));
        }
        
        public String generateEmail() {
            return "https://www." + firstNameList[random.nextInt(firstNameList.length)] + "." + lastNameList[random.nextInt(lastNameList.length)] + "@" + emailDomain[random.nextInt(emailDomain.length)] + ".com";
        }
        
    	public String generateUserName(String firstname, String lastname) {
    		return firstname+lastname.substring(0,1);
    	}
    	
    	public String generatePassword() {
    		return "123";
    	}
    	
    	public User generateUser() {
			String firstname = generateFirstName();
			String lastname = generateLastName();
			return (new User(firstname, lastname, generateAge(), generatePhoneNumber(), generateAddress(), generateEmail(), generateUserName(firstname,lastname), generatePassword()));
    	}
    	
    	public List<User> generateUsers(int amount){
    		List<User> returnList = new ArrayList<User>();
    		for (int i = 0; i < amount; i++) {
    			String firstname = generateFirstName();
    			String lastname = generateLastName();
				returnList.add(new User(firstname, lastname, generateAge(), generatePhoneNumber(), generateAddress(), generateEmail(), generateUserName(firstname,lastname), generatePassword()));
			}
    		return returnList;
    	}
}
