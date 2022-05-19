package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@RestController
public class Controller {

    private final RestTemplate restTemplate;

    String url = "https://pokeapi.co/api/v2/pokemon";

    @Autowired
    public Controller (RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/")

    public Object getApi() {
        return restTemplate.getForObject(url, Object.class);
        
    }
    
    @GetMapping("/{nombre}")

   public Object getNombre(@PathVariable("nombre") String nombre) {
    String obtenerPoke="";
    RestTemplate restTemplate = new RestTemplate();
     obtenerPoke = restTemplate.getForObject(url+"/"+nombre,String.class);
     JSONObject obtenerObj = new JSONObject(obtenerPoke);
        obtenerPoke = obtenerObj.optString("name");
        return obtenerPoke;
    }

    @GetMapping("/{nombre}/abilities")

    public Object getAbilities(@PathVariable("nombre") String nombre) {
        String obtenerAbiliti="";
        RestTemplate restTemplate = new RestTemplate();
         obtenerAbiliti = restTemplate.getForObject(url+"/"+nombre,String.class);
         JSONObject obtenerObj = new JSONObject(obtenerAbiliti);
			obtenerAbiliti = obtenerObj.optString("abilities");
            return obtenerAbiliti;
     }

     @GetMapping("/{nombre}/held-items")

     public Object getHeld(@PathVariable("nombre") String nombre) {
         String obtenerHeld="";
         RestTemplate restTemplate = new RestTemplate();
          obtenerHeld = restTemplate.getForObject(url+"/"+nombre,String.class);
          JSONObject obtenerObj = new JSONObject(obtenerHeld);
             obtenerHeld = obtenerObj.optString("held_items");
             return obtenerHeld;
      }

      @GetMapping("/{nombre}/id")

      public Object getId(@PathVariable("nombre") String nombre) {
          String obtenerId="";
          RestTemplate restTemplate = new RestTemplate();
           obtenerId = restTemplate.getForObject(url+"/"+nombre,String.class);
           JSONObject obtenerObj = new JSONObject(obtenerId);
              obtenerId = obtenerObj.optString("id");
              return obtenerId;
       }
     
       @GetMapping("/{nombre}/location-area-encounters")

       public Object getArea(@PathVariable("nombre") String nombre) {
           String obtenerArea="";
           RestTemplate restTemplate = new RestTemplate();
            obtenerArea = restTemplate.getForObject(url+"/"+nombre,String.class);
            JSONObject obtenerObj = new JSONObject(obtenerArea);
               obtenerArea = obtenerObj.optString("location_area_encounters");
               return obtenerArea;
        }
}
