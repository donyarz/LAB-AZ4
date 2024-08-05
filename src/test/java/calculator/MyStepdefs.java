package calculator;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private double result;
    private boolean isError;

    @Before
    public void before() {
        calculator = new Calculator();
        isError = false;
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I calculate the square root of (-?\\d+) divided by (-?\\d+)$")
    public void iCalculateTheSquareRootOfDividedBy(int arg0, int arg1) {
        if (arg0 < 0 && arg1 < 0) {
            result = calculator.calculate(value1, value2);
        }
        else if (arg1 == 0 || arg0 < 0 || arg1 < 0) {
            isError = true;
        } else {
            result = calculator.calculate(value1, value2);
        }
        if (isError) {
            System.out.print("error");
        } else {
            System.out.print(result);
        }
    }

    @Then("^I expect the result (.+)$")
    public void iExpectTheResult(String expected) {
        if (expected.equals("error")) {
            Assert.assertTrue("Expected an error but none occurred.", isError);
        } else {
            double expectedValue = Double.parseDouble(expected);
            Assert.assertFalse("An error was not expected but occurred.", isError);
            Assert.assertEquals("Result did not match the expected value.", expectedValue, result, 0.0001);
        }
    }
}
