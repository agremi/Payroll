package progetto.mp.mirko.agresti.payroll;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.mirko.agresti.payroll.ConcretePayRollVisitor;
import progetto.mp.mirko.agresti.payroll.SalaryEmployee;

public class PayrollConreteVisitorTest {
	ConcretePayRollVisitor visitor;

	@Before
	public void setup() {
		visitor = new ConcretePayRollVisitor();
	}

	@Test
	public void testSalaryAccept() {
		SalaryEmployee employee = new SalaryEmployee.SalaryEmployeeBuilder("Mirko", "Agresti", 12.0)
				.withTaxesCalculator()
				.withId(1)
				.withFiscalCode("aFiscalCode")
				.withDateOfBirth("01/01/1945")
				.build();
		employee.setWorkedHours(360.0);
		System.out.println(employee.accept(visitor));
		assertEquals(3369.6, employee.accept(visitor), 0);
	}

	@Test
	public void testCommissionAccept() {
		CommissionEmployee employee = new CommissionEmployee.CommissionEmployeeBuilder("Mirko", "Agresti", 2)
				.withTaxesCalculator()
				.withId(1)
				.withDateOfBirth("01/01/1945")
				.withFiscalCode("aFiscalCode")
				.build();
		employee.setSoldAmount(200000);
		assertEquals(3400.0, employee.accept(visitor), 0);
	}

}
