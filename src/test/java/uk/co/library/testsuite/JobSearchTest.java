package uk.co.library.testsuite;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

@Listeners(CustomListeners.class)

public class JobSearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();
        softAssert= new SoftAssert();
    }

    @Test(dataProvider = "CV Library", dataProviderClass = TestData.class,groups = {"smoke","regression"})
     public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
            String result) throws InterruptedException {


        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.acceptCookies();
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOption();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickOnFindJobsButton();
        String actual =resultPage.getText();
        String expected = resultPage.getSearchResultText();
        Assert.assertEquals(actual,expected);


    }
}
