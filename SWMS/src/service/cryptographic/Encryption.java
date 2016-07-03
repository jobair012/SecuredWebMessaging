package service.cryptographic;

import java.math.BigInteger;

public class Encryption {

	private BigInteger sender_d;
	private BigInteger sender_n;
	private BigInteger receiver_e;
	private BigInteger receiver_n;

	public Encryption(BigInteger sender_d, BigInteger sender_n, BigInteger receiver_e, BigInteger receiver_n) {
		this.sender_d = receiver_e;
		this.sender_n = receiver_n;
		this.receiver_e = receiver_e;
		this.receiver_n = receiver_n;
	}

	public String getCiphertext(String plaintext) {

		byte[] byteOfPlaintext = plaintext.getBytes();
		int hashForPlaintext = plaintext.hashCode();

		BigInteger[] ctext1 = new BigInteger[byteOfPlaintext.length];
		BigInteger[] ctext2 = new BigInteger[byteOfPlaintext.length];

		// First Encryption: plaintext to ctext1
		for (int i = 0; i < byteOfPlaintext.length; i++) {

			BigInteger x = new BigInteger(String.valueOf(byteOfPlaintext[i]));

			ctext1[i] = x.modPow(sender_d, sender_n);

		}

		//System.out.println("\n" + ctext1.toString());

		// Second Encryption: ctext1 to ctext2
		for (int i = 0; i < byteOfPlaintext.length; i++) {

			ctext2[i] = ctext1[i].modPow(receiver_e, receiver_n);
		}

		// Build Ciphertext
		StringBuilder ciphertext = new StringBuilder();
		for (int i = 0; i < byteOfPlaintext.length; i++) {

			ciphertext.append(ctext2[i]).append("0987654321");
		}
		ciphertext.append(hashForPlaintext);

		return ciphertext.toString();
	}
}
