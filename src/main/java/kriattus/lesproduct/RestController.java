package kriattus.lesproduct;




import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.data.crossstore.HashMapChangeSet;
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
    public List<HashMap<String, Object>> primeFactors(String number){
       HashMap <String,Object> map = new HashMap<String,Object>();
        HashMap <String,Object> map1 = new HashMap<String,Object>();
        HashMap <String,Object> map2 = new HashMap<String,Object>();
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        String text[] = number.split(",");
            map2.put("number",text[2]);
            map2.put("error","not a number");
            int num = Integer.parseInt(text[0]);
            int num1 = Integer.parseInt(text[1]);
            map1.put("number",num1);
            map1.put("decomposition", primeFactores(num1));
            map.put("number",num);
            map.put("decomposition", primeFactores(num));
        list.add(map);
        list.add(map1);
        list.add(map2);

        return list;

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
