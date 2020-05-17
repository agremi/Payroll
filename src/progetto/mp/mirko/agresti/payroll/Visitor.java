package progetto.mp.mirko.agresti.payroll;

public interface Visitor {
	double visit(SalaryEmployee employee);
	double visit(CommissionEmployee employee);
}
