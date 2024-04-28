package org.xmlrobot;

import org.xmlrobot.genesis.*;

public class Execution {

	public static void main(String[] args) {
		int dilatation = 1;
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
		
		Hyperchain hyperchain = new Hyperchain(1*dilatation, 'A');
		hyperchain.putValue(2*dilatation, 'B');
		hyperchain.putValue(3*dilatation, 'C');
		hyperchain.putValue(4*dilatation, 'D');
		hyperchain.putValue(5*dilatation, 'E');
		hyperchain.putValue(6*dilatation, 'F');
		hyperchain.putValue(7*dilatation, 'G');
		hyperchain.putValue(8*dilatation, 'H');
		hyperchain.putValue(9*dilatation, 'I');
		hyperchain.putValue(10*dilatation, 'J');
		hyperchain.putValue(11*dilatation, 'K');
		hyperchain.putValue(12*dilatation, 'L');
		hyperchain.putValue(13*dilatation, 'M');
		hyperchain.putValue(14*dilatation, 'N');
		hyperchain.putValue(15*dilatation, 'O');
		hyperchain.putValue(16*dilatation, 'P');
		hyperchain.putValue(17*dilatation, 'Q');
		hyperchain.putValue(18*dilatation, 'R');
		hyperchain.putValue(19*dilatation, 'S');
		hyperchain.putValue(20*dilatation, 'T');
		hyperchain.putValue(21*dilatation, 'U');
		hyperchain.putValue(22*dilatation, 'V');
		hyperchain.putValue(23*dilatation, 'W');
		hyperchain.putValue(24*dilatation, 'X');
		hyperchain.putValue(25*dilatation, 'Y');
		hyperchain.putValue(26*dilatation, 'Z');
		hyperchain.putValue(27*dilatation, 'Ç');

		Genomap genomap = new Genomap(hypercube, hyperchain);
		Haploid haploid = new Haploid(hyperchain, hypercube);
		
		Chromosome chromosome = new Chromosome(genomap, haploid);
		Diploid diploid = new Diploid(haploid, genomap);
		
		Ribosome ribosome = new Ribosome(chromosome, diploid);
		Tetraploid tetraploid = new Tetraploid(diploid, chromosome);
		
		Operon operon = new Operon(ribosome, tetraploid);
		Polyploid polyploid = new Polyploid(tetraploid, ribosome);
		
		Earth earth = new Earth(operon, polyploid);
		Gliese gliese = new Gliese(polyploid, operon);
		
		Sun sun = new Sun(earth, gliese);
		AlphaCentauri alphaCentauri = new AlphaCentauri(gliese, earth);
		
		MilkyWay milkyWay = new MilkyWay(sun, alphaCentauri);
		Andromeda andromeda = new Andromeda(alphaCentauri, sun);
		
		Supercluster supercluster = new Supercluster(milkyWay, andromeda);
		Interstellar interstellar = new Interstellar(andromeda, milkyWay);
		
		Matter matter = new Matter(supercluster, interstellar);
		Antimatter antimatter = new Antimatter(interstellar, supercluster);
		
		BigBang bigBang = new BigBang(matter, antimatter);
		BigBong bigBong = new BigBong(antimatter, matter);
		
		Aaron aaron = new Aaron(bigBang, bigBong);
		
		aaron.execute(aaron);
	}
}
