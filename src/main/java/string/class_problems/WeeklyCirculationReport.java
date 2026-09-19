package string.class_problems;

class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null || memberId.trim().isEmpty()
                || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("Invalid borrow limit");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}


class StudentMember extends LibraryMember {

    private String course;

    StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course
                + " | Books: " + booksBorrowed;
    }
}


public class WeeklyCirculationReport {

    static String batchPrint(LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            // Polymorphic method call
            report.append(member.displayInfo());

            // Safe downcast only for StudentMember
            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                report.append(" [Course via downcast: ")
                        .append(student.getCourse())
                        .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }


    public static void main(String[] args) {

        LibraryMember[] members = {
                new LibraryMember("LB50", 3),
                new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(
                batchPrint(members)
        );


        // Demonstrating safe downcasting
        LibraryMember plain =
                new LibraryMember("LB60", 3);

        if (plain instanceof StudentMember) {

            StudentMember student =
                    (StudentMember) plain;

            System.out.println(
                    student.getCourse()
            );

        } else {

            System.out.println(
                    "Safe: plain member is not a StudentMember"
            );
        }
    }
}