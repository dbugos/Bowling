import org.junit.Test;
import junit.framework.TestCase;

public class TestGame extends TestCase {
	
	@Test
	public void testSampleGame() {
		Game sampleGame = new Game();
		sampleGame.addPlayer("Player1");
		sampleGame.addPlayer("Player2");
		sampleGame.addPlayer("Player3");
		sampleGame.addPlayer("Player4");

		for (int i = 0; i < 10; i++) {
			for (Player p : sampleGame.getPlayers()) {
				p.playFrameRandom();
			}
		}
		assertEquals(sampleGame.getPlayers().get(0).getName(), "Player1");
	}
	
	@Test
	public void testCurrFrame() {
		Game game = new Game();
		game.addPlayer("Player1");
		game.getPlayers().get(0).playFrameRandom();
		game.getPlayers().get(0).playFrameRandom();
		game.getPlayers().get(0).playFrameRandom();
		
		assertEquals(game.getPlayers().get(0).getFrameNum(), 3);
	}
	
	@Test
	public void testPerfectGame() {
		Game game = new Game();
		game.addPlayer("Player1");
		for (int i = 0; i < 10; i++) {
			for (Player player : game.getPlayers()) {
				player.playFrameSpecific(10, 0);
			}
		}
		ScoreBoardGui.displayScoreBoard(game);
		assertEquals(game.getPlayers().get(0).getScore(), 300);
	}
	
	@Test
	public void testAlmostPerfect() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(9, 0);
		
		assertEquals(game.getPlayers().get(0).getScore(), 299);


	}
	
	@Test
	public void testTwoRounds() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 4);
		game.getPlayers().get(0).playFrameSpecific(5, 4);

		assertEquals(game.getPlayers().get(0).getScore(), 18);
	}
	
	@Test
	public void testTwoRoundsStrikes() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(10, 0);

		assertEquals(game.getPlayers().get(0).getScore(), 30);
	}
	
	@Test
	public void testTwoRoundsOneStrike() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(8, 1);

		assertEquals(game.getPlayers().get(0).getScore(), 28);
	}
	
	@Test
	public void testTwoRoundsOneStrike2() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 3);
		game.getPlayers().get(0).playFrameSpecific(10, 0);

		assertEquals(game.getPlayers().get(0).getScore(), 18);
	}
	
	@Test
	public void testTwoSpares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(3, 7);

		assertEquals(game.getPlayers().get(0).getScore(), 23);
	}
	
	@Test
	public void testManyStrikes() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(5, 3);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(5, 3);

		assertEquals(game.getPlayers().get(0).getScore(), 52);
	}
	
	@Test
	public void testManyStrikesSpares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(10, 0);
		game.getPlayers().get(0).playFrameSpecific(5, 2);
		game.getPlayers().get(0).playFrameSpecific(2, 8);
		game.getPlayers().get(0).playFrameSpecific(0, 1);
		game.getPlayers().get(0).playFrameSpecific(0, 1);
		
		assertEquals(game.getPlayers().get(0).getScore(), 76);
	}
	
	@Test
	public void test10Spares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		
		assertEquals(game.getPlayers().get(0).getScore(), 150);
	}
	
	@Test
	public void test5Spares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		
		assertEquals(game.getPlayers().get(0).getScore(), 70);
	}
	
	@Test
	public void test6Spares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);

		
		assertEquals(game.getPlayers().get(0).getScore(), 85);
	}
	
	@Test
	public void test9Spares() {
		Game game = new Game();
		game.addPlayer("P1");
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);
		game.getPlayers().get(0).playFrameSpecific(5, 5);


		
		assertEquals(game.getPlayers().get(0).getScore(), 130);
	}
	
	


}
