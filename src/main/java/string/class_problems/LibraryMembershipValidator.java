package string.class_problems;

class LibraryMember {

    protected String memberId;
    protected String name;
    protected int booksBorrowed;

    LibraryMember(String memberId, String name, int booksBorrowed) {

        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (booksBorrowed < 0) {
            throw new IllegalArgumentException("Invalid books borrowed");
        }

        this.memberId = memberId;
        this.name = name;
        this.booksBorrowed = booksBorrowed;
    }
}

class StudentMember extends LibraryMember {

    private String course;

    StudentMember(
            String memberId,
            String name,
            int booksBorrowed,
            String course) {

        super(memberId, name, booksBorrowed);

        if (course == null || course.isEmpty()) {
            throw new IllegalArgumentException("Invalid course");
        }

        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}

public class LibraryMembershipValidator {

    static String enrollBatch(String[][] records) {

        int enrolled = 0;
        int rejected = 0;

        for (String[] record : records) {

            try {

                String memberId = record[0];
                String name = record[1];
                int booksBorrowed = Integer.parseInt(record[2]);
                String course = record[3];

                new StudentMember(
                        memberId,
                        name,
                        booksBorrowed,
                        course
                );

                enrolled++;

            } catch (Exception e) {
                rejected++;
            }
        }

        return enrolled + " enrolled | " + rejected + " rejected";
    }

    public static void main(String[] args) {

        String[][] records = {
                {"LIB-101", "Arun", "2", "CSE"},
                {"LIB-102", "Priya", "0", "ECE"},
                {"", "Rahul", "1", "MECH"},
                {"LIB-104", "Anu", "-1", "CSE"}
        };

        System.out.println(enrollBatch(records));
    }
}