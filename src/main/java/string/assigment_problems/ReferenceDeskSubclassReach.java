package string.assigment_problems;

class SubclassAccessChecker {

    static String classifyAccess(
            String fieldModifier,
            String accessorContext) {

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED"
                    : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED"
                    : "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return "ALLOWED";
            }

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
                return "DENIED";
            }

            return accessorContext.equals("DIFFERENT_PACKAGE")
                    ? "DENIED"
                    : "ALLOWED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result =
                    classifyAccess(modifier, context);

            if (result.equals("DENIED")) {
                return modifier
                        + " via "
                        + context
                        + " (attempt #"
                        + (i + 1)
                        + ")";
            }
        }

        return "None Denied";
    }
}

public class ReferenceDeskSubclassReach {

    public static void main(String[] args) {

        String[][] attempts = {
                {
                    "public",
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
                },
                {
                    "protected",
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
                },
                {
                    "protected",
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
                }
        };

        System.out.println(
                SubclassAccessChecker.firstDeniedAttempt(attempts)
        );

        String[][] allowedAttempts = {
                {
                    "public",
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
                },
                {
                    "protected",
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
                }
        };

        System.out.println(
                SubclassAccessChecker.firstDeniedAttempt(
                        allowedAttempts
                )
        );
    }
}