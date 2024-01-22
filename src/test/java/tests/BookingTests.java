package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.BookingHomePage;
import selenium_core.DriverManager;

public class BookingTests extends BaseTest{


    DriverManager driverManager;


    @BeforeMethod
    public void setup() {
        baseSetUP("CHROME", "99",5);


    }
    @Test
    public void booking() throws InterruptedException {
        String [] ages = {"3 years old", "4 years old","4 years old"};


        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.setWhereAreYouGoing("Kopaonik");
        bookingHomePage.checkInCheckOut("March","2025", "17","April", "2025","22");
        bookingHomePage.addQuests(2,3,ages,2);
        bookingHomePage.search();
        bookingHomePage.clicks();


        /*
        Assertation
         */


        String adultsCount = bookingHomePage.getAdultsCount();
        String childrenCount = bookingHomePage.getChildrenCount();
        String roomCount = bookingHomePage.getRoomCount();


        Assert.assertEquals(adultsCount, "10"); // Replace "3" with the expected value
        Assert.assertEquals(childrenCount, "3"); // Replace "2" with the expected value
        Assert.assertEquals(roomCount, "2"); // Replace "2" with the expected value
    }

    @AfterMethod
    public void tearDown (){
        baseTearDown();

    }
}
