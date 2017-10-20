package arrays;

public class Person {

	public static final String[] FIRST_START = {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE = {"isti","icha","era","eta","ala","ina","ara"};
	public static final String[] FIRST_END = {"","na","n","r","tian","s","rs","mp","les"};

	public static final String[] LAST_START = {"Tr","Br","L","Gr","Sh","B","Th"};
	public static final String[] LAST_MIDDLE = {"om","o","an","ola","et","e","is"};
	public static final String[] LAST_END = {"","son","ers","rian","ston","ck","sk"};


	private String firstName;
	private String lastName;
	private Borough home;
	private String nickname;

	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.nickname = createNickname(firstName);
	}
	
	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname = createNickname(firstName);
	}



	//JAVA IS PASS-BY-VALUE
	//meaning the parameters of a method are just values, not references
	//so if you change those values, the original object is not affected.
	//In this case, 'name' will not be changed. In fact, NOTHING can change
	//this.firstName via name
	public static String createNickname(String name) {
		String nickname = "";
		int secondVowelPsn = findSecond(name);
		
		nickname = name.substring(0,secondVowelPsn);
		return nickname;
	}

	private static int findSecond(String word) {
		boolean foundVowel = false;
		word = word.toLowerCase();
		int index = word.length();
		for(int i = 0; i < word.length(); i++) {
			if(word.substring(i, i+1).equals("a") ||
					word.substring(i, i+1).equals("e") ||
					word.substring(i, i+1).equals("i") ||
					word.substring(i, i+1).equals("o") ||
					word.substring(i, i+1).equals("u")) {
				if(!foundVowel) {
					foundVowel = true;
				}else {
					return i;
				}
			}
		}
		return index;
	}

	public String toString() {
		return "My name is "+firstName+" "+lastName+". Call me "+nickname+". and I live in "+home+".";
	}
	
	
	
	
	
	
	

}
