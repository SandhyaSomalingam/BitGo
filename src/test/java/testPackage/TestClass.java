package testPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public static SoftAssert softassert;
	public static WebDriver bitGoVariableName; 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		bitGoVariableName = new ChromeDriver();
		bitGoVariableName.manage().window().maximize();
		bitGoVariableName.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bitGoVariableName.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		testCase1Method("25 of 2875 Transactions");
		testCase2Method();
	}
	public static void testCase1Method(String userExpected){
		WebElement transactionHeading =bitGoVariableName.findElement(By.xpath("//div[@class='transactions']/h3"));
		String AcutualHeading =transactionHeading.getText();
	 try {
		softassert = new SoftAssert();
		softassert.assertEquals(AcutualHeading, userExpected);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 List<WebElement> headerValues = bitGoVariableName.findElements(By.xpath("//div[@class='txn']/a"));
	 for(WebElement uniqueHeader : headerValues) {
		 String uniqueHeaderValue = uniqueHeader.getText();
		 System.out.println(uniqueHeaderValue); 
		 
		 System.out.println("Testing");
	 }
		
		
	}
	public static void testCase2Method() {
		List<WebElement> headerValues = bitGoVariableName.findElements(By.xpath("//div[@class='txn']/a"));
		 for(int i=1;i<=headerValues.size();i++) {
			List<WebElement> bodyInputValues = bitGoVariableName.findElements(By.xpath("(//div[@class='txn']/a)["+ i+"]/parent::div/parent::div/following-sibling::div/div[@class='vins']/div"));
			if(bodyInputValues.size()==1) {
				System.out.println("Inputs with having one Value :  " + bodyInputValues.get(i).getText());
				List<WebElement> bodyOutputValues = bitGoVariableName.findElements(By.xpath("(//div[@class='txn']/a)["+i+"]/parent::div/parent::div/following-sibling::div/div[@class='vouts']/div"));
				if(bodyOutputValues.size() == 2) {
					for(int j=0;j<=bodyOutputValues.size();j++ ) {
						System.out.println("Inputs with having one Value :  " + bodyInputValues.get(j).getText());
					}
				}
			}
		 }
		
	
		
	 		
		
	}
}
