package com.kklokker.calculator;

import java.util.Scanner;
public class Calc {

		private static List<String> tokens;

		public static double compute(String expression) {
			tokens = new List(expression);
			Fraction result = parseE();
			return result.value();
		}

		//Parse expression if plus minus or nothing
		private static Fraction parseE() {
			Fraction m = parseM();
			if(tokens.isEmpty() || tokens.head().equals(")")) return m;
			String nextToken = tokens.head();
			tokens.tail();
			Fraction e = parseE();
			if (nextToken.equals("+"))
				m.add(e);
			else if (nextToken.equals("-"))
				m.subtract(e);
			return m;
		}
		
		
		//Parse expression if multiply or divide or nothing
		private static Fraction parseM() {
			Fraction t = parseT();
			if(tokens.isEmpty()) return t;
			String nextToken = tokens.head();
			if (nextToken.equals("/")) {
				tokens.tail();
				Fraction m = parseM();
				t.divide(m);
			}
			else if (nextToken.equals("x")) {
				tokens.tail();
				Fraction m = parseM();
				t.multiply(m);
			}
			else if (nextToken.equals("%")) {
				tokens.tail();
				Fraction m = parseM();
				t.mod(m);
			}
			return t;
		}

		//Parse expression in parenthesisi or int
		private static Fraction parseT() {
			String nextToken = tokens.head();
			tokens.tail();
			if(nextToken.equals("(")){
				Fraction e = parseE();
				tokens.tail();
				return e;
			}
			else {
				int n;
					n = Integer.parseInt(nextToken);
				return new Fraction(n);
			}
		}
}
