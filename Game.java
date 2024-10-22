import java.io.*;

public class Game {
	public static void main(String[] args) {
		System.out.println("Countries Game");
		Console console = System.console();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("continents.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				String country = cols[0];
				String continent = cols[1];
				String answer = null;
				do {
					answer = console.readLine("Which continent does " + country + " belong to? ");
					if (answer.equalsIgnoreCase("help")) {
						printHelp();
					}
				} while (answer.equalsIgnoreCase("help"));
				if (answer.equalsIgnoreCase(continent)) {
					System.out.println("Correct!");
				} else {
					System.out.println("No, the answer is " + continent);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printHelp() {
		System.out.println("Guess the continent");
		System.out.println("Type 'exit' to stop the game or 'help' to get this text.");
	}
}
