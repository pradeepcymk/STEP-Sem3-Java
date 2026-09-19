package string.assigment_problems;

class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

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
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
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
}


public class GymMembershipValidator {

    static String signUpBatch(
            String[] memberIds,
            int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {

                new GymMember(
                        memberId,
                        monthlyFee
                );

                signedUp++;

            } catch (IllegalArgumentException e) {

                rejected++;
            }
        }

        return "Signed Up: "
                + signedUp
                + " | Rejected: "
                + rejected;
    }


    public static void main(String[] args) {

        GymMember member =
                new GymMember("MEM10", 1000);

        member.attendSession();
        member.attendSession();

        System.out.println(
                member.getSessionsAttended()
        );


        PremiumMember premium =
                new PremiumMember(
                        "MEM01",
                        2000,
                        "Coach Riya"
                );

        premium.attendSession();
        premium.attendSession();

        System.out.println(
                premium.getSessionsAttended()
        );


        String[] memberIds = {
                "MEM1",
                "GM1",
                "MEM2",
                " ",
                "MEM3"
        };

        System.out.println(
                signUpBatch(memberIds, 1000)
        );
    }
}