package progetto.mp.mirko.agresti.payroll;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentTest {
	SalaryEmployee employee1;
	CommissionEmployee employee2;
	PaymentManagerMock manager;

	@Before
	public void setup() {
		employee1 = new SalaryEmployee.SalaryEmployeeBuilder("Mirko", "Agresti", 12.0).withTaxesCalculator().withId(1)
				.withFiscalCode("aFiscalCode").withDateOfBirth("01/01/1945").build();
		employee2 = new CommissionEmployee.CommissionEmployeeBuilder("Mirko", "Agresti", 2).withTaxesCalculator()
				.withId(1).withDateOfBirth("01/01/1945").withFiscalCode("aFiscalCode").build();
		manager= new PaymentManagerMock();
 
	}

	@Test
	public void testSalaryCheckPayment() {
		PaymentStrategy strategy = new CheckPaymentStrategy(employee1, 1500);
		strategy.pay(manager);
		assertEquals("Assegno di 1500.0 effettuato a favore di Mirko Agresti", manager.toString());
	}
	@Test
	public void testCommissionCheckPayment() {
		PaymentStrategy strategy = new CheckPaymentStrategy(employee2, 3000);
		strategy.pay(manager);
		assertEquals("Assegno di 3000.0 effettuato a favore di Mirko Agresti", manager.toString());
	}
	@Test
	public void testSalaryTransferPayment() {
		PaymentStrategy strategy = new TransferPaymentStrategy(employee1, 2000,"xyz01");
		strategy.pay(manager);
		assertEquals("Bonifico di 2000.0 effettuato a favore di Mirko Agresti sul conto corrente xyz01", manager.toString());
	}
	@Test
	public void testCommissionTransferPayment() {
		PaymentStrategy strategy = new TransferPaymentStrategy(employee2,4000,"xyz01");
		strategy.pay(manager);
		assertEquals("Bonifico di 4000.0 effettuato a favore di Mirko Agresti sul conto corrente xyz01", manager.toString());
	}

}
