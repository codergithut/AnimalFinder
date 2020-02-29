
import com.service.AnimalAnalysisDataService;
import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertTrue;
/**
 * Created by tianjian on 2020/2/29.
 */
public class TestAnimalAnalyService {
    @Test
    public void testResource() throws FileNotFoundException {
        AnimalAnalysisDataService animalAnalysisDataService = new AnimalAnalysisDataService();
        assertTrue(animalAnalysisDataService.getSnopShot(
                "/Users/tianjian/IdeaProjects/AnimalFinder/src/main/resources/resource.txt"
                ,"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155"));
        animalAnalysisDataService.getSnopShot(
                "/Users/tianjian/IdeaProjects/AnimalFinder/src/main/resources/resource1.txt"
                ,"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");

        animalAnalysisDataService.getSnopShot(
                "/Users/tianjian/IdeaProjects/AnimalFinder/src/main/resources/resource2"
                ,"351055db-33e6-4f9b-bfe1-16f1ac446ac1");


    }
}
