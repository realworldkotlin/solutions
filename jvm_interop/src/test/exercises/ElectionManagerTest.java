import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectionManagerTest {
    @Test
    public void name_is_exposed() {
        ElectionManager election = new ElectionManager("my electionName");

        assertEquals(election.electionName, "my electionName");
    }

    @Test
    public void default_constructor_is_available() {
        ElectionManager election = new ElectionManager();

        assertEquals(election.electionName, "USA 2008");
    }

    @Test
    public void exposes_copyright_notice() {
        assertEquals(ElectionManager.copyright, "© 2018 VerySafe Election Systems. All rights reserved.");
    }

    @Test
    public void exposes_license_validator() {
        assertEquals(ElectionManager.validateLicense("GqNCDvhNhKh2hrtJdHBXLqpq"), true);
    }

    @Test
    public void exposes_getter() {
        ElectionManager election = new ElectionManager("my electionName");

        assertEquals(election.isLegit(), true);
    }
}
