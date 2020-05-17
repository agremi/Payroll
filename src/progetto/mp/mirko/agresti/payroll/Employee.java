package progetto.mp.mirko.agresti.payroll;

public abstract class Employee {
	private String name;
	private String surname;
	private TaxStrategy taxes;
	private int id;
	private String dateOfBirth;
	private String fiscalCode;

	public Employee(String name, String surname, TaxStrategy taxes, int id, String dateOfBirth, String fiscalCode) {
		super();
		this.name = name;
		this.surname = surname;
		this.taxes = taxes;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.fiscalCode = fiscalCode;
	}

	protected TaxStrategy getTaxes() {
		return taxes;
	}
	
	protected String getName() {
		return name;
	}

	protected String getSurname() {
		return surname;
	}

	public abstract double accept(Visitor visitor);

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", id=" + id + ", dateOfBirth="
				+ dateOfBirth + ", fiscalCode=" + fiscalCode + "]";
	}
	
}
