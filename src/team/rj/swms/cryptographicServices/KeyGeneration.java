package team.rj.swms.cryptographicServices;

import java.math.BigInteger;
import java.util.Random;

public class KeyGeneration {

	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;

	public KeyGeneration() {

		Random random = new Random();
		p = BigInteger.probablePrime(8, random);
		q = p.nextProbablePrime();
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(8, random);
		while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(phi);
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getE() {
		return e;
	}

	public BigInteger getD() {
		return d;
	}

}
