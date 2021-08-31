public class Monomial implements Comparable<Monomial> {

	/***************************** Variables *****************************/
	private double coefficient;
	private int degree;

	//we don't need an attribute to represent x because x is an independent variable of the monomial. 
	// (does not depend on the Monomial class)
	
	/***************************** Contractors *****************************/
	public Monomial(double coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}

	
	public Monomial(double coefficient) {
		this.coefficient = coefficient;
		this.degree = 0;
	}

	/** Methods **/
	public Monomial derive() {
		return new Monomial(coefficient * degree, degree - 1);
	}

	public double evaluate(double x) {
		return coefficient * Math.pow(x, degree);
	}

	public String display() {
		return coefficient + "xˆ" + degree;
	}

	public boolean monomialEqual(Monomial m) {
		return (coefficient == m.coefficient && degree == m.degree);
	}

	public Monomial multiply(Monomial m) {
		return new Monomial(coefficient * m.coefficient, degree + m.degree);
	}

	public void sum(Monomial m) {
		if (degree == m.degree)
			coefficient += m.coefficient;
	}

	@Override
	public int compareTo(Monomial a) {
		 return this.degree < a.degree ? 1 : (this.degree > a.degree ? -1 : 0);
	}
	
	/****************************** Getters and Setters *****************************/
	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	

}
