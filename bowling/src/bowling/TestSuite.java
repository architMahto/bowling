package bowling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({tests.FrameTest.class, tests.PlayerTest.class, tests.GameTest.class})

public class TestSuite {

}
