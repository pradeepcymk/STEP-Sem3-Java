package string.class_problems;

public class PlacementRecord {

    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(
                studentName + " | " + company + " | " + packageLpa + " LPA"
        );
    }

    public static void main(String[] args) {

        PlacementRecord record1 =
                new PlacementRecord("Arun", "Google", 25.0);

        PlacementRecord record2 =
                new PlacementRecord("Priya", "Microsoft", 22.0);

        PlacementRecord record3 =
                new PlacementRecord("Rahul", "Amazon", 20.0);

        PlacementRecord[] records = {
                record1, record2, record3
        };

        System.out.println("Student | Company | Package");

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}