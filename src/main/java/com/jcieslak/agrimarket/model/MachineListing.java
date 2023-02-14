package com.jcieslak.agrimarket.model;

import com.jcieslak.agrimarket.enums.MachineCondition;
import com.jcieslak.agrimarket.enums.MachineType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "listing")
@Data
public class MachineListing extends Listing{
    private String make;
    private String model;
    private MachineCondition machineCondition;
    private int yearProduced;
    private MachineType machineType;
    private int mth;
    private int hp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MachineListing that)) return false;
        if (!super.equals(o)) return false;
        return yearProduced == that.yearProduced && mth == that.mth && hp == that.hp && make.equals(that.make) && Objects.equals(model, that.model) && machineCondition == that.machineCondition && machineType == that.machineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), make, model, machineCondition, yearProduced, machineType, mth, hp);
    }
}
