package com.splurth;

import java.util.Locale;

public class PeriodicTable {

	public boolean isValidSymbol(String elementName, String symbol){
		PeriodicTable pt=new PeriodicTable();
		String lower_case_symbol=symbol.toLowerCase();
		if(pt.checkRule1(elementName, lower_case_symbol) && pt.checkRule2(elementName, lower_case_symbol) && pt.checkRule3(elementName, lower_case_symbol) && pt.checkRule4(elementName, lower_case_symbol)){
			return true;
		}
		return false;
	}
	
	/* Rule 1: All chemical symbols must be exactly two letters, 
	 * so B is not a valid symbol for Boron.
	 */
	
	public boolean checkRule1(String elementName, String symbol){
		if(symbol.length()==2){
			return true;
		}
		return false;
	}
	
	/* Rule 2: Both letters in the symbol must appear in the element name, 
	 * but the first letter of the element name does not necessarily need to appear in the symbol. 
	 * So Hg is not valid for Mercury, but Cy is.
	 */
	
	public boolean checkRule2(String elementName, String symbol){
		String s=symbol.toLowerCase();
		String e=elementName.toLowerCase();
			if((e.indexOf(s.charAt(0))>=0) && (e.indexOf(s.charAt(1)))>=0 ){
				return true;
			}
		return false;
	}
	
	/*
	 * Rule 3: The two letters must appear in order in the element name.
	 * So Vr is valid for Silver, but Rv is not. 
	 * To be clear, both Ma and Am are valid for Magnesium, 
	 * because there is both an a that appears after an m, and an m that appears after an a
	 */
	
	public boolean checkRule3(String elementName, String symbol){
		String lower_case_symbol=symbol.toLowerCase();
		String e=elementName.toLowerCase();
		
		int lastIndex = e.indexOf(lower_case_symbol.charAt(1));
		int maxIndex=0;
		while(lastIndex >= 0) {
			maxIndex=lastIndex;
			lastIndex = e.indexOf(lower_case_symbol.charAt(1), lastIndex+1);
		}
		if(e.indexOf(lower_case_symbol.charAt(0))<=maxIndex){
			return true;
		}
		return false;
	}
	
	/* Rule 4: If the two letters in the symbol are the same, 
	 * it must appear twice in the element name. So Nn is valid for Xenon, but Xx and Oo are not.
	 */
	
	public boolean checkRule4(String elementName, String symbol){
		String lower_case_symbol=symbol.toLowerCase(Locale.US);
		if(lower_case_symbol.charAt(0)!=lower_case_symbol.charAt(1)){
			return true;
		}
		if(lower_case_symbol.charAt(0)==lower_case_symbol.charAt(1)){
			if(elementName.length() - elementName.replace(Character.toString(lower_case_symbol.charAt(0)), "").length()==2){
				return true;
			}
		}
		return false;
		
	}

}
