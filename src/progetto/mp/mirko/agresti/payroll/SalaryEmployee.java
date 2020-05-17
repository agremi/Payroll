package progetto.mp.mirko.agresti.payroll;

public class SalaryEmployee extends Employee {
	private double hourRate;
	private double workedHours;

	private SalaryEmployee(String name, String surname, double hourRate, TaxStrategy taxes, int id, String dateOfBirth,
			String fiscalCode) {
		super(name, surname, taxes, id, dateOfBirth, fiscalCode);
		this.hourRate = hourRate;
	}

	public double getHourRate() {
		return hourRate;
	}

	public double getWorkedHours() {
		return workedHours;
	}

	public	 void setWorkedHours(double workedHours) {
		this.workedHours = workedHours;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public static class SalaryEmployeeBuilder {
		private String name;
		private String surname;
		private Double hourRate;
		private TaxStrategy taxes;
		private int id;
		private String dateOfBirth;
		private String fiscalCode;
		
		public SalaryEmployeeBuilder(String name, String surname, Double hourRate) {
			this.name = name;
			this.surname = surname;
			this.hourRate = hourRate;
		}

		public SalaryEmployeeBuilder withTaxesCalculator() {
			taxes = new SalaryTaxStrategy();
			return this;
		}

		public SalaryEmployeeBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public SalaryEmployeeBuilder withDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		public SalaryEmployeeBuilder withFiscalCode(String fiscalCode) {
			this.fiscalCode=fiscalCode;
			return this;
		}

		public SalaryEmployee build() {
			SalaryEmployee employee = new SalaryEmployee(name, surname, hourRate, taxes,id,dateOfBirth,fiscalCode);
			return employee;
		}
	}
}
