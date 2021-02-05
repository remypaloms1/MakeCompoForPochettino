package composition;

import java.util.List;
import main.Player;

public class CompositionPrinter {
	
	public static void outputCompo(List<Player> allPlayers, int compNumber) {
		switch (compNumber) {
		case 1:
			printComp442(allPlayers);
			break;
		case 2:
			printComp433(allPlayers);
			break;
		case 3:
			printComp4231(allPlayers);
			break;
		default:
			break;
		}
	}

	private static void printComp442(List<Player> allPlayers) {
		System.out.println("               " + allPlayers.get(9).getName() + "      " + 
									allPlayers.get(10).getName());
		System.out.println();
		
		System.out.println("   " + allPlayers.get(7).getName() + "                          " + 
								  allPlayers.get(8).getName());
		System.out.println();
		
		System.out.println("           " + allPlayers.get(5).getName() + "        " + 
				                    allPlayers.get(6).getName());
		System.out.println();
		
		System.out.println("   " + allPlayers.get(1).getName() + "    " +
								  allPlayers.get(2).getName() + "    " +
								  allPlayers.get(3).getName() + "    " +
								  allPlayers.get(4).getName());
		System.out.println();
		
		System.out.println("                    " + allPlayers.get(0).getName());
	}
	
	private static void printComp4231(List<Player> allPlayers) {
		System.out.println("                   " + allPlayers.get(10).getName());
		System.out.println();
		
		System.out.println("   " + allPlayers.get(8).getName() + "          " +
				                  allPlayers.get(7).getName() + "          " +
					              allPlayers.get(9).getName());
		System.out.println();
		
		System.out.println("            " + allPlayers.get(5).getName() + "       " + 
		                            allPlayers.get(6).getName());
		System.out.println();
		
		System.out.println("   " + allPlayers.get(1).getName() + "    " +
					              allPlayers.get(2).getName() + "    " +
					              allPlayers.get(3).getName() + "    " +
					              allPlayers.get(4).getName() + "    ");
		System.out.println();
		
		System.out.println("                    " + allPlayers.get(0).getName());	
	}
	
	private static void printComp433(List<Player> allPlayers) {
		System.out.println("                    " + allPlayers.get(10).getName());
		System.out.println();
		
		System.out.println("     " + allPlayers.get(8).getName() + "                         " +
					              allPlayers.get(9).getName());
		System.out.println();
		
		System.out.println("              " + allPlayers.get(6).getName() + "       " + 
                allPlayers.get(7).getName());
		
		System.out.println("                    " + allPlayers.get(5).getName());
		System.out.println();
		
		System.out.println("   " + allPlayers.get(1).getName() + "    " +
					              allPlayers.get(2).getName() + "    " +
					              allPlayers.get(3).getName() + "    " +
					              allPlayers.get(4).getName() + "    ");
		System.out.println();
		
		System.out.println("                    " + allPlayers.get(0).getName());
		
	}
}
