public class PrimePrinter {
  public static void main(String[] args) {
    int numberOfPrimes = 1000;
    int[] primes = (new PrimeGenerator(numberOfPrimes)).generate();
    (new NumberPrinter()).printNumbers(numberOfPrimes, primes);
  }
}

