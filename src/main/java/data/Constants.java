package data;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String CHROME_DRIVER_PATH_WINDOW = "";
	public static final String FIREFOX_DRIVER_PATH_WINDOW = "";
	public static final String CHROME_DRIVER_PATH_MAC = "";
	public static final String FIREFOX_DRIVER_PATH_MAC = "";

	public static final int IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 30;

	public static final String DOWNLOAD_DESTINATION = System.getProperty("user.home") + "/Downloads/";

	public static final String BASE_URL = "venngage.beer";

	public static final List<String> ORGS = Arrays.asList("sm-business", "med-business", "enterprise", "nonprofit", "govt", "school",
			"self-employed", "other" );
	public static final List<String> ROLES_SMALL_BUZ = Arrays.asList( "finance", "it-eng", "hr", "marketer", "exec", "custservice",
			"sales", "other" );
	public static final List<String> ROLES_MED_ETP_BUZ_OTHER = Arrays.asList( "finance", "it-eng", "hr", "marketer", "exec", "analyst",
			"sales", "other" );
	public static final List<String> ROLES_NGO = Arrays.asList( "finance", "researcher", "hr", "marketer", "exec", "progmngr", "knowlmgt",
			"other" );
	public static final List<String> ROLES_GOV = Arrays.asList( "finance", "researcher", "hr", "marketer", "exec", "progmngr", "knowlmgt",
			"other" );
	public static final List<String> ROLES_SCHOOL = Arrays.asList( "lib", "researcher", "prof", "marketer", "student", "admin", "tutor",
			"other" );
	public static final List<String> ROLES_SELF_EMPLOYED = Arrays.asList( "real-estate", "health", "bnsscons", "marketer", "recruiter",
			"blogger", "designer", "other" );
	public static final List<String> RECOMMENDED_CATEGORIES = Arrays.asList("infographics", "presentations", "posters", "reports", "resumes"
				,"socials", "flyers", "newletters", "invitations");
	
	
	//Payment
	public static final String VISA1 = "4242424242424242";
	public static final String VISA2 = "4012888888881881";
	public static final String VISADEBIT = "4000056655665556";
	public static final String MASTERCARD = "5555555555554444";
	public static final String MASTERDEBIT = "5200828282828210";
	public static final String MASTERPREPAID = "5105105105105100";
	public static final String AMERICANEXPRESS1 = "378282246310005";
	public static final String AMERICANEXPRESS2 = "371449635398431";
	//Invalid
	public static final String CARD_DECLINE = "4000000000000002";
	public static final String INSUFFICIENT_FUND  = "4000000000009995";
	public static final String INCORRECT_CVC  = "4000000000000127";
	public static final String EXPIRED_CARD  = "4000000000000069";
	public static final String PROCESSING_ERROR  = "4000000000000119";
	public static final String INCORRECT_NUMBER  = "4242424242424241";
	public static final String INVALID_CARD  = "1234567890123456";
	public static final String ACCEPTED_CARD_CHARGE_FAILED  = "4000000000000341";

}
