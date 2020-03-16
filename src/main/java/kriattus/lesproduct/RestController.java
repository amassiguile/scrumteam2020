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
    public ResponseEntity<Object> powerOfTwo(Integer num){
        String decomposition=null;
        int aux=1;
        decomposition = decomposition+"[";
        for (int j = 1; j < num; j++) {
            aux=aux*2;

            if (aux<=num){
                break;
            }
            decomposition = decomposition+"2";
        }
        decomposition = decomposition+"]";
        HashMap<String, Object> map = new HashMap<>();
        map.put("number", num);
        map.put("decomposition", decomposition);
        return new ResponseEntity<Object>( map,HttpStatus.OK);
    }
}