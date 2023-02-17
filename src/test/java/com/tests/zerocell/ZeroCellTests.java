package com.tests.zerocell;

import com.utils.enums.BrowserType;
import com.utils.factory.DriverFactory;
import com.utils.zerocell.ExcelReader;
import com.utils.zerocell.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.github.sskorol.data.TestDataReader.use;

public class ZeroCellTests {

//
//    @Test(dataProvider = "getData")
//    public void testcase1(TestData data){
//        data.getList().forEach(System.out::println);
//        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
//        driver.get("https://google.co.in");
//        driver.findElement(By.name("q")).sendKeys(data.getFirstName());
//        driver.quit();
//    }



    @Test(dataProvider = "getDataFromExcel")
    public void testcase(TestData data){
        data.getList().forEach(System.out::println);
        WebDriver driver = DriverFactory.getDriver(data.getBrowser());
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys(data.getFirstName());
        driver.quit();
    }
    @Test(dataProvider = "getData")
    public void testcase2(TestData data){
        System.out.println(data.getBrowser());
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys(data.getFirstName());
        driver.quit();
    }

    @DataProvider(parallel = true)
    public Object[] getData(Method method) {
        return ExcelReader.getTestdatas()
                .stream()
                .filter(e->e.getTestCase().equalsIgnoreCase(method.getName())) //testcase1
                .toArray();
    }


    /////////////////
    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getDataFromExcel(Method method){
        return use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }


}
