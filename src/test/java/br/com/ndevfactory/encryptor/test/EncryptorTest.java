package br.com.ndevfactory.encryptor.test;

import static org.junit.Assert.*;

import org.junit.*;

import br.com.ndevfactory.encryptor.Encryptor;

public class EncryptorTest {
	
	private static final String KEY = "#@123";
	
	private static final String TEXT_NORMAL = "TEXT NORMAL";
	private static final String TEXT_HEXDECIMAL = "0D7278656708186E64681F";
	
	private Encryptor encryptor;
	
	@Before
	public void init() {
		this.encryptor = new Encryptor();
		this.encryptor.setKey(KEY);
	}
	
	@Test
	public void deveConverterTextoParaHexadecimal() {
		assertEquals(TEXT_HEXDECIMAL, this.encryptor.convertToHex(TEXT_NORMAL));
	}
	
	@Test
	public void deveConverterHexadecimalParaTexto() {
		assertEquals(TEXT_NORMAL, this.encryptor.convertToText(TEXT_HEXDECIMAL));
	}

}
