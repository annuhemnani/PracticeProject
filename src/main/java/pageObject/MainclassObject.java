package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainclassObject {
	WebDriver driver;
	
	public MainclassObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	By bmwRadioButton= By.cssSelector("#bmwradio");
	By benzRadioButton= By.cssSelector("#benzradio");
	By hondaRadioButton= By.cssSelector("#hondaradio");

	By bmwRadioButtonlabel= By.xpath("(//div[@id='radio-btn-example']/fieldset/label[@for='bmw'])");
	By benzRadioButtonlabel= By.xpath("(//div[@id='radio-btn-example']/fieldset/label[@for='benz'])");
	By hondaRadioButtonlabel= By.xpath("(//div[@id='radio-btn-example']/fieldset/label[@for='honda'])");
	By radiobuttonsTotal= By.cssSelector("input[type='radio']");
	By dropdown=By.cssSelector("#carselect");
	By multiSelectDropdown= By.cssSelector("#multiple-select-example");
	By checkboxCount= By.cssSelector("input[type='checkbox']");
	By bmwcheckbox=By.cssSelector("#bmwcheck");
	By benzcheckbox=By.cssSelector("#benzcheck");
	By hondacheckbox=By.cssSelector("#hondacheck");

	
	public WebElement getbenzradiobutton() {
		return driver.findElement(benzRadioButton);
	}
	
	public WebElement getbmwradiobutton() {
		return driver.findElement(bmwRadioButton);
	}
	public WebElement gethondaradiobutton() {
		return driver.findElement(hondaRadioButton);
	}
	public List<WebElement> getRadioButtonTotalCount() {
		return driver.findElements(radiobuttonsTotal);
	}
	
	public WebElement getdropdowntext() {
		return driver.findElement(dropdown);
	}
	public Select dropdownOption() {
		Select s= new Select(driver.findElement(dropdown));
		return s;
	}
	public Select multipleSelectDropdown() {
		Select multi=new Select(driver.findElement(multiSelectDropdown));
		return multi;
	}
	
	public WebElement getbmwradioButtonLabel() {
		return driver.findElement(bmwRadioButtonlabel);
	}
	public WebElement getbenzradioButtonLabel() {

	return driver.findElement(benzRadioButtonlabel);
	}	
	public WebElement gethondaradioButtonLabel() {
		return driver.findElement(hondaRadioButtonlabel);
	}
	public int getcheckboxcount()	{
		return driver.findElements(checkboxCount).size();
	}
	public WebElement getBMWCheckbox() {
		return driver.findElement(bmwcheckbox);
	}
	public WebElement getBenzCheckbox() {
		return driver.findElement(benzcheckbox);
	}
	public WebElement getHondaCheckbox() {
		return driver.findElement(hondacheckbox);
	}
	
	
}
