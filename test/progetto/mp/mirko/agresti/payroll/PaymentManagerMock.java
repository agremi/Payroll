package progetto.mp.mirko.agresti.payroll;

public class PaymentManagerMock implements PaymentManager {
	private StringBuilder builder= new StringBuilder();
	
	@Override
	public void pay(String string) {
		builder.append(string);
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	

	
	
}
