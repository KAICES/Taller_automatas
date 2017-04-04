import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Taller_1 {

    private String input;

    public Taller_1(String input) {

        this.input = input;
    }
//Este programa simula el comportamiento de un automata para verificar si una cadena de un lenguaje es valido o no

// ******** funcion de validacion *****
    
   public boolean validation() {
        int size = input.length();
        int index = 0;
        boolean accepted_state = true; // estado de la cadena

        //comienza en q0
   		if (index < size && input.charAt(index) == '0')//qo 
		   {
           //se mueve a q1
   				index += 1;
		 
           			while (index < size && input.charAt(index) == '0') //q1
		            
		            //bucle en q1
		            index += 1;
		            
				      	if(index < size && input.charAt(index) == '1' ) //q1 
				      
				        // se mueve a q2
				       	index += 1 ;				               					          		
				    	else 
				   			//simbolo incorrecto
				   			accepted_state = false;
				      	
							}
							else
							{
								if(index < size &&  input.charAt(index) == '1') //q1 
									index += 1;  // se mueve a q2
								else
									//simbolo incorrecto
						   			accepted_state = false;					
						   } 		
		           				
		while(index < size)
		{
			if (index < size && input.charAt(index) == '0')//q2
		       
		        // se mueve a q3
		        index += 1 ;	
	           		while (index < size && input.charAt(index) == '0') //q3
		            //bucle en q3
		            index += 1;
		                if (index < size && input.charAt(index) == '1')//q3
				        // se mueve a q4
				        index += 1 ;
							else {
							//simbolo incorrecto
							accepted_state = false;
								 }
		                
		          if (index < size && input.charAt(index) == '0')//q4
						{
						// se mueve a q5
						index += 1 ;
								while (index < size && input.charAt(index) == '0') //q5
						        //bucle en q5
								 index += 1;								           
								   	if (index < size && input.charAt(index) == '1')//q5
									    // se mueve a q4
										index += 1 ;
							       		else {
									          //simbolo incorrecto
									          accepted_state = false;
									          }
												   	
										}
										else 
										{
			           		if (index < size && input.charAt(index) == '1')//q4
					        
					        // se mueve a q2
					        index += 1 ;
					        					            
			           		else {
								 //simbolo incorrecto
								 accepted_state = false;
								 }
						  }
		        }	
		if (index != size) 
		  {
		   accepted_state=false;           	             
		  } 
		         	          				         				     				
	
        return accepted_state;
		  }

//**************************************************

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//buffer to read from string
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//buffer write from string

        try {
            String input = br.readLine();//lee la cadena del automata
            Taller_1 demo = new Taller_1(input); //crea los parametros de la máquina
            bw.write(input);
            if (demo.validation()) { //si la cadena es aceptada
                bw.write("\ncadena aceptada\n");
            } else {//si la cadena es aceptada
                bw.write("\ncadena rechazada\n");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}