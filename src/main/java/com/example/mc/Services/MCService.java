package com.example.mc.Services;

import com.example.mc.Entities.MasterCeremony;

import java.util.List;

public interface MCService {
    MasterCeremony create(MasterCeremony masterCeremony);
    List<MasterCeremony> findAll();
    MasterCeremony update(String name, MasterCeremony mc);
   // MasterCeremony findMcByName(String name);
}
