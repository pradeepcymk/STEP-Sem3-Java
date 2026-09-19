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

    public String displayInfo() {
        return "Standard | Sessions: "
                + sessionsAttended;
    }
}


class PremiumMember extends GymMember {

    protected String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);

        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: "
                + trainerName
                + " | Sessions: "
                + sessionsAttended;
    }
}


public class MonthlyAttendanceAnnouncer {

    static String batchPrint(GymMember[] members) {

        StringBuilder announcement =
                new StringBuilder();

        for (GymMember member : members) {

            announcement
                    .append(member.displayInfo());

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                announcement
                        .append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("]");
            }

            announcement.append(" | ");
        }

        return announcement.toString();
    }


    public static void main(String[] args) {

        GymMember[] members = {
                new GymMember("MEM6", 1000),
                new PremiumMember(
                        "MEM7",
                        2000,
                        "Coach Riya"
                )
        };

        System.out.println(
                batchPrint(members)
        );


        GymMember plain =
                new GymMember("MEM8", 1000);

        if (plain instanceof PremiumMember) {

            PremiumMember premium =
                    (PremiumMember) plain;

            System.out.println(
                    premium.getTrainerName()
            );

        } else {

            System.out.println(
                    "Safe: plain member is not a PremiumMember"
            );
        }
    }
}