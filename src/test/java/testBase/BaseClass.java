package testBase;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {

	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
}
