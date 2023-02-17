package com.jcieslak.agrimarket.payload.response;

import com.jcieslak.agrimarket.enums.MachineCondition;
import com.jcieslak.agrimarket.enums.MachineType;
import lombok.Data;

@Data
public class MachineListingResponse extends ListingResponse{
    private String make;
    private String model;
    private MachineCondition machineCondition;
    private int yearProduced;
    private MachineType machineType;
    private int mth;
    private int hp;
}
