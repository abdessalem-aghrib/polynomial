public class Application {

	public static void main(String[] args) {

		/** 1. - Create two Polynomials p1 and p2 and display 
		 * the message if p1 is equal to p2
		 * 
		 * p1 = xˆ2 + 8x
		 * p2 = xˆ2 + 8x + 1
		 * 
		 **/
		System.out.println("1 - Create two Polynomials :");
		Polynomial p1 = new Polynomial(new Monomial(1, 2), new Monomial(8, 1), new Monomial(0, 0));
		Polynomial p2 = new Polynomial(new Monomial(1, 2), new Monomial(1, 0), new Monomial(8, 1));
		
		System.out.print("\tP1 = "); p1.display();
		System.out.print("\tP2 = "); p2.display();
		
		if (p1.polynomialEqual(p2))
			System.out.println("\tIdentical polynomials");
		else
			System.out.println("\tNon-identical polynomials");
			
		
		/** 3.2 - Calculate p1(10) **/
		System.out.println("\n\n2 - Calculate p1(10) :");
		System.out.println("\tp1(10) = " + p1.evaluate(10));

		
		/** 3.3 - Show results of p1(x)=0 **/
		System.out.println("\n\n3 - Show equation results of p1(x)=0 :");
		p1.solveEquation();
	
		
		/** 3.4 - Calculate the derivative of p1 at the point x = 20 **/
		System.out.println("\n\n4 - Calculate the derivative of p1 at the point x = 20 :");
		p1 = p1.deriver();
		System.out.println("\tp1'(20) = " + p1.evaluate(20));

		
		/** 3.5 - Display the value of the multiplication of 3x + 5 and 6x + 7 
		 * at the point x = 10 **/
		System.out.println("\n\n5 - Display the value of the multiplication of 3x + 5 and 6x + 7 at the point x = 10 :");
		p1 = new Polynomial(new Monomial(0, 2), new Monomial(3, 1), new Monomial(5, 0));
		p2 = new Polynomial(new Monomial(0, 2), new Monomial(7, 0), new Monomial(6, 1));

		p1 = p1.multiply(p2);
		if (p1 != null)
			System.out.println("\tp1(10) x p2(10) = " + p1.evaluate(10));
		else
			System.out.println("\tMultiplication degree > 2");

		/**
		 * 3.6 - Display the value of the multiplication of
		 * 2xˆ2 + 3x + 5 and xˆ2 + 6x + 7 at point x = 10
		 **/
		System.out.println("\n\n5 - Display the value of the multiplication of 2xˆ2 + 3x + 5 and xˆ2 + 6x + 7 at the point x = 10 :");
		p1 = new Polynomial(new Monomial(2, 2), new Monomial(3, 1), new Monomial(5, 0));
		p2 = new Polynomial(new Monomial(1, 2), new Monomial(7, 0), new Monomial(6, 1));

		p1 = p1.multiply(p2);
		if (p1 != null)
			System.out.println("\tp1(10) x p2(10) = " + p1.evaluate(10));
		else
			System.out.println("\tMultiplication degree > 2");

	}

}
