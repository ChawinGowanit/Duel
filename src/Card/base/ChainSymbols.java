package Card.base;

import java.util.ArrayList;

public class ChainSymbols {
	public ArrayList<String> chainSymbol ;
	
	public ChainSymbols() {
		this.chainSymbol = new ArrayList<String>() ;
	}
	public ChainSymbols(String chainSymbol1,String chainSymbol2) {
		this.chainSymbol.add(chainSymbol1) ;
		this.chainSymbol.add(chainSymbol2) ;
	}
	public void addChainSymbols(String chainSymbol1) {
		this.chainSymbol.add(chainSymbol1) ;
	}
	public ArrayList<String> getChainSymbol() {
		return this.chainSymbol;
	}
}
