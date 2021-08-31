import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {
	
	/***************************** Variables *****************************/
	protected Monomial a;
	protected Monomial b;
	protected Monomial c;
	

	/***************************** Contractors *****************************/
	public Polynomial(Monomial a,Monomial b,Monomial c) {
		ArrayList<Monomial> temp = new ArrayList<>(Arrays.asList(a,b,c));
		Collections.sort(temp);
		this.a = temp.get(0);
		this.b = temp.get(1);
		this.c = temp.get(2);
		
	}

	/***************************** Methods *****************************/
	public int degree() {
		if(a.getCoefficient()!=0)
			return a.getDegree();
		else if(b.getCoefficient()!=0)
			return b.getDegree();
		return c.getDegree();
	}

	public double discriminant() {
		return b.getCoefficient() * b.getCoefficient() - 4 * a.getCoefficient() * c.getCoefficient();
	}

	public void display() {
		if(a.getCoefficient() != 0)
			System.out.print(a.display());
		if(b.getCoefficient() != 0)
			System.out.print(" + " + b.display());
		if(c.getCoefficient() != 0)
			System.out.print(" + " + c.display());
		
		System.out.println();
	}

	public double evaluate(double d) {
		return a.evaluate(d) + b.evaluate(d) + c.evaluate(d);
	}

	public void solveEquation() {
		if (degree() < 2)
			System.out.println("\tEquation of degree less than two");
		else if (degree() > 2)
			System.out.println("\tEquation of degree greater than two");
		else {
			if (discriminant() < 0)
				System.out.println("\tThe equation does not admit solutions");
			else if (discriminant() == 0)
				System.out.println("\tThe equation admits a double solution x = "
						+ (-1 * b.getCoefficient() / 2 / a.getCoefficient()));
			else 
				System.out.println("\tThe equation admits two solutions    x1 = "
						+ (-1 * b.getCoefficient() - Math.sqrt(discriminant())) / 2 / a.getCoefficient() + "     x2 = "
						+ (-1 * b.getCoefficient() + Math.sqrt(discriminant())) / 2 / a.getCoefficient());
		}
	}

	public Polynomial multiply(Polynomial p) {
		if ((degree() + p.degree()) > 2) {
			return null;
		}

		else {
			// array to store the multiplication of monomials 
			// a + b + c
			// x a1 + b1 + c1

			ArrayList<Monomial> array = new ArrayList<Monomial>();
			array.add(0, c.multiply(p.c));
			array.add(1, c.multiply(p.b));
			array.add(2, c.multiply(p.a));

			array.add(3, b.multiply(p.c));
			array.add(4, b.multiply(p.b));
			array.add(5, b.multiply(p.a));

			array.add(6, a.multiply(p.c));
			array.add(7, a.multiply(p.b));
			array.add(8, a.multiply(p.a));
		
			Monomial m0 = new Monomial(0); // m0 monomial of degree 0 
			Monomial m1 = new Monomial(0, 1); // m1 monomial of degree 1
			Monomial m2 = new Monomial(0, 2); // m2 monomial of degree 2

			for (Monomial m : array) {
				if (m.getDegree() == 0)
					m0.sum(m);
				else if (m.getDegree() == 1)
					m1.sum(m);
				else if (m.getDegree() == 2)
					m2.sum(m);

			}

			return new Polynomial(m2, m1, m0);
		}
	}

	public Polynomial deriver() {
		return new Polynomial(a.derive(), b.derive(), c.derive());
	}

	public boolean polynomialEqual(Polynomial p) {
		return (a.monomialEqual(p.a) && b.monomialEqual(p.b) && c.monomialEqual(p.c));
	}

	/****************************** Getters *****************************/
	public Monomial getA() {
		return a;
	}
	
	public Monomial getB() {
		return b;
	}

	public Monomial getC() {
		return c;
	}

}
