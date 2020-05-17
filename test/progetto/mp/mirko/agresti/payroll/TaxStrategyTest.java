package progetto.mp.mirko.agresti.payroll;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxStrategyTest {

	@Test
	public void testSalaryStrategy() {
		SalaryEmployee employee = new SalaryEmployee.SalaryEmployeeBuilder("Mirko", "Agresti", 12.0)
				.withTaxesCalculator()
				.withId(1)
				.withDateOfBirth("01/01/1945")
				.withFiscalCode("aFiscalCode")
				.build();
		assertEquals(22, employee.getTaxes().taxesPercentage(), 0);
	}

	@Test
	public void testCommissionTaxStrategy() {
		CommissionEmployee employee = new CommissionEmployee.CommissionEmployeeBuilder("Mario", "Rossi", 5.0)
				.withTaxesCalculator()
				.withId(1)
				.withDateOfBirth("01/01/1945")
				.withFiscalCode("aFiscalCode")
				.build();
				
		assertEquals(15, employee.getTaxes().taxesPercentage(),0);
	}
}
