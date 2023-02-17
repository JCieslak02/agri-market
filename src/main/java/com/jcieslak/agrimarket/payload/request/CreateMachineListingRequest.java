package com.jcieslak.agrimarket.payload.request;

import com.jcieslak.agrimarket.enums.MachineCondition;
import com.jcieslak.agrimarket.enums.MachineType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

@Data
public class CreateMachineListingRequest extends CreateListingRequest {
    @NotNull
    private String make;
    private String model;
    @NotNull
    private MachineCondition machineCondition;
    @NotNull
    @Min(1900)
    @Max(2023)
    private int yearProduced;
    @NotNull
    private MachineType machineType;
    private double mth;
    private int hp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateMachineListingRequest that)) return false;
        if (!super.equals(o)) return false;
        return yearProduced == that.yearProduced && Double.compare(that.mth, mth) == 0 && hp == that.hp && make.equals(that.make) && Objects.equals(model, that.model) && machineCondition == that.machineCondition && machineType == that.machineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), make, model, machineCondition, yearProduced, machineType, mth, hp);
    }
}
