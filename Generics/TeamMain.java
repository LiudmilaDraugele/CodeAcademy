
public class TeamMain {

	public static void main(String[] args) {
		
		Team<BasketballPlayer> zalgiris = new Team<>("Zalgiris");
		Team<BasketballPlayer> rytas = new Team<>("Rytas");
		
		BasketballPlayer jankunas = new BasketballPlayer("Jankunas", 207, 120.00);
		BasketballPlayer sabonis = new BasketballPlayer("Sabonis", 210, 130.00);
		
		BasketballPlayer vienas = new BasketballPlayer("Jankunas", 207, 120.00);
		BasketballPlayer du = new BasketballPlayer("Sabonis", 210, 130.00);
		
		zalgiris.addPlayer(sabonis);
		zalgiris.addPlayer(jankunas);
		rytas.addPlayer(vienas);
		rytas.addPlayer(du);
		
		Team<FootballPlayer> real = new Team<>("Real Madrid");
		
		FootballPlayer messi = new FootballPlayer ("Messi", 180, 75.00);
		FootballPlayer ronaldo = new FootballPlayer ("Ronaldo", 180, 75.00);
		
		real.addPlayer(ronaldo);
		real.addPlayer(messi);
		

		zalgiris.playMatch(rytas, 66, 88);
	}

}
