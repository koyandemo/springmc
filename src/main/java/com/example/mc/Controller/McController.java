package com.example.mc.Controller;

import com.example.mc.Entities.MasterCeremony;
import com.example.mc.Entities.Response;
import com.example.mc.Repository.MCrepository;
import com.example.mc.Services.MCService;
import com.example.mc.Services.MCServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/MC")
@CrossOrigin("*")
public class McController {

    private MongoTemplate mongoTemplate;
    private MCService mcService;


    @Autowired
    private MCrepository mcrepository;

    public McController(MongoTemplate mongoTemplate, MCService mcService) {
        this.mongoTemplate = mongoTemplate;
        this.mcService = mcService;
    }

    @GetMapping
    public Collection<MasterCeremony> showAll() {
       return  this.mcService.findAll();
    }


    @GetMapping("/mci/name/{name}")
    public MasterCeremony findMcbyname(@PathVariable("name") String name){
        return  this.mcrepository.findMasterCeremonyByName(name);
}

   @PutMapping("/update/{name}")
  public MasterCeremony update(@PathVariable("name") String name,@RequestBody MasterCeremony mc){
            MasterCeremony obj =this.mcService.update(name,mc);
            return  obj;
    }


    @PatchMapping("/patch/{name}")
    public MasterCeremony updatepatch(@PathVariable("name") String name,@RequestBody MasterCeremony mc){
        MasterCeremony obj =this.mcService.update(name,mc);
        return  obj;
    }


   @GetMapping("/delete/{name}")
   public void deleteMc(@PathVariable("name") String name){
        this.mcrepository.deleteMasterCeremonyByName(name);

   }



    @PostMapping
    public ResponseEntity<Response> create(@RequestBody MasterCeremony masterCeremony){
        mcService.create(masterCeremony);
        return ResponseEntity.ok().body(new Response(HttpStatus.CREATED,"Created MC!"));
    }

}
