package dashboardAPIs;


public class APITest extends Authentication{

	public static void main(String[] args) {
        // Instantiate the Authentication class
        Authentication auth = new Authentication();

        // Call the testSignUp method
        System.out.println("Running testSignUp...");
        auth.testSignUp();
        

        // Call the testValidateEmail method
        System.out.println("Running testValidateEmail...");
        auth.testValidateEmail();

        // Call the testLoginPartner method
        System.out.println("Running testLoginPartner...");
        auth.testLoginPartner();

        System.out.println("All tests executed successfully.");
    }

}
