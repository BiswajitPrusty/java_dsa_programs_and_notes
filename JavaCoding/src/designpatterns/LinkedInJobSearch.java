package designpatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LinkedInJobSearch {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BiswajitPrusty\\Desktop\\docs\\Softwares\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the LinkedIn job search page
        driver.get("https://www.linkedin.com/jobs/");

        // Find the search input field and enter the keywords
        WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label='Search jobs']"));
        String keywords = "software engineer"; // Replace with your desired keywords
        searchInput.sendKeys(keywords);

        // Find the search button and click it
        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Search']"));
        searchButton.click();

        // Wait for the search results to load
        try {
            Thread.sleep(2000); // You can adjust the wait time if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all the job listings on the page
        List<WebElement> jobListings = driver.findElements(By.xpath("//li[@data-test-pagination-page-button='true']"));

        // Iterate through each job listing and print the details
        for (WebElement jobListing : jobListings) {
            WebElement titleElement = jobListing.findElement(By.xpath(".//h3"));
            WebElement linkElement = jobListing.findElement(By.xpath(".//a"));
            WebElement descriptionElement = jobListing.findElement(By.xpath(".//p"));

            String title = titleElement.getText();
            String link = linkElement.getAttribute("href");
            String description = descriptionElement.getText();

            System.out.println("Title: " + title);
            System.out.println("Link: " + link);
            System.out.println("Description: " + description);
            System.out.println("-----------------------");
        }

        // Close the browser
        driver.quit();
    }
}
