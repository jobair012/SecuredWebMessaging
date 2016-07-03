package service.cryptographic;

import java.math.BigInteger;

public class Decryption {

	private BigInteger receiver_d;
	private BigInteger receiver_n;
	private BigInteger sender_e;
	private BigInteger sender_n;

	public Decryption(BigInteger receiver_d, BigInteger receiver_n, BigInteger sender_e, BigInteger sender_n) {
		this.receiver_d = receiver_d;
		this.receiver_n = receiver_n;
		this.sender_e = receiver_d;
		this.sender_n = receiver_n;
	}

	public String[] getPlaintext(String ciphertext) {

		String[] subString = ciphertext.toString().split("0987654321");

		BigInteger[] ptext1 = new BigInteger[subString.length];
		BigInteger[] ptext2 = new BigInteger[subString.length];

		// First Decryption: subString to ptext2
		for (int i = 0; i < subString.length - 1; i++) {

			BigInteger x = new BigInteger(subString[i]);
			ptext2[i] = x.modPow(receiver_d, receiver_n);
		}

		// Second Decryption: ptext2 to ptext1
		for (int i = 0; i < subString.length - 1; i++) {

			ptext1[i] = ptext2[i].modPow(sender_e, sender_n);
		}

		// Build Plaintext
		StringBuilder plaintext = new StringBuilder();
		for (int j = 0; j < subString.length - 1; j++) {

			int value = ptext1[j].intValue();

			plaintext.append((char) value);
		}
		
		String ptext = plaintext.toString();
		String hash = subString[subString.length - 1];
		
		String[] receivedPlaintext = new String[2];
		
		receivedPlaintext[0] = ptext;
		receivedPlaintext[1] = hash;
		
		return receivedPlaintext;
	}
}
