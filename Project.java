import java.io.BufferedReader;
import java.io.FileReader;

public class Project {
	public static void main(String[] args) throws Exception {
		String[] parts;
		int binary1;
		int binary2;
		String memory = "",instruction = "";
		int i = -1;
		String input;
		boolean legall = false;
		String[][] whole = new String [10][10];  
		int[] registers = new int[32];
		//for(int p = 0; i < registers.length;i++){
			//System.out.println("Befor instructions "+registers[p]);
		//}
		/*for(int n = 0;n < registers.length; n++){
			registers[n] = n; 
		}
		*/
		//System.out.println(registers[31]);
		try (BufferedReader br = new BufferedReader(new FileReader("input_project.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				i++;

				parts = (line).split("\\s+");
				binary1 = Integer.parseInt(parts[0], 16); // convert memory
																// part into
																// binary
				binary2 = Integer.parseInt(parts[1], 16); // convert
																// instruction
																// part to
																// binary
				memory = String.format("%32s",
						Integer.toBinaryString(binary1)).replace(' ', '0');// string
																			// of
																			// memory
																			// code
				instruction = String.format("%32s",
						Integer.toBinaryString(binary2)).replace(' ', '0');// string
																			// instruction
																			// code
				whole[i][0] = memory;
				whole[i][1] = instruction;
				
		    	line = br.readLine();

				
				 //  int rtTEST = Integer.parseInt(instruction.substring(0, 16),2);
				  // int rsTEST = Integer.parseInt(instruction.substring(6, 11),2);
				   //int rdTEST = Integer.parseInt(instruction.substring(16, 21),2);
				  // registers[rdTEST] = registers[rtTEST] + registers[rsTEST];
				   
				  // System.out.println("rt "+rtTEST);
				   //System.out.println("rs "+rsTEST);
				   //System.out.println("rd "+rdTEST);
				   //System.out.println("rsR "+registers[rsTEST]);
				 //  System.out.println("rtR "+registers[rtTEST] );
			//	   System.out.println("rdR "+registers[rdTEST]);



			//System.out.println(rtTest);
			//System.out.println(memory);
			//System.out.println(instruction);
			//if(instruction.substring(0,6).equals("000000")){
			//System.out.println("test passed "+instruction.substring(26,32));
			//}
				
				

			
		}
		}
		/*
		System.out.println(Integer.toHexString(Integer.parseInt(whole[0][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[0][1], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[1][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[1][1], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[2][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[2][1], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[3][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[3][1], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[4][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[4][1], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[5][0], 2)));
		System.out.println(Integer.toHexString(Integer.parseInt(whole[5][1], 2)));
		//System.out.println(Integer.toHexString(Integer.parseInt(whole[6][0], 2)));
		//System.out.println(Integer.toHexString(Integer.parseInt(whole[6][1], 2)));
*/
		//System.out.println(whole[6][0]);
		//System.out.println(whole[6][1]);
		//System.out.println("last memory "+Integer.toHexString(Integer.parseInt(whole[6][0], 2)));
		//System.out.println("last instruction "+Integer.toHexString(Integer.parseInt(whole[6][1], 2)));
				
		int n = 0;
		int beq = 0;
		int bne = 0;
		instruction = whole[n][0];
	//	System.out.println("second "+whole[1][1].substring(0, 6));
	//	System.out.println("instruction "+instruction);
		//System.out.println("t1 "+whole[2][0]);
		

		while(whole[n][0] != null){
			memory = whole[n][0];
			instruction = whole[n][1];
			//System.out.println("n "+n);
			//System.out.println("instruction "+instruction.substring(0, 6));
		if(instruction.substring(0,6).equals("000000")){
			if(instruction.subSequence(26,32) == "000000"){// sll
		   		legall = true;
				int rt = Integer.parseInt(instruction.substring(11, 16),2);
				int rd = Integer.parseInt(instruction.substring(16, 21),2);
				int shift = Integer.parseInt(instruction.substring(21, 26),2);
				registers[rd] = registers[rt] << shift;
				//System.out.println("test1 "+registers[rd]);
				n++;

			}
	   else if(instruction.substring(26,32).equals("000010")){//srl
		   		legall = true;
				int rt = Integer.parseInt(instruction.substring(11, 16),2);
				int rd = Integer.parseInt(instruction.substring(16, 21),2);
				int shift = Integer.parseInt(instruction.substring(21, 26),2);
				registers[rd] = registers[rt] >> shift;
				//System.out.println("test2 "+registers[rd]);
				n++;

			}
	   if(instruction.substring(26,32).equals("100000")){//add
	   		legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);
		   registers[rd] = registers[rt] + registers[rs];
			//System.out.println("test3 "+registers[rd]);
			n++;

	   }
	   
	   else if(instruction.substring(26,32).equals("10100")){// and
	   		legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);
		   registers[rd] = registers[rt] & registers[rs];
			//System.out.println("test4 "+registers[rd]);
			n++;

	   }
	   else if(instruction.substring(26,32).equals("101010")){// slt
	   		legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);
		   if(registers[rs] < registers[rt]){
			   registers[rd] = 1;
			   n++;
		   }
		   else{
			   registers[rd] = 0;
			//System.out.println("test5 "+registers[rd]);
			n++;
		   }

	   }
	   else if(instruction.substring(26,32).equals("101011")){// sltu
	   		legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);	
		   if(rs < 0)
			   rs = rs *-1;
		   if(rt < 0)
			   rt = rt * -1;
		   if(registers[rs] < registers[rt]){
			   registers[rd] = 1;
			   n++;
		   }
		   else{
			   registers[rd] = 0;
			//System.out.println("test6 "+registers[rd]);
			n++;
		   }

		   
	   }
	   else if(instruction.substring(26,32).equals("100111")){//Nor
	   		legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);
		   registers[rd] = ~(registers[rs] | registers[rt]);
			//System.out.println("test7 "+registers[rd]);
			n++;

	   }
	   else if(instruction.substring(26,32).equals("101011")){
		   legall = true;
		   int rt = Integer.parseInt(instruction.substring(11, 16),2);
		   int rs = Integer.parseInt(instruction.substring(6, 11),2);
		   int rd = Integer.parseInt(instruction.substring(16, 21),2);
	   }
			
			
		}//start of I format 
		else if(instruction.substring(0,6).equals("001000")){	//addi
	   		legall = true;
			int rt = Integer.parseInt(instruction.substring(11, 16),2);
			int rs = Integer.parseInt(instruction.substring(6, 11),2);
		    int immi = Integer.parseInt(instruction.substring(16, 32),2);
		    registers[rt] = registers[rs] + immi; 
			//System.out.println("test8 "+registers[rt]);
			System.out.println(rt);
			n++;

			
		}
		else if(instruction.substring(0,6).equals("000100")){//beq
			//System.out.println("n at the first of bne "+ n);
	    	String newImmi = "";
			boolean jump = false;
	   		legall = true;
			int rt = Integer.parseInt(instruction.substring(11, 16),2);
			int rs = Integer.parseInt(instruction.substring(6, 11),2);
		    int immi = Integer.parseInt(instruction.substring(16, 32),2);
		    long PC = Long.parseLong(memory.substring(0, 32),2);
		    long newTarget;
		    if(registers[rs] == registers[rt]){
		    	//System.out.println("immi "+ Integer.toBinaryString(immi));
		    	//System.out.println("PC "+ Integer.toBinaryString(PC));
		    	//System.out.println("highest bit "+ Integer.highestOneBit(immi));
		    	// signed extend immi
		    	
		    	if(Integer.highestOneBit(immi) == 0){
		    		newImmi = "0000000000000000" + Integer.toString(immi, 2);		    	}
		    	else if(Integer.highestOneBit(immi) != 1){
		    		newImmi = "1111111111111111" + Integer.toString(immi, 2);
		    	}
		    	// multiply immi by 4
		    	long Integerimmi= Long.parseLong(newImmi,2);
		    	Integerimmi = Integerimmi *4;
		    	//System.out.println("multiplied "+ Integerimmi);
		    	// immi + PC
		    	//System.out.println("pc"+ PC);
		    	newTarget = Integerimmi + PC;
		    	//System.out.println("newTarget TEST"+ newTarget);
		    	String Final1 = Long.toBinaryString(newTarget);
		    	String Final2 = Final1.substring(Final1.length()-32, Final1.length());  
		    	//System.out.println("target "+Final2);
				//System.out.println("whole test" + whole[3][0]);

		    	while(whole[bne][0] != null){
			if(whole[bne][0].equals(Final2)){
				n = bne;
				jump = true;
				break;
			}
				bne++;
		    	}
		    	
		    }	
		    else if(jump == false)
		    		n++;
		    	//System.out.println("Go to last instruction");
		    	//System.out.println("last instruction"+ n);

		}
		else if(instruction.substring(0,6).equals("000101")){//bne
			//System.out.println("n at the first of bne "+ n);
	    	String newImmi = "";
			boolean jump = false;
	   		legall = true;
			int rt = Integer.parseInt(instruction.substring(11, 16),2);
			int rs = Integer.parseInt(instruction.substring(6, 11),2);
		    int immi = Integer.parseInt(instruction.substring(16, 32),2);
		    long PC = Long.parseLong(memory.substring(0, 32),2);
		    long newTarget;
		    if(registers[rs] != registers[rt]){
		    	//System.out.println("immi "+ Integer.toBinaryString(immi));
		    	//System.out.println("PC "+ Integer.toBinaryString(PC));
		    	//System.out.println("highest bit "+ Integer.highestOneBit(immi));
		    	// signed extend immi
		    	
		    	if(Integer.highestOneBit(immi) == 0){
		    		newImmi = "0000000000000000" + Integer.toString(immi, 2);		    	}
		    	else if(Integer.highestOneBit(immi) != 1){
		    		newImmi = "1111111111111111" + Integer.toString(immi, 2);
		    	}
		    	// multiply immi by 4
		    	long Integerimmi= Long.parseLong(newImmi,2);
		    	Integerimmi = Integerimmi *4;
		    	//System.out.println("multiplied "+ Integerimmi);
		    	// immi + PC
		    	//System.out.println("pc"+ PC);
		    	newTarget = Integerimmi + PC;
		    	//System.out.println("newTarget TEST"+ newTarget);
		    	String Final1 = Long.toBinaryString(newTarget);
		    	String Final2 = Final1.substring(Final1.length()-32, Final1.length());  
		    	//System.out.println("target "+Final2);
				//System.out.println("whole test" + whole[3][0]);

		    	while(whole[bne][0] != null){
			if(whole[bne][0].equals(Final2)){
				n = bne;
				jump = true;
				break;
			}
				bne++;
		    	}
		    	
		    }	
		    else if(jump == false)
		    		n++;
		    	//System.out.println("Go to last instruction");
		    	//System.out.println("last instruction"+ n);

		    	
		}
			if(legall == false){
			System.out.println("illegal instruction");
			
		}
		
		
		}
		
		//System.out.println("final test "+registers[2]);
		for(int p = 0; p < 4; p++){
			System.out.print(" ["+p+"]      "+registers[p]);
		}
		System.out.println();
		for(int p = 4; p < 8; p++){
			System.out.print(" ["+p+"]      "+registers[p]);
		}
		System.out.println();

		for(int p = 8; p < 12; p++){
			System.out.print(" ["+p+"]      "+registers[p]);
		}
		System.out.println();

		for(int p = 12; p < 16; p++){
			System.out.print(" ["+p+"]    "+registers[p]);
		}
		System.out.println();

		for(int p = 16; p < 20; p++){
			System.out.print(" ["+p+"]     "+registers[p]);
		}
		System.out.println();

		for(int p = 20; p < 24; p++){
			System.out.print(" ["+p+"]     "+registers[p]);
		} 
		System.out.println();

		for(int p = 24; p < 28; p++){
			System.out.print(" ["+p+"]     "+registers[p]);
		}
		System.out.println();

		for(int p = 28; p < 32; p++){
			System.out.print(" ["+p+"]     "+registers[p]);
		}
		System.out.println();

	}
	
}