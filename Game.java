import java.util.ArrayList;

public class Game {

	private static final int MAX_PLAYERS = 6;
	private static final int MAX_FRAMES = 10;
	private ArrayList<Player> players;

	// Sum of all players' scores. For team-based competition.
	public int totalScore;

	public Game() {
		this.players = new ArrayList<Player>();
		totalScore = 0;
	}

	// Getters and Setters
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getNumPlayers() {
		return players.size();
	}
	
	public int getTotalScore() {
		for (Player player : players) {
			totalScore += player.getScore();
		}
		return totalScore;
	}


	// Adds player with specific name to ArrayList<> players
	// Six players max per lane
	public void addPlayer(String nameIn) {
		if (players.size() < MAX_PLAYERS) {
			Player p = new Player(nameIn);
			this.players.add(p);
		} else {
			System.out.println("Sorry, only 6 players per game");
		}
	}

	// Displays a score-board of the game at any time.
	public static void printScoreboard(Game game) {
		for (Player p : game.players) {
			System.out.print(p.getName() + ": | ");
			for (int i = 0; i < p.getFrameNum(); i++) {
				if (i == 9) {
					System.out.print(
							p.getCurrFrame().getFirstRoll() + " , " + p.getCurrFrame().getSecondRoll() + " , " + p.getCurrFrame().getThirdRoll() + "|" + " ");
				} else {
					System.out.print(
							p.getCurrFrame().getFirstRoll() + " , " + p.getCurrFrame().getSecondRoll() + "|" + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Game sampleGame = new Game();
		sampleGame.addPlayer("Player1");
		sampleGame.addPlayer("Player2");
		sampleGame.addPlayer("Player3");
		sampleGame.addPlayer("Player4");

		for (int i = 0; i < MAX_FRAMES; i++) {
			for (Player p : sampleGame.players) {
				p.playFrameRandom();
			}
		}
		ScoreBoardGui.displayScoreBoard(sampleGame);

		printScoreboard(sampleGame);
		System.out.println();
		System.out.println();

		Game sampleGame2 = new Game();
		sampleGame2.addPlayer("Player1");
		for (int i = 0; i < MAX_FRAMES; i++) {
			for (Player p : sampleGame2.players) {
				p.playFrameSpecific(5, 5);
			}
		}
		printScoreboard(sampleGame2);
		System.out.println();
		System.out.println();

		Game sampleGame3 = new Game();
		sampleGame3.addPlayer("Player1");
		for (int i = 0; i < MAX_FRAMES; i++) {
			for (Player p : sampleGame2.players) {
				p.playFrameSpecific(5, 5);
			}
		}

		Game sampleGame4 = new Game();
		sampleGame4.addPlayer("Player1");
		sampleGame4.getPlayers().get(0).playFrameRandom();

		Game sampleGame5 = new Game();
		sampleGame5.addPlayer("Player1");
		for (int i = 0; i < 10; i++) {
			for (Player player : sampleGame5.getPlayers()) {
				player.playFrameSpecific(10, 0);
			}
		}
		ScoreBoardGui.displayScoreBoard(sampleGame5);
	}

}
