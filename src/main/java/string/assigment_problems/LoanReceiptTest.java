package string.assigment_problems;

import java.util.Arrays;

class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;
    private final double totalFine;
    private final long issuedAt;

    LoanReceipt(String memberId, String[] bookIds, double totalFine, long issuedAt) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
        this.totalFine = totalFine;
        this.issuedAt = issuedAt;
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public double getTotalFine() {
        return totalFine;
    }

    public long getIssuedAt() {
        return issuedAt;
    }

    public LoanReceipt withCorrectedBookId(int index, String newBookId) {
        String[] correctedBooks = Arrays.copyOf(bookIds, bookIds.length);
        correctedBooks[index] = newBookId;

        return new LoanReceipt(
                memberId,
                correctedBooks,
                totalFine,
                issuedAt
        );
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            double totalFine,
            long issuedAt) {

        super(memberId, bookIds, totalFine, issuedAt);
    }
}

class CirculationLedger {

    static {
        System.out.println("Nightly circulation ledger initialized");
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }
}

public class LoanReceiptTest {

    public static void main(String[] args) {

        String[] books = {"BOOK-101", "BOOK-102"};

        LoanReceipt receipt = new LoanReceipt(
                "LIB-1001",
                books,
                25.0,
                System.currentTimeMillis()
        );

        books[0] = "HACKED-BOOK";

        System.out.println("Original first book: "
                + receipt.getBookIds()[0]);

        String[] returnedBooks = receipt.getBookIds();
        returnedBooks[1] = "HACKED-AGAIN";

        System.out.println("Second book after getter test: "
                + receipt.getBookIds()[1]);

        LoanReceipt corrected =
                receipt.withCorrectedBookId(0, "BOOK-999");

        System.out.println("Corrected first book: "
                + corrected.getBookIds()[0]);

        System.out.println("Original first book remains: "
                + receipt.getBookIds()[0]);

        ReferenceOnlyLoanReceipt referenceReceipt =
                new ReferenceOnlyLoanReceipt(
                        "LIB-2002",
                        new String[]{"BOOK-201"},
                        0.0,
                        System.currentTimeMillis()
                );

        LoanReceipt[] receipts = {
                referenceReceipt,
                null,
                receipt
        };

        System.out.println(
                CirculationLedger.processNightlyCirculation(receipts)
        );
    }
}