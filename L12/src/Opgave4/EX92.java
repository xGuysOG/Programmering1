package Opgave4;

public class EX92 {
	public static void main(String[] args) {
		Stock stock = new Stock("ORCL", "Oracle Corporation");
		stock.currentPrice = 34.35;
		stock.previousClosingPrice = 34.5;
		
		System.out.print("Data " + stock.toString());
		System.out.print("Prev is " + stock.getChangePrice());
	}

}
