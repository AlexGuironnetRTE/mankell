package org.mankell.model.iss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ISSPass {

    private double duration;
    private long riseTime;

    public double getDuration() {
        return duration;
    }

    public long getRiseTime() {
        return riseTime;
    }
}
