
import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
	Karate testTagsWithoutFeatureName() {
		return Karate.run("classpath:/FeatureFiles").tags("@retryMech").relativeTo(getClass());
	}

}
