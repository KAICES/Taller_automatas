import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Taller_2 {

    private String input;

    public Taller_2(String input) {

        this.input = input;
    }
//Este programa simula el comportamiento de un automata para verificar si una cadena de un lenguaje es valido o no

// ******** funcion de validacion *****
    
   public boolean validation() {
        int size = input.length();
        int index = 0;
        boolean accepted_state = true;

        //comienza en q0
        if (index < size && input.charAt(index) == 'b')//qo 
		   {
        		//se mueve a q1
				index += 1;
		   }
		        			if (index < size && input.charAt(index) == 'a')//q1
					        {
					        // se mueve a q2
					        index += 1 ; 
					        
					        		}else if (index < size && input.charAt(index) == 'b')//q1
								        {
								        // se mueve a q3
								        index += 1 ;
									        while (index < size && input.charAt(index) == 'b' ) //q3
								            {
								            //bucle en q3
								            index += 1;
								            }
									        if (index < size && input.charAt(index)== 'a')//q3
									        {
									        	//se mueve a q4
									            index += 1;
									        		}else {
											       //simbolo incorrecto
											       accepted_state = false;
											       }
									            if (index < size && input.charAt(index)== 'a')//q4
										        {
										        	//se mueve a q2
										            index += 1;
										            while (index < size && input.charAt(index) == 'a' || input.charAt(index) == 'b' ) //q2
										            {
										            //bucle en q2
										            index += 1;
										            }
										        		}else {
													       //simbolo incorrecto
													       accepted_state = false;
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
        BufferedReader br = new BufferedReader(new InputStreamReader

(System.in));//buffer to read from string
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter

(System.out));//buffer write from string

        try {
            String input = br.readLine();//lee la cadena del automata
            Taller_2 demo = new Taller_2(input); //crea los parametros de la máquina
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