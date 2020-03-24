package kriattus.lesproduct;



import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
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
    public HashMap<String, Object> primeFactors(String number){


        int num=Integer.parseInt(number);
        ArrayList<Integer> str = new ArrayList<Integer>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        Integer aux=1;
        for (int j = 1; j < num; j++) {
            aux=aux*2;
                str.add(2);
            if (aux>=num){
                break;
            }
        }
        map.put("number",num);
        map.put("decomposition",str);
        return map;

    }

}