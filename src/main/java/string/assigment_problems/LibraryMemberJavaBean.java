package string.assigment_problems;

public class LibraryMemberJavaBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberJavaBean() {
        membershipId = null;
        name = "";
        premiumMember = false;
        securityAnswer = null;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {

        if (answer != null) {
            securityAnswer = Integer.toHexString(
                    answer.hashCode()
            );
        }
    }

    public static void main(String[] args) {

        LibraryMemberJavaBean member =
                new LibraryMemberJavaBean();

        member.setMembershipId("LIB-8841");
        member.setName("Priya Nair");
        member.setPremiumMember(true);

        System.out.println(
                "Membership ID: "
                        + member.getMembershipId()
        );

        System.out.println(
                "Name: " + member.getName()
        );

        System.out.println(
                "Premium: "
                        + member.isPremiumMember()
        );

        member.setMembershipId("FAKE-0000");

        System.out.println(
                "After second ID attempt: "
                        + member.getMembershipId()
        );

        member.setSecurityAnswer("BlueMountain");

        System.out.println("Security answer stored");
    }
}