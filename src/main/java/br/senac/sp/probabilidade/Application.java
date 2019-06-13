package br.senac.sp.probabilidade;

import br.senac.sp.probabilidade.model.*;
import br.senac.sp.probabilidade.question.Q1Simulation;
import br.senac.sp.probabilidade.question.Q2Simulation;
import br.senac.sp.probabilidade.question.Simulation;

public class Application {

	public static void main(String[] args) {
		Component componentA = new Component("A", 15.00);
		Component componentB = new Component("B", 25.00);

		Product p1 = Product.builder()
			.component(componentA, 2)
			.component(componentB, 1)
			.unitPrice(70.00)
			.build();

		Product p2 = Product.builder()
			.component(componentA, 2)
			.component(componentB, 3)
			.unitPrice(70.00)
			.build();

		Company company = Company.builder()
			.capacity(400)
			.expenses(buildExpenses())
			.payroll(buildPayroll())
			.build();

		Simulation simA = new Q1Simulation(company).runWith(p1, p2);
		Simulation simB = new Q2Simulation(company).runWith(p1, p2);
	}

	private static Payroll buildPayroll() {
		return Payroll.builder()
			.productionLineSalary(3500.00)
			.administrationalary(4000.00)
			.generalServicesSalary(2000.00)
			.directorSalary(6000.00)
			.employeesInProduction(5)
			.employeesInAdmin(2)
			.employeesInGeneralServices(2)
			.numberOfDirectors(1)
			.build();
	}

	private static Expenses buildExpenses() {
		return Expenses.builder()
			.rent(3500.00)
			.electrictyBill(900.00)
			.waterSewerBill(600.00)
			.build();
	}

}
