package kriattus.lesproduct;



import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/ping")
    public ResponseEntity<Object> ping(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alive", true);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
    @GetMapping("/primeFactors")
    public  String primeFactors(String number){


        int num=Integer.parseInt(number);

        String decomposition="{ ";
        decomposition = decomposition+'"'+"number"+'"'+" :"+number+","+'"'+"decomposition"+'"'+" :"+"[";
        Integer aux=1;
        for (int j = 1; j < num; j++) {
            aux=aux*2;

            if (j==1){
                decomposition = decomposition+2;
            }else {

            decomposition = decomposition+","+2;
            }
            if (aux>=num){
                break;
            }
        }
         decomposition+="]"+"}";
       // HashMap<Object, Object> map = new HashMap<>();
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("number", num);
        //map.put("decomposition",""+decomposition);

        //return map;
        //return new ResponseEntity<Object>(map, HttpStatus.OK);
        return decomposition;
    }

}