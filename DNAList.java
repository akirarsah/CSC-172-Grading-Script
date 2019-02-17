// Vladimir Maksimovski

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DNAList {
	public static void main(String[] args) {
		//assert args.length == 2 : "ERROR: Wrong number of arguments";
		
		int sequenceLength = Integer.valueOf(args[0]);

		Sequence[] sequenceArray = new Sequence[sequenceLength];
		for(int i = 0; i < sequenceLength; i++) {
			sequenceArray[i] = new Sequence();
		}

		try {
			File file = new File(args[1]);
			Scanner fileScanner = new Scanner(file);

			while(fileScanner.hasNext()){
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);

				if(!lineScanner.hasNext()) {
					continue;
				}
		
				String currToken = lineScanner.next();
				
				if(currToken.equals("insert")) {
					String stringPosition, stringType, stringSequence;
					stringPosition = lineScanner.next();
					stringType = lineScanner.next();
					stringSequence = ""; // Note: Input may be empty
					if(lineScanner.hasNext()) {
						stringSequence = lineScanner.next();
					}
					
					int position = Integer.parseInt(stringPosition);
					
					Sequence newInsert = new Sequence(stringType, stringSequence);
					if(0 <= position && position < sequenceLength && newInsert.selfValidate()) {
						sequenceArray[position] = newInsert;
					}
				} else if(currToken.equals("remove")) {
					String stringPosition = lineScanner.next();
					int position = Integer.parseInt(stringPosition);
					if(sequenceArray[position].isEmpty()) System.out.println("No sequence to remove at specified position");
					if(0 <= position && position < sequenceLength) {
						sequenceArray[position] = new Sequence();
					}
				} else if (currToken.equals("print")) {
					boolean printAllValues = true;
					int position = -1;

					if(lineScanner.hasNext()){
						String stringPosition = lineScanner.next();
						if(stringPosition.matches(".*\\d+.*")){
							printAllValues = false;
							position = Integer.parseInt(stringPosition);
						}
					}

					if(printAllValues){
						for(int i = 0; i < sequenceLength; i++) {
							String response = sequenceArray[i].toString();
							
							if(response != "") {
								System.out.println(String.valueOf(i) + "\t" + response);
							}
						}
					} else {
						if(sequenceArray[position].isEmpty()) System.out.println("No sequence to print at specified position");
						if(0 <= position && position < sequenceLength && !sequenceArray[position].isEmpty()) {
							String response = sequenceArray[position].toString();
							
							if(response != "") {
								System.out.println(response);
							} else {
								System.out.println("ERROR: Sequence is empty or invalid");
							}
						}
					}
				} else if(currToken.equals("clip")) {
					String stringPositionA = lineScanner.next();
					int positionA = Integer.parseInt(stringPositionA);
					String stringPositionB = lineScanner.next();
					int positionB = Integer.parseInt(stringPositionB);
					String stringPositionC = lineScanner.next();
					int positionC = Integer.parseInt(stringPositionC);
					
					if(0 > positionB) {
						System.out.println("Start index is out of bounds");
					}
					if(positionC > sequenceArray[positionA].getSequenceLength() && positionB < positionC) {
						System.out.println("End index is out of bounds");
					}
					//if(positionB > positionC) sequenceArray[positionA]
					
					if(0 <= positionA && positionA < sequenceLength
							&& 0 <= positionB && positionB < sequenceArray[positionA].getSequenceLength()
							&& 0 <= positionC && positionC < sequenceArray[positionA].getSequenceLength()
							&& !sequenceArray[positionA].isEmpty()) {
						sequenceArray[positionA].clip(positionB, positionC);
					}
					
				} else if(currToken.equals("copy")) {
					String stringPositionA = lineScanner.next();
					int positionA = Integer.parseInt(stringPositionA);
					String stringPositionB = lineScanner.next();
					int positionB = Integer.parseInt(stringPositionB);
					
					if(0 <= positionA && positionA < sequenceLength
							&& 0 <= positionB && positionB < sequenceLength) {
						if (sequenceArray[positionA].isEmpty()) {
							System.out.println("No sequence to copy at specified position");
							continue;
						}
						
						sequenceArray[positionB] = new Sequence(sequenceArray[positionA]);
					}
				} else if(currToken.equals("transcribe")) {
					String stringPosition = lineScanner.next();
					int position = Integer.parseInt(stringPosition);
					
					if(0 <= position && position < sequenceLength) {
						if(sequenceArray[position].isEmpty()) {
							System.out.println("No sequence to transcribe at specified position");
							continue;
						}
						if(sequenceArray[position].getType() == "RNA") System.out.println("Cannot transcribe RNA");
						
						if(sequenceArray[position].getType() == "DNA") {
							sequenceArray[position].transcribe();
						}
					}
				}
				
				lineScanner.close();
			}
			
			fileScanner.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}