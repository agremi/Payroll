package progetto.mp.mirko.agresti.payroll;

public class CheckPaymentStrategy implements PaymentStrategy {
	private String name;
	private String surname;
	private double amount;

	public CheckPaymentStrategy(Employee employee, double amount) {
		this.name = employee.getName();
		this.surname = employee.getSurname();
		this.amount = amount;
	}
	
	@Override
	public void pay(PaymentManager manager) {
		manager.pay("Assegno di "+amount+" effettuato a favore di "+ name+" "+surname);
	}

}
