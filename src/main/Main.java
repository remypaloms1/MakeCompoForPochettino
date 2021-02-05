package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import composition.*;

public class Main {
	static final String FILE_PATH = System.getProperty("user.dir") + "/STATS/";
	static final String FILE_NAME = "PSG_20_21_STATS_05_Fevrier.csv";
	
	static final int POSITION_ATTR_PLAYER = 0;
	static final int POSITION_ATTR_AGE = 1;
	static final int POSITION_ATTR_POSITION = 2;
	static final int POSITION_ATTR_SIZE = 3;
	static final int POSITION_ATTR_WEIGHT = 4;
	static final int POSITION_ATTR_APPS = 5;
	static final int POSITION_ATTR_MINS = 6;
	static final int POSITION_ATTR_GOALS = 7;
	static final int POSITION_ATTR_ASSISTS = 8;
	static final int POSITION_ATTR_YEL_CARD = 9;
	static final int POSITION_ATTR_RED_CARD = 10;
	static final int POSITION_ATTR_SHOOTS = 11;
	static final int POSITION_ATTR_PASSRATE = 12;
	static final int POSITION_ATTR_DUELS = 13;
	static final int POSITION_ATTR_MOTM = 14;
	static final int POSITION_ATTR_RATE = 15;
	
	// ============================================================================
	// MAIN METHOD
	// ============================================================================
	public static void main(String[] args) {
		// INPUT ======================================
		boolean correctInput = false;
		System.out.println("==> Please choose a composition by typing the associated number :");
		System.out.println("1 : 4-4-2");
		System.out.println("2 : 4-3-3");
		System.out.println("3 : 4-2-3-1");
		int compNumber = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!correctInput) {
			try {
				System.out.print("==> Your choice : ");
				compNumber = Integer.parseInt(sc.nextLine());
				if (!(compNumber > 0 && compNumber < 4)) {
					System.out.println("[ERROR] Invalid number ! Please enter again :");
				}
				else {
					correctInput = true;
				}
			}
			catch (NumberFormatException n) {
				System.out.println("Please enter a number !");
			}
		}
		
		correctInput = false;
		System.out.println("==> How do you want to build your composition ?");
		System.out.println("1 : Players with the best rates");
		System.out.println("2 : Younger Players ");
		System.out.println("3 : Oldest Players");
		System.out.println("4 : Best pass accuracy");
		System.out.println("5 : Most appearance");
		int sortNumber = 0;
		
		while(!correctInput) {
			try {
				System.out.print("==> Your choice : ");
				sortNumber = Integer.parseInt(sc.nextLine());
				if (!(sortNumber > 0 && sortNumber < 6)) {
					System.out.println("[ERROR] Invalid number ! Please enter again :");
				}
				else {
					correctInput = true;
				}
			}
			catch (NumberFormatException n) {
				System.out.println("Please enter a number !");
			}
		}
		sc.close();
		
		// PARSING DATA =================================
		List<Player> allPlayers = convertListToPlayers(csvReader());
		
		// ANALYSE DATA =================================
		// Sort all players by their Rate
		sortPlayers(allPlayers, sortNumber);
		
		// Build the final Composition
		allPlayers = CompositionBuilder.buildCompo(allPlayers, compNumber);
		
		// OUTPUT =======================================
		CompositionPrinter.outputCompo(allPlayers, compNumber);
	}
	// ============================================================================
	
	private static List<List<String>> csvReader() {
		List<List<String>> allPlayers = new ArrayList<>();
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME));
		    String line = br.readLine(); // Not the first line
		    
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(";");
		        allPlayers.add(Arrays.asList(values));
		    }
		    br.close();
		    		    
		} catch (FileNotFoundException e) {
			System.out.println("File not found !");
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		
		return allPlayers;
	}
	
	private static List<Player> convertListToPlayers(List<List<String>> listPlayers) {
		List<Player> res = new LinkedList<>();
		listPlayers.stream().forEach(l -> createPlayer(res, l));
		
		return res;
	}
	
	private static void createPlayer(List<Player> players, List<String> l) {
		Player p = new Player();
		
		for (int i = 0; i<l.size(); i++) {
			switch (i) {
			case POSITION_ATTR_PLAYER:
				p.setName(l.get(i));
				break;
			// ==========================================	
			case POSITION_ATTR_AGE:
				p.setAge(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_SIZE:
				p.setSize(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_WEIGHT:
				p.setWeight(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_APPS:
				p.setApps(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_GOALS:
				p.setGoals(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_ASSISTS:
				p.setAssists(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_MOTM:
				p.setMOTM(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_MINS:
				p.setMins(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_YEL_CARD:
				p.setYellowCard(Integer.parseInt(l.get(i)));
				break;
			case POSITION_ATTR_RED_CARD:
				p.setRedCard(Integer.parseInt(l.get(i)));
				break;
			// ==================================================
			case POSITION_ATTR_DUELS:
				p.setAerialsDuelsWin(Float.parseFloat(l.get(i)));
				break;
			case POSITION_ATTR_PASSRATE:
				p.setPassRate(Float.parseFloat(l.get(i)));
				break;
			case POSITION_ATTR_RATE:
				p.setRate(Float.parseFloat(l.get(i)));
				break;
			case POSITION_ATTR_SHOOTS:
				p.setShootsPerMatch(Float.parseFloat(l.get(i)));
				break;
			// ==================================================
			case POSITION_ATTR_POSITION:
				p.setPositions(Arrays.asList(l.get(i).split(",")));
				break;
			default:
				break;
			}
		}
		players.add(p);
	}
	
	private static void sortPlayers(List<Player> allPlayers, int sortNumber) {
		switch (sortNumber) {
		// Players with the best rates
		case 1:
			allPlayers.sort((p1, p2) -> Float.compare(p2.getRate(), p1.getRate()));
			break;
		// Younger Players
		case 2:
			allPlayers.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
			break;
		// Oldest Players
		case 3:
			allPlayers.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));
			break;
		// Best pass accuracy
		case 4:
			allPlayers.sort((p1, p2) -> Float.compare(p2.getPassRate(), p1.getPassRate()));
			break;
		// Most appearance
		case 5:
			allPlayers.sort((p1, p2) -> Integer.compare(p2.getApps(), p1.getApps()));
			break;
		default:
			break;
		}
	}
}
