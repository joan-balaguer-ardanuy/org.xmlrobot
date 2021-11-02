/**
 * 
 */
package org.xmlrobot;

import org.xmlrobot.genesis.Genomap;
import org.xmlrobot.genesis.Haploid;
import org.xmlrobot.genesis.Hyperinteger;
import org.xmlrobot.genesis.Hyperstring;

/**
 * @author joan
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(java.lang.String[] args) {
		
		Character A = new Character('A');
		Integer a = new Integer('A');
		Character B = new Character('B');
		Integer b = new Integer('B');
		Character C = new Character('C');
		Integer c = new Integer('C');
		Character D = new Character('D');
		Integer d = new Integer('D');
		Character E = new Character('E');
		Integer e = new Integer('E');
		Character F = new Character('F');
		Integer f = new Integer('F');
		Character G = new Character('G');
		Integer g = new Integer('G');
		Character H = new Character('H');
		Integer h = new Integer('H');
		
		Character I = new Character('I');
		Integer i = new Integer('I');
		Character J = new Character('J');
		Integer j = new Integer('J');
		Character K = new Character('K');
		Integer k = new Integer('K');
		Character L = new Character('L');
		Integer l = new Integer('L');
		Character M = new Character('M');
		Integer m = new Integer('M');
		Character N = new Character('N');
		Integer n = new Integer('N');
		Character O = new Character('O');
		Integer o = new Integer('O');
		Character P = new Character('P');
		Integer p = new Integer('P');
		
		Hyperstring cube1 = new Hyperstring(A, a);
		cube1.putValue(B, b);
		cube1.putValue(C, c);
		cube1.putValue(D, d);
		cube1.putValue(E, e);
		cube1.putValue(F, f);
		cube1.putValue(G, g);
		cube1.putValue(H, h);
		
		Hyperinteger chain1 = new Hyperinteger(i, I);
		chain1.putValue(j, J);
		chain1.putValue(k, K);
		chain1.putValue(l, L);
		chain1.putValue(m, M);
		chain1.putValue(n, N);
		chain1.putValue(o, O);
		chain1.putValue(p, P);
		
		Genomap map1 = new Genomap(cube1, chain1);
		Haploid set1 = new Haploid(chain1, cube1);
		
		map1.compareTo(set1);
		
		System.out.println(map1.comparator().source().getKey().getName());
		
//		cube1.run();
		
//		Hyperinteger chain1 = new Hyperinteger(i, I);
//		chain1.putValue(j, J);
//		chain1.putValue(k, K);
//		chain1.putValue(l, L);
//		chain1.putValue(m, M);
//		chain1.putValue(n, N);
//		chain1.putValue(o, O);
//		chain1.putValue(p, P);

//		
//		
//		Hyperchain chain2 = new Hyperchain(i, I);
//		chain2.putValue(j, J);
//		chain2.putValue(k, K);
//		chain2.putValue(l, L);
//		chain2.putValue(m, M);
//		chain2.putValue(n, N);
//		chain2.putValue(o, O);
//		chain2.putValue(p, P);
		
//		Genomap genomap1 = new Genomap(cube1, (Hyperchain) cube1.getChild());
//		Haploid haploid1 = new Haploid(chain2, cube2);
//		Cromosoma cromosoma1 = new Cromosoma(genomap1, (Haploid) genomap1.getChild());
//		cromosoma1.run();
		
//		cube1.reproduce(cube1, cube1.getChild());
//		System.out.println(cube1.reproducer().source().getName());
		
////		
//		Hypercube cube2 = new Hypercube(I, i);
//		cube2.putValue(I, i);
//		cube2.putValue(J, j);
//		cube2.putValue(K, k);
//		cube2.putValue(L, l);
//		cube2.putValue(M, m);
//		cube2.putValue(N, n);
//		cube2.putValue(O, o);
////		
//		Hyperchain chain2 = new Hyperchain(i, I);
//		chain2.putValue(j, J);
//		chain2.putValue(k, K);
//		chain2.putValue(l, L);
//		chain2.putValue(m, M);
//		chain2.putValue(n, N);
//		chain2.putValue(o, O);
//		chain2.putValue(p, P);
		
//		
		
//		genomap1.putValue(cube2, (Hyperchain) cube2.getChild());
//		Haploid haploid1 = new Haploid(chain2, (Hypercube) chain2.getChild());
//		haploid1.putValue(chain1, cube1);
//		
//		Cromosoma cromosoma1 = new Cromosoma(genomap1, (Haploid) genomap1.getChild());
//		cromosoma1.run();
		
		
//		Haploid haploid1 = new Haploid(chain2, cube2);
		
//		Cromosoma cromosoma1 = new Cromosoma(genomap1, haploid1);
//		cromosoma1.run();
		
//		Genomap genomap2 = new Genomap(cube1, chain1);
//		genomap1.pushChild(genomap2, genomap2.getChild());
		
//		Haploid haploid1 = new Haploid(chain2, cube2);
////		haploid1.run();
//		
//		genomap1.compareTo(haploid1);
////		
//		for(Mass<Hypercube,Hyperchain> entry : genomap1.comparator().getSource()) {
//
//			for(Mass<Character,Integer> entry2 : entry.getKey()) {
//				System.out.println(entry2.getKey() + entry2.getValue().toString());
//			}
//		}
	}
}