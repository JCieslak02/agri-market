package com.jcieslak.agrimarket.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "listing")
@Data
public class TractorListing extends Listing{
    private String make;
    private String model;
    private String condition;
    private double mth;
    private int yearProduced;
    private int hp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TractorListing that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.mth, mth) == 0 && yearProduced == that.yearProduced && hp == that.hp && make.equals(that.make) && model.equals(that.model) && condition.equals(that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), make, model, condition, mth, yearProduced, hp);
    }
}
