import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	
	//
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test 
	public void test_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		assertEquals("Player 1 wins", "player1 wins", game.getScore());		
	}	
	
	@Test 
	public void test_Player2Wins() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		assertEquals("Player 2 wins", "player2 wins", game.getScore());
		//
	}
	
	@Test
	public void test_Deuce() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Assert
		assertEquals("Examines Deuce", "deuce", game.getScore());
	}
	
	@Test
	public void test_AdvantangePlayer1() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		assertEquals("Player 1 has advantage", "player1 has advantage", game.getScore());
	}
	
	@Test
	public void test_AdvantangePlayer2() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		assertEquals("Player 2 has advantage", "player2 has advantage", game.getScore());
	}
	
	@Test
	public void test_AdvantangePlayer1_AfterTwoTimes() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		
		assertEquals("Player 1 has advantage", "player1 has advantage", game.getScore());
	}
	
	@Test
	public void test_Player1Wins_AfterTwoTimesOfAdvantage() throws TennisGameException
	{
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("Player 1 has advantage", "player1 wins", game.getScore());
	}
}
