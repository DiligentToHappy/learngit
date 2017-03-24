package tju.softwareLab2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class SeleniumTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String id, pwd, github;

	//类的构造函数
	public SeleniumTest(String id, String github) {
		this.id = id;
		this.pwd = id.substring(4);
		this.github = github;
	}

	@Before
	public void setUp() throws Exception {
		// 如果你的Firefox浏览器是默认地址安装的，不需要下面这句,否则替换为你安装的地址
		// System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox/firefox.exe");
		driver = new FirefoxDriver();
		// 这是要测试的网址
		baseUrl = "http://121.193.130.195:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//使用@Parameters注解，参数化测试，用于对同一测试用例测试一组数据
	@Parameters
	public static Collection<Object[]> getData() throws IOException {
		//inputgit.csv有117组数据
		Object[][] obj = new Object[117][];
		CsvReader r = new CsvReader("D:/大三下学期/软件测试/inputgit.csv", ',',
				Charset.forName("GBK"));
		int count = 0;
		r.readHeaders();
		//获取inputgit.csv中每行数据
		while (r.readRecord()) {
			obj[count] = new Object[] { r.get("学号"), r.get("github地址") };
			count++;
		}
		return Arrays.asList(obj);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl);
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(this.id);
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys(this.pwd);
	    driver.findElement(By.id("submit")).click();
	    assertEquals(this.github, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}