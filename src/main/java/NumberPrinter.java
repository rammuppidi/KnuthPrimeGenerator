/**
 * Created by sdargo on 16/01/17.
 */
public class NumberPrinter {
  private int pageNumber;
  private int pageOffset;
  private int rowOffset;
  private int numberOfRowsOnPage;
  private int numberOfColumns;

  public NumberPrinter() {
    pageNumber = 1;
    pageOffset = 1;
    numberOfRowsOnPage = 50;
    numberOfColumns = 4;
  }

  public void printNumbers(int numberOfNumbersToPrint, int[] numbersToPrint) {
    while (pageOffset <= numberOfNumbersToPrint) {
      printPage(numberOfNumbersToPrint, numbersToPrint);
    }
  }

  private void printPage(int numberOfNumbersToPrint, int[] numbersToPrint) {
    printPageHeader(numberOfNumbersToPrint);
    printPageBody(numberOfNumbersToPrint, numbersToPrint);
    printPageFooter();
  }

  private void printPageHeader(int numberOfNumbersToPrint) {
    System.out.println("The First " + Integer.toString(numberOfNumbersToPrint) + " Prime Numbers --- Page "
        + Integer.toString(pageNumber));
  }

  private void printPageBody(int numberOfNumbersToPrint, int[] numbersToPrint) {
    for (rowOffset = pageOffset; rowOffset <= pageOffset + numberOfRowsOnPage -1; rowOffset++) {
      printRow(numberOfNumbersToPrint, numbersToPrint);
    }
    turnPage();
  }

  private void printRow(int numberOfNumbersToPrint, int[] numbersToPrint) {
    for (int columnNumber =0; columnNumber <= numberOfColumns -1; columnNumber++)
      if (rowOffset + columnNumber * numberOfRowsOnPage <= numberOfNumbersToPrint)
        System.out.printf("%10d", numbersToPrint[rowOffset + columnNumber * numberOfRowsOnPage]);
    System.out.println();
  }

  private void turnPage() {
    pageNumber++;
    pageOffset += numberOfRowsOnPage * numberOfColumns;
  }

  private void printPageFooter() {
    System.out.println("\f");
  }
}
