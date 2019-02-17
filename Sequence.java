// Vladimir Maksimovski

/**
	Sequence - a container supporting the operations specified in the handout.
*/

public class Sequence {
	enum DNAType {
		None, DNA, RNA;
	}
	
	private DNAType type;
	private LList<Character> data;

	public Sequence(){
		type = DNAType.None;
		data = new LList<Character>();
	}
	
	public Sequence(String stringType, String stringData){
		type = DNAType.None;
		if(stringType.equals("DNA")){
			type = DNAType.DNA;
		} else if(stringType.equals("RNA")){
			type = DNAType.RNA;
		}

		Character[] cArray = new Character[stringData.length()];
		
		for(int i = 0; i < stringData.length(); i++) {
			cArray[i] = stringData.charAt(i);
		}

		data = new LList<Character>(cArray);

		//throw out the sequence if it isn't a proper DNA/RNA sequence
		if(!selfValidate()){
			type = DNAType.None;
			data = new LList<Character>();
		}
	}
	
	public Sequence(Sequence x) {
		type = x.type;
		data = new LList<Character>(x.data);
	}
	
	//Note: sequence may exist when string is empty.
	public boolean isEmpty() {
		return (type == DNAType.None);
	}
	
	public int getSequenceLength() {
		return data.getSize();
	}
	
	public String getType() {
		if(type == DNAType.DNA) {
			return "DNA";
		} else if(type == DNAType.RNA) {
			return "RNA";
		}
		return "";
	}
	
	public void clip(int a, int b) {
		if(a > b) {
			data = new LList<Character>();
			return;
		}

		//clip from [a, b] is equivalent to
		//remove last data.size()-b-1 elements and remove first a elements
		data.deleteLastNElem((data.getSize() - 1) - b);
		data.deleteFirstNElem(a);
	}
	
	public void transcribe() {
		if(type != DNAType.DNA){
			return;
		}

		type = DNAType.RNA;

		String stringData = dataToString();
		Character[] charData = new Character[stringData.length()];

		for(int i = 0; i < stringData.length(); i++){
			if(stringData.charAt(i) == 'A'){
				charData[i] = 'U';
			} else if(stringData.charAt(i) == 'C'){
				charData[i] = 'G';
			} else if(stringData.charAt(i) == 'G'){
				charData[i] = 'C';
			} else if(stringData.charAt(i) == 'T'){
				charData[i] = 'A';
			}
		}

		data = new LList<Character>(charData);

		data.reverse();
	}
	
	/** 
	* selfValidate() ensures the sequence is a proper DNA/RNA sequence.
	* @return boolean that represents check result
	*/
	public boolean selfValidate(){
		String stringData = dataToString();

		if(type == DNAType.DNA){
			for(int i = 0; i < stringData.length(); i++){
				if(stringData.charAt(i) != 'A' && stringData.charAt(i) != 'C'
						&& stringData.charAt(i) != 'G' && stringData.charAt(i) != 'T'){
					System.out.println("Error occurred while inserting");
					return false;
				}
			}

			return true;
		} else if(type == DNAType.RNA){
			for(int i = 0; i < stringData.length(); i++){
				if(stringData.charAt(i) != 'A' && stringData.charAt(i) != 'C'
						&& stringData.charAt(i) != 'G' && stringData.charAt(i) != 'U'){
					System.out.println("Error occurred while inserting");
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public Sequence createCopy() {
		return new Sequence(this);
	}
	
	public String dataToString() {
		char[] stringData = new char[data.getSize()];
		
		int currIte = 0;
		for(Node<Character> i = data.head().next(); i != data.tail(); i = i.next()) {
			stringData[currIte] = i.data();
			currIte++;
		}
		
		return String.valueOf(stringData);
	}
	
	public String toString(){
		String result = "";

		if(type == DNAType.DNA){
			result = "DNA\t" + dataToString();
		} else if(type == DNAType.RNA){
			result = "RNA\t" + dataToString();
		}

		return result;
	}
}