package composition;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import main.Player;

public class CompositionBuilder {
	
	public static List<Player> buildCompo(List<Player> allPlayers, int compNumber) {
		List<Player> res = new LinkedList<>();
		switch (compNumber) {
			case 1:
				res = buildCompo442(allPlayers);
				break;
			case 2:
				res = buildCompo433(allPlayers);
				break;
			case 3:
				res = buildCompo4231(allPlayers);
				break;
	
			default:
				break;
		}
		
		return res;
	}
	
	private static List<Player> buildCompo442(List<Player> allPlayers) {
		List<Player> res = new LinkedList<>();
		
		// Build the composition ===================================
		// Choose the GK
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("G"))
						           .collect(Collectors.toList()).get(0));
		// Choose the DG
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DG"))
								   .filter(p -> !res.contains(p))
								   .collect(Collectors.toList()).get(0));
		// Choose the 2 DC
		List<Player> cb = allPlayers.stream().filter(p -> p.getPositions().contains("DC"))
						                     .filter(p -> !res.contains(p))
		                                     .collect(Collectors.toList());
		res.add(cb.get(0));
		res.add(cb.get(1));
		// Choose the DD
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DD"))
						           .filter(p -> !res.contains(p))
						           .collect(Collectors.toList()).get(0));
		// Choose the 2 MDC/MC
		List<Player> cm = allPlayers.stream().filter(p -> p.isMidfielder())
						            .filter(p -> !res.contains(p))
						            .collect(Collectors.toList());
		res.add(cm.get(0));
		res.add(cm.get(1));
		// Choose the AG/MG
		res.add(allPlayers.stream().filter(p -> p.isLeftMiddle())
						           .filter(p -> !res.contains(p))
						           .collect(Collectors.toList()).get(0));
		// Choose the AD/MD
		res.add(allPlayers.stream().filter(p -> p.isRightMiddle())
						           .filter(p -> !res.contains(p))
						           .collect(Collectors.toList()).get(0));
		// Choose the 2 BU
		List<Player> st = allPlayers.stream().filter(p -> p.getPositions().contains("BU"))
				 							 .filter(p -> !res.contains(p))
											 .collect(Collectors.toList());
		res.add(st.get(0));
		res.add(st.get(1));
		
		return res;
	}
	
	private static List<Player> buildCompo4231(List<Player> allPlayers) {
		List<Player> res = new LinkedList<>();
		
		// Build the composition =================================
		// Choose the GK
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("G"))
								   .collect(Collectors.toList()).get(0));
		// Choose the DG
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DG"))
								   .filter(p -> !res.contains(p))
								   .collect(Collectors.toList()).get(0));
		// Choose the 2 DC
		List<Player> cb = allPlayers.stream().filter(p -> p.getPositions().contains("DC"))
											 .filter(p -> !res.contains(p))
				                             .collect(Collectors.toList());
		res.add(cb.get(0));
		res.add(cb.get(1));
		// Choose the DD
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DD"))
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the 2 MDC
		List<Player> cm = allPlayers.stream().filter(p -> p.getPositions().contains("MDC"))
				 							 .filter(p -> !res.contains(p))
											 .collect(Collectors.toList());
		res.add(cm.get(0));
		res.add(cm.get(1));
		// Choose the MOC
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("MOC"))
				.filter(p -> !res.contains(p))
				.collect(Collectors.toList()).get(0));
		// Choose the AG/MG
		res.add(allPlayers.stream().filter(p -> p.isLeftMiddle())
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the AD/MD
		res.add(allPlayers.stream().filter(p -> p.isRightMiddle())
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the BU
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("BU"))
				 				   .filter(p -> !res.contains(p))
							       .collect(Collectors.toList()).get(0));
		
		return res;
	}

	private static List<Player> buildCompo433(List<Player> allPlayers) {
		List<Player> res = new LinkedList<>();
		
		// Build the composition =================================
		// Choose the GK
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("G"))
								   .collect(Collectors.toList()).get(0));
		// Choose the DG
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DG"))
								   .filter(p -> !res.contains(p))
								   .collect(Collectors.toList()).get(0));
		// Choose the 2 DC
		List<Player> cb = allPlayers.stream().filter(p -> p.getPositions().contains("DC"))
											 .filter(p -> !res.contains(p))
				                             .collect(Collectors.toList());
		res.add(cb.get(0));
		res.add(cb.get(1));
		// Choose the DD
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("DD"))
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the MDC
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("MDC"))
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the 2 MDC/MC
		List<Player> cm = allPlayers.stream().filter(p -> p.isMidfielder())
				 							 .filter(p -> !res.contains(p))
											 .collect(Collectors.toList());
		res.add(cm.get(0));
		res.add(cm.get(1));
		// Choose the AG/MG
		res.add(allPlayers.stream().filter(p -> p.isLeftMiddle())
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the AD/MD
		res.add(allPlayers.stream().filter(p -> p.isRightMiddle())
				 				   .filter(p -> !res.contains(p))
				 				   .collect(Collectors.toList()).get(0));
		// Choose the BU
		res.add(allPlayers.stream().filter(p -> p.getPositions().contains("BU"))
				 				   .filter(p -> !res.contains(p))
							       .collect(Collectors.toList()).get(0));
		
		return res;
	}
}
