package kriattus.lesproduct;




import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/ping")
    public ResponseEntity<Object> ping(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alive", true);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
    @GetMapping("/primeFactors")
    public HashMap<String, Object> primeFactors(String number){
        HashMap<String, Object> map = new HashMap<String, Object>();
        String text = number;
        if (text.matches(".*[a-z].*")){
            map.put("number",number);
            map.put("error","not a number");
            return map;
        }else {
            int num = Integer.parseInt(number);
            ArrayList<Integer> str = new ArrayList<Integer>();

            Integer aux = 1;
            for (int j = 1; j < num; j++) {
                aux = aux * 2;
                str.add(2);
                if (aux >= num) {
                    break;
                }
            }

            map.put("number",number);
            map.put("decomposition", primeFactores(num));
        }
        return map;

    }
    public static List<Integer> primeFactores(long number) {
        List<Integer> primefactors = new ArrayList<>();
     long copyOfInput = number;
        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i); // prime factor

                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }



            }
