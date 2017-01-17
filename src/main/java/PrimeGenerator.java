/**
 * Created by sdargo on 16/01/17.
 */
public class PrimeGenerator {

  private int[] primes;
  private int candidate;
  int numberOfPrimes;

  private int numberOfPrimesFound;
  private int ordinal;
  private int square;
  private int[] multiples;

  public PrimeGenerator(int numberOfPrimes) {
    this.numberOfPrimes = numberOfPrimes;
    this.primes = new int[numberOfPrimes + 1];
    this.candidate = 1;
    this.numberOfPrimesFound = 1;
    int ordmax = 30;
    this.multiples = new int[ordmax + 1];
    primes[1] = 2;
    ordinal = 2;
    square = 9;
  }

  public int[] generate() {
    while (numberOfPrimesFound < numberOfPrimes) {
      findNextPrime();
    }
    return primes;
  }

  private void findNextPrime() {
    do {
      candidate += 2;
      if (candidate == square) {
        ordinal++;
        square = primes[ordinal] * primes[ordinal];
        multiples[ordinal - 1] = candidate;
      }
    } while (!isCandidatePrime(candidate));
    savePrime(candidate);
  }

  private void savePrime(int prime) {
    numberOfPrimesFound++;
    primes[numberOfPrimesFound] = prime;
  }

  private boolean isCandidatePrime(int primeCandidate) {
    int n = 2;
    while (n < ordinal) {
      while (multiples[n] < primeCandidate)
        multiples[n] += primes[n] + primes[n];
      if (multiples[n] == primeCandidate)
        return false;
      n++;
    }
    return true;
  }
}
