package Assignment2_Variable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateField {

	public static boolean isValidEmail(String email) {
		// EmailRegex Expression
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		// Compile The RegexEx
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		} else {
			return pat.matcher(email).matches();
		}
	}

	public static boolean isValidCusNumber(String num) {
		if (num == null) {
			return false;
		} else if (num.length() == 7 && !(num.contains(" "))) {
			return true;
		}
		return false;
	}
	//--------Date & Time
	public static boolean isValidDateFormat(String date) {
		if(date == null) {
			return false;
		}
		DateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		}catch(ParseException e) {
			return false;
		}
		return true;
	}
	public static boolean isValidDateFormatRegex(String date) {
		//This RegexExpression For Validate Date Format DD/MM/YYYY With Require Leading Zeros
		
		//Example True Format : 01/01/2020
		String regex = " ^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		
		//Compile The RegexEx
		Pattern pat = Pattern.compile(regex);
		//Return True If Corrects Format
		return pat.matcher(date).matches();
	}
	public static boolean isValidMonthFormat(String month) {
		DateFormat sdft = new  SimpleDateFormat("MM/yyyy");
		sdft.setLenient(false);
		try {
			sdft.parse(month);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	public static boolean isValidMonthBitFormat(String month) {
		DateFormat sdft = new  SimpleDateFormat("MM");
		sdft.setLenient(false);
		try {
			sdft.parse(month);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidUserName(String name) {
		// UserNameRegex Expression
		String regex = "^[\\p{L} .'-]+$";
		// Compile The RegexEx
		Pattern pat = Pattern.compile(regex);
		if (name == null) {
			return false;
		} else {
			// Pattern Class Contains Matcher() Method To Find Matching Between Given Name
			// And Regular Expression
			Matcher m = pat.matcher(name);
			// Return True If Name Match RegexEx
			return m.matches();
		}
	}

	public static boolean isValidIdentity(String num) {
		// Check Length Of Identity Number
		if (num.length() != 6) {
			return false;
		} else {
			// IdentityRegex Expression
			String regex = "[+-]?[0-9]+";
			// Pattern Class Contains Matcher() Method To Find Matching Between Given Number
			// And Regular Expression
			Pattern pat = Pattern.compile(regex);
			return pat.matcher(num).matches();
		}

	}

	public static boolean isValidGender(int num) {
		if (num == 1 || num == 0 || num == 2) {
			return true;
		}
		return false;
	}

	public static boolean isValidCusType(int num) {
		if (num == 1 || num == 0) {
			return true;
		}
		return false;
	}

	public static boolean isValidAccNumber(String num) {
		if (num == null) {
			return false;
		}
		String regex = "^\\d{9}$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(num).matches();
	}

	public static boolean isValidPhoneNum(String num) {
		if (num == null) {
			return false;
		}
		String regex = "^\\d{10}$";
		Pattern pat = Pattern.compile(regex);
		return pat.matcher(num).matches();
	}

	// Method Validate Amount Initial SetUp
	public static boolean isValidAmount(long num) {
		if (num <= 0) {
			return false;
		}
		return true;
	}
}
