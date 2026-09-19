package string.assigment_problems;

class ExamHallTicket {

    String studentName;
    int hallNumber;

    ExamHallTicket(String studentName, int hallNumber) {
        this.studentName = studentName;
        this.hallNumber = hallNumber;
    }
}

public class HallTicket {

    public static void main(String[] args) {

        ExamHallTicket ticket1 =
                new ExamHallTicket("Arun", 101);

        ExamHallTicket ticket2 = ticket1;

        ticket2.hallNumber = 202;

        System.out.println("ticket1 == ticket2: " + (ticket1 == ticket2));

        System.out.println("Ticket1 Hall: " + ticket1.hallNumber);
        System.out.println("Ticket2 Hall: " + ticket2.hallNumber);

        ExamHallTicket ticket3 =
                new ExamHallTicket("Arun", 202);

        System.out.println("ticket1 == ticket3: " + (ticket1 == ticket3));
    }
}