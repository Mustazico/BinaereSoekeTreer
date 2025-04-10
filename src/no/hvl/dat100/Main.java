package no.hvl.dat100;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Integer antallNoder = 1023;

		BS_Tre[] liste = new BS_Tre[100];
		
		
		
		List<BS_Tre<Integer>> binaerTreListe = new ArrayList<BS_Tre<Integer>>(100);
		
		for (int i = 0; i < 100; i++) {
			Random terning = new Random();
			int tall = terning.nextInt();
			binaerTreListe.add(new BS_Tre<Integer>(tall));
			liste[i] = new BS_Tre<Integer>();
			for (int k = 0; k < antallNoder; k++) {
			tall = terning.nextInt();
			binaerTreListe.get(i).leggTil(tall);

			}
		} System.out.println("Hoyde i treer fra liste: ");
		int minsteHoyde = 1000;
		int storsteHoyde = -1;
		double totHoyde = 0;
		double snittHoyde = 0;
		
		for (int i = 0; i < binaerTreListe.size(); i++) {
		System.out.println("Hoyde i tre " + i + " = " + binaerTreListe.get(i).hoyde());
		totHoyde += binaerTreListe.get(i).hoyde();
		
		if (binaerTreListe.get(i).hoyde() < minsteHoyde)
			minsteHoyde = binaerTreListe.get(i).hoyde();
		if (binaerTreListe.get(i).hoyde() > storsteHoyde) 
			storsteHoyde = binaerTreListe.get(i).hoyde();
		}
		snittHoyde = totHoyde/binaerTreListe.size();
	System.out.println("Minste hoyde: " + minsteHoyde);
	System.out.println("Storste hoyde: " + storsteHoyde);
	System.out.println("Snitt hoyde: " + snittHoyde);
		System.out.println("Antall noder i tre: " + binaerTreListe.get(0).antNoder());
		System.out.println("Minimum hoyde i tre fra liste:" + BS_Tre.minimumHoyde(binaerTreListe.get(0).antNoder()));
		System.out.println("Minimum hoyde i tre med n noder: " + BS_Tre.minimumHoyde(1000));
		System.out.println("Maksimum hoyde i tre med n noder: " + BS_Tre.maksimumHoyde(1000));
		System.out.println();
		System.out.println();
		
	
		/*
		 * BS_Tre<Integer> tre = new BS_Tre<Integer>(1);
		 * 
		 * tre.leggTil(3); tre.leggTil(-1); tre.leggTil(7); tre.leggTil(-5);
		 * tre.leggTil(2); tre.leggTil(8); tre.leggTil(-6); tre.leggTil(9);
		 * tre.leggTil(-11); tre.leggTil(15); tre.leggTil(-4); tre.leggTil(-2);
		 * tre.leggTil(-20); tre.leggTil(-21);
		 * 
		 * System.out.println(tre.hoyde());
		 */
	

}}
