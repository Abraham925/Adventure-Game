package game;

public class Backpack {
	//private int part1C;
	private int part2C;
	private int part3C;
	private int partFC;
	private int telescopeC;
	Part3 p3 = new Part3();
	Telescope t = new Telescope();
	Part2 p2 = new Part2();
	FinalPart f = new FinalPart();
	
	public Backpack() {
		//part1C = 0;
		part2C = 0;
		part3C = 0;
		partFC = 0;
		telescopeC = 0;
	}
	
	public void increaseCount(String x) {
		switch(x) {
			case("Piece 3"): part3C ++; break;
			case("Telescope"): telescopeC++; break;
			case("Piece 2"): part2C++; break;
			case("Final Part"): partFC++; break;
		}
	}
	public void decreaseCount(String x) {
		switch(x) {
			case("Piece 3"): part3C--; break;
			case("Telescope"): telescopeC--; break;
			case("Piece 2"): part2C--; break;
			case("Final Part"): partFC--; break;
		}
	}
	public int getCount(String x) {
		switch(x) {
			case("Piece 3"): return part3C;
			case("Telescope"): return telescopeC; 
			case("Part 2"): return part2C;
			case("Final Part"): return partFC;
		}
		return 0;
	}
	public boolean allItemsAcquired() {
		if(part2C > 0&&partFC > 0&&part3C>0) {
			return true;
		}
		return false;
		
	}
	
}
