package basicselenium.alerts.demoblaze;

public class DemoblazeMain {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//DemoBlazeLogin login = new DemoBlazeLogin();
		DemoBlazeRegister register = new DemoBlazeRegister();
		register.openRegistrationModal();
		register.performRegistration();
		DemoBlazeConfig conf = new DemoBlazeConfig();
		Thread.sleep(1000);
		conf.driver.quit();
		
	}

}
