package progetto.mp.mirko.agresti.payroll;

public class SalaryTaxStrategy implements TaxStrategy {

	@Override
	public double taxesPercentage() {
		return 22;
	}

}
