package progetto.mp.mirko.agresti.payroll;

public class ConcretePayRollVisitor implements Visitor {

	@Override
	public double visit(SalaryEmployee employee) {
		double gross = employee.getHourRate() * employee.getWorkedHours();
		double taxes = (gross / 100) * employee.getTaxes().taxesPercentage();
		return gross - taxes;
	}

	@Override
	public double visit(CommissionEmployee employee) {
		double gross = (employee.getSoldAmount()/100)*employee.getPercentageOnSales();
		double taxes = (gross / 100) * employee.getTaxes().taxesPercentage();
		return gross-taxes;
	}

}
