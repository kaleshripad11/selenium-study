package basicselenium.frames;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.WebElement;

public class FrameBasicDemo {
    WebDriver framedemo;
    //WebElement /*frame1,frame2,*/frame3;
    String frame1Title,frame2Title,frame3Title;
    
    public FrameBasicDemo(WebDriver driver) {
        // TODO Auto-generated constructor stub
        // Initiate driver
        framedemo = driver;
        framedemo.manage().window().maximize();
    } 

    void openPage() {
        framedemo.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        framedemo.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
    }

    void locateFrames(){
        framedemo.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //framedemo.switchTo().defaultContent();
        
        //frame1 = framedemo.findElement(By.xpath("//iframe[@src='overview-frame.html']"));
        framedemo.switchTo().frame("packageListFrame");	//Switch to a frame using id or name
        frame1Title = framedemo.getTitle();
        System.out.println(frame1Title);
        framedemo.switchTo().defaultContent();
        
        //frame2 = framedemo.findElement(By.xpath("//iframe[@src='allclasses-frame.html']"));
        framedemo.switchTo().frame("packageFrame");
        frame2Title = framedemo.getTitle();
        System.out.println(frame2Title);
        framedemo.switchTo().defaultContent();
        
        //Switch to frame by WebElemement
        framedemo.switchTo().frame(framedemo.findElement(By.xpath("//iframe[@src='overview-summary.html']"))); 
        frame3Title = framedemo.getTitle();
        System.out.println(frame3Title);
        framedemo.switchTo().defaultContent();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FrameBasicDemo frame = new FrameBasicDemo(new FirefoxDriver());
        frame.openPage();
        frame.locateFrames();
        frame.framedemo.quit();
    }
}
