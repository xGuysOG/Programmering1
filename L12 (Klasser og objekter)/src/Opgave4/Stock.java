package Opgave4;

public class Stock {
	
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	
	public Stock(String symbol, String name) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public double getChangePrice() {
		return ((currentPrice - previousClosingPrice) / 
				previousClosingPrice) * 100;
	}
	
//	Stock
//	symbol: String
//	name: String
//	previousClosingPrice: double
//	currentPrice: double
//	+ Stock(symbol: String, name: String)
//	+ toString(): String
//	+ getChangePrice(): double
	
    @Override
    public String toString() {
        return String.format("Employee(%s, %s, %s, %s)", symbol, name, previousClosingPrice, currentPrice);
    }
	
	

}
