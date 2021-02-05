package main;

import java.util.List;

public class Player {
	
	// ATTRIBUTES
	private String name;
	private int age;
	private List<String> positions;
	private int size;
	private int weight;
	private int apps;
	private int mins;
	private int goals;
	private int assists;
	private int yellow_card;
	private int red_card;
	private int MOTM;
	private float shoots_per_match;
	private float pass_rate;
	private float aerials_duels_win;
	private float rate;

	// CONSTRUCTORS
	public Player(String name, int age, List<String> positions, int size, int weight, int apps, int mins, int goals, int assists,
			int yellow_card, int red_card, float shoots_per_match, float pass_rate, float aerials_duels_win, int mOTM,
			float rate) {
		this.name = name;
		this.age = age;
		this.positions = positions;
		this.size = size;
		this.weight = weight;
		this.apps = apps;
		this.mins = mins;
		this.goals = goals;
		this.assists = assists;
		this.yellow_card = yellow_card;
		this.red_card = red_card;
		this.shoots_per_match = shoots_per_match;
		this.pass_rate = pass_rate;
		this.aerials_duels_win = aerials_duels_win;
		MOTM = mOTM;
		this.rate = rate;
	}


	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getPositions() {
		return positions;
	}

	public void setPositions(List<String> positions) {
		this.positions = positions;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getApps() {
		return apps;
	}

	public void setApps(int apps) {
		this.apps = apps;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getYellowCard() {
		return yellow_card;
	}

	public void setYellowCard(int yellow_card) {
		this.yellow_card = yellow_card;
	}

	public int getRedCard() {
		return red_card;
	}

	public void setRedCard(int red_card) {
		this.red_card = red_card;
	}

	public float getShootsPerMatch() {
		return shoots_per_match;
	}

	public void setShootsPerMatch(float shoots_per_match) {
		this.shoots_per_match = shoots_per_match;
	}

	public float getPassRate() {
		return pass_rate;
	}

	public void setPassRate(float pass_rate) {
		this.pass_rate = pass_rate;
	}

	public float getAerialsDuelsWin() {
		return aerials_duels_win;
	}

	public void setAerialsDuelsWin(float aerials_duels_win) {
		this.aerials_duels_win = aerials_duels_win;
	}

	public int getMOTM() {
		return MOTM;
	}

	public void setMOTM(int mOTM) {
		MOTM = mOTM;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public boolean isMidfielder() {
		if (this.positions.contains("MDC") || this.positions.contains("MC")) {
			return true;
		}
		return false;
	}
	
	public boolean isLeftMiddle() {
		if (this.positions.contains("MG") || this.positions.contains("AG")) {
			return true;
		}
		return false;
	}
	
	public boolean isRightMiddle() {
		if (this.positions.contains("MD") || this.positions.contains("AD")) {
			return true;
		}
		return false;
	}
}
