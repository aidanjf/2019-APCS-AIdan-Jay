/* Aidan Jay, Overlake APCS, 1/9/2019
Project 6 - DNA: This program mainly uses arrays and Scanners to take in an input file filled with data on DNA
and print out certain statistics about each string of nucleotides by using a PrintStream to an output file.
*/
import java.util.*;
import java.io.*;

public class DNA {
   public static final int minCodons = 4;
   public static final int validPercentage = 30;
   public static final int uniqueNucleotides = 4;
   public static final int nucleotidesPerCodon = 3;
   
   /** Prints the starting message, prompts the user for an input and output file, creates a PrintStream object for the output
    *  file, and calls the method that manages dealing with the all the file processing and printing.
    *  Precondition: User inputs valid file names, throws FileNotFoundException.
    *  Postcondition:
    *     -Intro is printed
    *     -Information on input file is printed
    */
   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("This program reports information about DNA nucleotide sequences that may encode proteins.");
      System.out.println();
      Scanner user = new Scanner(System.in);
      System.out.print("Input file name? ");
      File input = new File(user.next());
      System.out.print("Output file name? ");
      File output = new File(user.next());
      PrintStream writeOutput = new PrintStream(output);
      manageProteins(input, output, writeOutput);
   }
   
   /** Manages processing each line of the input file using a while loop and method calls, and prints output.
    *  Takes in the input file, output file, and the PrintStream for the output file as parameters.
    *  Precondition: Files are vaild, throws FileNotFoundException.
    *  PostCondition: 
    *     -Output file is written and printed
    */
   public static void manageProteins(File input, File output, PrintStream writeOutput) throws FileNotFoundException {
      Scanner file = new Scanner(input);
      while (file.hasNextLine()) {
         String name = file.nextLine();
         String nucleotides = file.nextLine().toUpperCase();
         int[] nucleotideCounts = countNucleotides(nucleotides);
         double[] percentages = calcPercentages(nucleotides, nucleotideCounts);
         String[] codons = formatCodons(nucleotides);
         String protein = encodesAProtein(codons, percentages);
         writeOutput(name, nucleotides, nucleotideCounts, percentages, codons, protein, writeOutput);
      }
      Scanner outputFile = new Scanner(output);
      while (outputFile.hasNextLine()) {
         System.out.println(outputFile.nextLine());
      }
   } 
   
   /** Takes in the String of nucleotides as a parameter, creates an array for the number of each nucleotide,
    *  iterates through the string and fils in the array, returns the array.
    *  Precondition: String is a valid string of nucleotides.
    *  Postcondition:
    *     -Array of number of nucleotides is returned
    */
   public static int[] countNucleotides(String nucleotides) {
      int[] nucleotideCounts = new int[uniqueNucleotides];
      for (int i = 0; i < nucleotides.length(); i++) {
         if (nucleotides.charAt(i) == 'A') {
            nucleotideCounts[0]++;
         } else if (nucleotides.charAt(i) == 'C') {
           nucleotideCounts[1]++;
         } else if (nucleotides.charAt(i) == 'G') {
            nucleotideCounts[2]++;
         } else {
            nucleotideCounts[3]++;
         }
      }
      return nucleotideCounts;
   }
   
   /** Takes in the string of nucleotides and the array of nucleotide counts as parameters, counts the total mass of the String
    *  of nucleotides, creates an array for the mass percentages of each nucleotide and it fills it accordingly, and returns the array
    *  of percentages.
    *  Precondition: None.
    *  Postcondition:
    *     -Array of percentages is returned
    */
   public static double[] calcPercentages(String nucleotides, int[] nucleotideCounts) {
     double[] percentages = new double[uniqueNucleotides];
     double totalMass = 0;
     for (int i = 0; i < nucleotideCounts.length; i++) {
         totalMass += mass(i) * nucleotideCounts[i];
     }
     for (int i = 0; i < percentages.length; i++) {
         percentages[i] = Math.round(1000.0 * (nucleotideCounts[i] * mass(i)) / totalMass) /10.0;
     }
     return percentages;
   }
   
   /** Takes in the index of the nucleotide array and returns the according mass.
    *  Precondition: Index is valid.
    *  Postcondition:
    *     -Mass is returned
    */
   public static double mass(int nucleotide) {
      if (nucleotide == 0) {
         return 135.128;
      } else if (nucleotide == 1) {
         return 111.103;
      } else if (nucleotide == 2) {
         return 151.128;
      } else {
         return 125.107;
      }
   }
   
   /** Takes in the string of nucleotides as a parameter, creates an array for each codon and fills it, returns the array.
    *  Precondition: None.
    *  Postcondition: 
    *     -Array of codons
    */
   public static String[] formatCodons(String nucleotides) {
      String[] codons = new String[nucleotides.length() / nucleotidesPerCodon];
      for (int i = 0; i < codons.length; i++) {
         codons[i] = nucleotides.substring(0, nucleotidesPerCodon);
         nucleotides = nucleotides.substring(nucleotidesPerCodon);
      }
      return codons;
   }
   
   /** Takes in the codons array and percentages array as parameters, returns a string whether or not the sequence encodes a protein.
    *  Precondition: None.
    *  Postcondition: 
    *     -Yes or no is returned as a string
    */
   public static String encodesAProtein(String[] codons, double[] percentages) {
      //This statement simply tests for all of the conditions for a sequence to encode a protein
      if (percentages[1] + percentages[2] >= validPercentage && codons[0].equals("ATG") && (codons[codons.length - 1].equals("TAA") || codons[codons.length - 1].equals("TAG") 
               || codons[codons.length - 1].equals("TGA")) && (codons.length >= minCodons)) {
         return "yes";
      } else {
         return "no";
      }
   }
   
   /** Takes in the name of the sequence as a String, the sequence itself as a String, all of the arrays with data on the sequence
    *  the String of whether or not it's a protein, and the PrintStream for the output file to write the output file.
    *  Precondition: All parameters have valid information.
    *  Postcondition:
    *     -Output file is written.
    */
   public static void writeOutput(String name, String nucleotides, int[] nucleotideCounts, double[] percentages, 
               String[] codons, String protein, PrintStream writeOutput) {
      writeOutput.println();
      writeOutput.println("Name: " + name);
      writeOutput.println("Nucleotides: " + nucleotides); 
      writeOutput.println("Nucleotide counts: " + Arrays.toString(nucleotideCounts));
      writeOutput.println("Mass percentages: " + Arrays.toString(percentages));
      writeOutput.println("Codons: " + Arrays.toString(codons));
      writeOutput.println("Encodes a protein: " + protein);
   }
}