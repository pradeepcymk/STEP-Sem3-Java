package string.assigment_problems;

import java.util.Arrays;

class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    private int[] paymentHistory;
    private int paymentCount;
    private int totalPaid;

    public GymMember(String memberId, int monthlyFee) {

        if (memberId == null
                || memberId.trim().isEmpty()
                || memberId.length() < 4) {

            throw new IllegalArgumentException(
                    "Invalid member ID"
            );
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive"
            );
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        paymentHistory = new int[10];
        paymentCount = 0;
        totalPaid = 0;
    }

    protected void recordPayment(int amount) {

        if (paymentCount < paymentHistory.length) {

            paymentHistory[paymentCount] = amount;
            paymentCount++;
        }

        totalPaid += amount;
    }

    public int[] getPaymentHistory() {

        return Arrays.copyOf(
                paymentHistory,
                paymentCount
        );
    }

    public int getTotalPaid() {

        return totalPaid;
    }
}


class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);

        this.trainerName = trainerName;
    }

    @Override
    protected void recordPayment(int amount) {

        super.recordPayment(amount / 2);
    }
}


public class GymFineLedger {

    public static void main(String[] args) {

        PremiumMember member =
                new PremiumMember(
                        "MEM5",
                        2000,
                        "Coach Riya"
                );

        member.recordPayment(100);

        System.out.println(
                member.getTotalPaid()
        );

        int[] history =
                member.getPaymentHistory();

        history[0] = 999;

        System.out.println(
                Arrays.toString(
                        member.getPaymentHistory()
                )
        );
    }
}