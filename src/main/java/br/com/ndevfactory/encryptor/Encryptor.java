package br.com.ndevfactory.encryptor;

public class Encryptor {
	
	private static final String HEXADECIMAL_BASE = "0123456789ABCDEF";
	
	private String key;
	
	protected String toBin(String text) {
		String textReverse = new StringBuilder(text).reverse().toString();
		String textBin = "";
		int intKey;
		char charOne;
		int beginIndex;
		
		for (int i = 1; i <= textReverse.length(); i++) {
			beginIndex = (i % this.key.length());
			charOne = this.key.substring(beginIndex, beginIndex + 1).charAt(0);
			intKey = ((int) charOne) + i;
			textBin += (char) (((int) textReverse.charAt(i - 1)) ^ intKey);  
		}
		
		return textBin;
	}
	
	protected int toDec(String number) {
		String numberUpper = number.toUpperCase();
		int dec = (HEXADECIMAL_BASE.indexOf(numberUpper.charAt(0))) * 16;
		dec += (HEXADECIMAL_BASE.indexOf(numberUpper.charAt(1)));
		return dec;
	}
	
	protected String toHex(int number) {
		int beginIndex = number % 16;
		String hex = HEXADECIMAL_BASE.substring(beginIndex, beginIndex + 1);
		number = (int) (number / 16);
		beginIndex = number % 16;
		hex = HEXADECIMAL_BASE.substring(beginIndex, beginIndex + 1) + hex;
		return hex;
	}
	
	protected String toText(String bin) {
		String text = "";
		int intkey;
		char charOne;
		int beginIndex;
		
		for (int i = 1; i <= bin.length(); i++) {
			beginIndex = (i % this.key.length());
			charOne = this.key.substring(beginIndex, beginIndex + 1).charAt(0);
			intkey = ((int)charOne) + i;
			text += (char) (((int) bin.charAt(i - 1)) ^ intkey); 
		}
		
		return new StringBuilder(text).reverse().toString();
	}
	
	public String convertToHex(String text) {
		String textBin = toBin(text);
		String textRet = "";
		
		for (int i = 0; i < textBin.length(); i++) {
			textRet += toHex((int) textBin.charAt(i));
		}
		
		return textRet;
	}
	
	public String convertToText(String hex) {
		String textBin = "";
		int beginIndex;
		
		for (int i = 1; i <= (hex.length() / 2); i++) {
			beginIndex = (i * 2) - 1; 
			textBin += (char) (toDec(hex.substring(beginIndex - 1, beginIndex + 1)));
		}
		
		return toText(textBin);
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

}
