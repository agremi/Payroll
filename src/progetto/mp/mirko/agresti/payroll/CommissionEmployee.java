package progetto.mp.mirko.agresti.payroll;

public class CommissionEmployee extends Employee {
	private double percentageOnSales;
	private double soldAmount;

	private CommissionEmployee(String name, String surname, double percentage, TaxStrategy taxes, int id,
			String dateOfBirth, String fiscalCode) {
		super(name, surname, taxes, id, dateOfBirth, fiscalCode);
		this.percentageOnSales = percentage;

	}

	public double getPercentageOnSales() {
		return percentageOnSales;
	}

	public double getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(double soldAmount) {
		this.soldAmount = soldAmount;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public static class CommissionEmployeeBuilder {
		private String name;
		private String surname;
		private double percentageOnSales;
		private TaxStrategy taxes;
		private int id;
		private String dateOfBirth;
		private String fiscalCode;

		public CommissionEmployeeBuilder(String name, String surname, double percentageOnSales) {
			this.name = name;
			this.surname = surname;
			this.percentageOnSales = percentageOnSales;
		}

		public CommissionEmployeeBuilder withTaxesCalculator() {
			taxes = new CommissionTaxStrategy();
			return this;
		}

		public CommissionEmployeeBuilder withId(int id) {
			this.id = id;
			return this;
		}

		public CommissionEmployeeBuilder withDateOfBirth(String dateOFBirth) {
			this.dateOfBirth = dateOFBirth;
			return this;
		}

		public CommissionEmployeeBuilder withFiscalCode(String fiscalCode) {
			this.fiscalCode = fiscalCode;
			return this;
		}

		public CommissionEmployee build() {
			CommissionEmployee employee = new CommissionEmployee(name, surname, percentageOnSales, taxes, id,
					dateOfBirth, fiscalCode);
			return employee;
		}

	}

}
