package kriattus.lesproduct;




import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
//---------------------------------------start---------------------------------------------------------------------------------
    @GetMapping("/ping")
    public ResponseEntity<Object> ping(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alive", true);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
    //@GetMapping("/")
    public ResponseEntity<Object> share(){
        Map<String, Object> map = new HashMap<String, Object>();
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    //------------------------------------------- prime factors----------------------------------------------------------------------------------------------------------
    @GetMapping("/primeFactors")
    public ResponseEntity<Object> primeFactors(String number){
       HashMap <String,Object> map = new HashMap<String,Object>();
       if(number.contains(",")) {
           HashMap<String, Object> map1 = new HashMap<String, Object>();
           HashMap<String, Object> map2 = new HashMap<String, Object>();
           List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
           String text[] = number.split(",");
           map2.put("number", text[2]);
           map2.put("error", "not a number");
           int num = Integer.parseInt(text[0]);
           int num1 = Integer.parseInt(text[1]);
           map1.put("number", num1);
           map1.put("decomposition", primeFactores(num1));
           map.put("number", num);
           map.put("decomposition", primeFactores(num));
           list.add(map);
           list.add(map1);
           list.add(map2);


           return new ResponseEntity<Object>(list, HttpStatus.OK);
       }
       else{

           if (number.matches(".*[a-z].*")){
               map.put("number",number);
               map.put("error","not a number");
               return new ResponseEntity<Object>(map, HttpStatus.OK);
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
               if (num>1000000){
                   map.put("error","too big number (>1e6)");
               }
               else{
                   map.put("decomposition", primeFactores(num));
               }
           }
           return new ResponseEntity<Object>(map, HttpStatus.OK);
       }
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
//----------------------------------------fire---------------------------------------------------------------------
    @GetMapping("/fire/geek")
    public ResponseEntity<Object> geek(String geeks){
        HashMap <String,Object> map = new HashMap<String,Object>();
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


}
