import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * L= b(b+a^2Ua)(aUb)*
 */
public class Taller_2 {

    private String input;

    public Taller_2(String input) {

        this.input = input;
    }
//this method simulates the behavior of the string on the automata

    public boolean validation() {
        int size = input.length();
        int index = 0;
        boolean accepted_state = true;

        //starts in q0
        if (index < size && input.charAt(index) == 'b')//qo 
        {	
            //move q4
            index += 1;
            if (index < size && input.charAt(index) == 'a')//q4 
            {
                //move q2
                index += 1;
            } else if (index < size && input.charAt(index) == 'b')//q4 
            {
                //move q3
                index += 1;

                while (index < size && input.charAt(index) == 'b') //q3
                {

                    //Loop in q3
                    index += 1;
                }
                if (index < size && input.charAt(index) == 'a') //q3
                {
                    //move q1
                    index += 1;
                    if (index < size && input.charAt(index) == 'a') //q1
                    {
                        //move q2
                        index += 1;
                    } else {
                        //wrong symbol
                        accepted_state = false;
                    }
                } else {
                    //wrong symbol
                    accepted_state = false;
                }
            } else {
                //wrong symbol
                accepted_state = false;
            }
            
            //q2
            while (accepted_state && index< size && (input.charAt(index)== 'a' || input.charAt(index)=='b')) 
            {                
                //loop in q2
                index +=1;
                
            }
            if (index != size) 
            {
             accepted_state=false;
             
            } 
        } else {
            //wrong symbol!
            accepted_state = false;
        }
        return accepted_state;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//buffer to read from string
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//buffer write from string

        try {
            String input = br.readLine();//read input string of the automata
            Taller_2 demo = new Taller_2(input); //create abstraract machine and gives parameters
            bw.write(input);
            if (demo.validation()) { //if input es accepted
                bw.write("\ncadena aceptada\n");
            } else {//if input not accepted
                bw.write("\ncadena rechazada\n");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}