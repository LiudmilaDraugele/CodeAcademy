import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<T>{
	
	private String name;
	int player = 0;
	int won = 0;
	int lost = 0;
	int tied = 0;
	
	private ArrayList<T> members;

	public Team(String name) {
		super();
		this.name = name;
		this.members = new ArrayList<>();
	}

	public void addPlayer(T player) {
		members.add(player);
		System.out.println(((Player) player).getName() + " was added to " + name);
		
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getTied() {
		return tied;
	}

	public void setTied(int tied) {
		this.tied = tied;
	}

	public ArrayList<T> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<T> members) {
		this.members = members;
	}
	
	public void playMatch (Team<T> opponent, Integer ourScore, Integer theirScore) {
		if (ourScore > theirScore) {
			won++;
			return;
		}
		else if (ourScore ==theirScore) {
			return;
		}else {
			opponent.playMatch(null, theirScore, ourScore);
		}
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
