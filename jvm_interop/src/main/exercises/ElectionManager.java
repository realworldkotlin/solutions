public class ElectionManager {
    public final String electionName;

    ElectionManager(String electionName) {
        this.electionName = electionName;
    }

    ElectionManager() {
        this("USA 2008");
    }

    public boolean isLegit() {
        return true;
    }

    public static final String copyright = "© 2018 VerySafe Election Systems. All rights reserved.";

    public static boolean validateLicense(String licence) {
        return "GqNCDvhNhKh2hrtJdHBXLqpq".equals(licence);
    }
}
