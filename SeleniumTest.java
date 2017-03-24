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

	//��Ĺ��캯��
	public SeleniumTest(String id, String github) {
		this.id = id;
		this.pwd = id.substring(4);
		this.github = github;
	}

	@Before
	public void setUp() throws Exception {
		// ������Firefox�������Ĭ�ϵ�ַ��װ�ģ�����Ҫ�������,�����滻Ϊ�㰲װ�ĵ�ַ
		// System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox/firefox.exe");
		driver = new FirefoxDriver();
		// ����Ҫ���Ե���ַ
		baseUrl = "http://121.193.130.195:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//ʹ��@Parametersע�⣬���������ԣ����ڶ�ͬһ������������һ������
	@Parameters
	public static Collection<Object[]> getData() throws IOException {
		//inputgit.csv��117������
		Object[][] obj = new Object[117][];
		CsvReader r = new CsvReader("D:/������ѧ��/�������/inputgit.csv", ',',
				Charset.forName("GBK"));
		int count = 0;
		r.readHeaders();
		//��ȡinputgit.csv��ÿ������
		while (r.readRecord()) {
			obj[count] = new Object[] { r.get("ѧ��"), r.get("github��ַ") };
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