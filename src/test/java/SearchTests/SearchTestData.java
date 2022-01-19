package SearchTests;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseTest.BaseTestPage;
import Searchmodule.SearchData;

public class SearchTestData extends BaseTestPage {

	@Test
	@Parameters({"keyword"})
	public void searchInfo(String keyword) {
		SearchData shp = new SearchData(driver);
		shp.goTo();
		shp.doSearch(keyword);
	}
	
	@Test(dependsOnMethods = "searchInfo")
	public void searchForVideos() {
		SearchData shp = new SearchData(driver);
		shp.goToVideosPage();
	}

	@Test(dependsOnMethods = "searchForVideos")
	public void totalNoOfVideos() {
		SearchData shp = new SearchData(driver);
		shp.getTotalVideos();
	}
	
}
