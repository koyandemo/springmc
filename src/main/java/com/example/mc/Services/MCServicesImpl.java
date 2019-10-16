package com.example.mc.Services;

import com.example.mc.Entities.MasterCeremony;
import com.example.mc.Repository.MCrepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MCServicesImpl implements MCService {

    private final MCrepository mcrepository;

    public MCServicesImpl(MCrepository mCrepository) {
        this.mcrepository = mCrepository;
    }

    @Override
    public MasterCeremony create(MasterCeremony masterCeremony) {
        return mcrepository.save(masterCeremony);
    }

    @Override
    public List<MasterCeremony> findAll() {
        return mcrepository.findAll();
    }

    @Override
    @Transactional
    public MasterCeremony update(String name, MasterCeremony mc) {
        MasterCeremony obj = this.mcrepository.findMasterCeremonyByName(name);

        obj.setName(mc.getName());
        obj.setImage(mc.getImage());
        obj.setPhone(mc.getPhone());
        obj.setPrice(mc.getPrice());
        obj.setCity(mc.getCity());
        obj.setDescription(mc.getDescription());
        obj.setEmail(mc.getEmail());
        this.mcrepository.save(obj);
        return obj;
    }


    public MasterCeremony findAllMC(String name){
       return this.mcrepository.findMasterCeremonyByName(name);
    }

}
