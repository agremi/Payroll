package progetto.mp.mirko.agresti.payroll;

public class TransferPaymentStrategy implements PaymentStrategy {
	private String name;
	private String surname;
	private double amount;
	private String iban;

	public TransferPaymentStrategy(Employee employee, double amount, String iban) {
		this.name = employee.getName();
		this.surname = employee.getSurname();
		this.amount = amount;
		this.iban = iban;
	}

	@Override
	public void pay(PaymentManager manager) {
		manager.pay("Bonifico di " + amount + " effettuato a favore di " + name + " " + surname + " sul conto corrente "
				+ iban);
	}

}
