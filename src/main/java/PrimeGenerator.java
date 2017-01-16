/**
 * Created by sdargo on 16/01/17.
 */
public class PrimeGenerator {

  private int[] primes;
  private int candidate;
  int numberOfPrimes;

  private int numberOfPrimesFound;
  private static int ordmax;
  private static int ord;
  private static int square;
  private static int[] mult;

  public PrimeGenerator(int numberOfPrimes) {
    this.numberOfPrimes = numberOfPrimes;
    primes = new int[numberOfPrimes + 1];
    candidate = 1;
    numberOfPrimesFound = 1;
    ordmax = 30;
    mult = new int[ordmax + 1];
    primes[1] = 2;
    ord = 2;
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
        ord++;
        square = primes[ord] * primes[ord];
        mult[ord - 1] = candidate;
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
    while (n < ord) {
      while (mult[n] < primeCandidate)
        mult[n] += primes[n] + primes[n];
      if (mult[n] == primeCandidate)
        return false;
      n++;
    }
    return true;
  }
}
