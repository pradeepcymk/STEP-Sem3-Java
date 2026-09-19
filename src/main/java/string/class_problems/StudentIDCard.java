package string.class_problems;

class IDCard {

    String studentName;
    int cardNumber;

    IDCard(String studentName, int cardNumber) {
        this.studentName = studentName;
        this.cardNumber = cardNumber;
    }
}

public class StudentIDCard {

    public static void main(String[] args) {

        IDCard card1 = new IDCard("Arun", 101);

        IDCard card2 = card1;

        System.out.println("card1 == card2: " + (card1 == card2));

        IDCard card3 = new IDCard("Arun", 101);

        System.out.println("card1 == card3: " + (card1 == card3));

        System.out.println("card1 student: " + card1.studentName);
        System.out.println("card2 student: " + card2.studentName);
        System.out.println("card3 student: " + card3.studentName);
    }
}