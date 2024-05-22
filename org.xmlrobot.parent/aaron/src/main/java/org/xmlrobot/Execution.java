package org.xmlrobot;

import org.xmlrobot.genesis.*;

public class Execution {

	public static void main(String[] args) {
		int dilatation = 10000;
		Hypercube hypercube = new Hypercube('A', 1*dilatation);
		hypercube.putValue('B', 2*dilatation);
		hypercube.putValue('C', 3*dilatation);
		hypercube.putValue('D', 4*dilatation);
		hypercube.putValue('E', 5*dilatation);
		hypercube.putValue('F', 6*dilatation);
		hypercube.putValue('G', 7*dilatation);
		hypercube.putValue('H', 8*dilatation);
		hypercube.putValue('I', 9*dilatation);
		hypercube.putValue('J', 10*dilatation);
		hypercube.putValue('K', 11*dilatation);
		hypercube.putValue('L', 12*dilatation);
		hypercube.putValue('M', 13*dilatation);
		hypercube.putValue('N', 14*dilatation);
		hypercube.putValue('O', 15*dilatation);
		hypercube.putValue('P', 16*dilatation);
		hypercube.putValue('Q', 17*dilatation);
		hypercube.putValue('R', 18*dilatation);
		hypercube.putValue('S', 19*dilatation);
		hypercube.putValue('T', 20*dilatation);
		hypercube.putValue('U', 21*dilatation);
		hypercube.putValue('V', 22*dilatation);
		hypercube.putValue('W', 23*dilatation);
		hypercube.putValue('X', 24*dilatation);
		hypercube.putValue('Y', 25*dilatation);
		hypercube.putValue('Z', 26*dilatation);
		hypercube.putValue('Ç', 27*dilatation);
		
		Genomap genomap = new Genomap(hypercube, (Hyperchain) hypercube.getChild());
		Chromosome chromosome = new Chromosome(genomap, (Haploid) genomap.getChild());
		Ribosome ribosome = new Ribosome(chromosome, (Diploid) chromosome.getChild());
		Operon operon = new Operon(ribosome, (Tetraploid) ribosome.getChild());
		Earth earth = new Earth(operon, (Polyploid) operon.getChild());
		Sun sun = new Sun(earth, (Gliese) earth.getChild());
		MilkyWay milkyWay = new MilkyWay(sun, (AlphaCentauri) sun.getChild());
		Supercluster supercluster = new Supercluster(milkyWay, (Andromeda) milkyWay.getChild());
		Matter matter = new Matter(supercluster, (Interstellar) supercluster.getChild());
		BigBang bigBang = new BigBang(matter, (Antimatter) matter.getChild());
		Aaron aaron = new Aaron(bigBang, (BigBong) bigBang.getChild());
		
		aaron.execute(aaron);
	}
}
