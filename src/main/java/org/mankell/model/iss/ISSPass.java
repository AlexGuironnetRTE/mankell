package org.mankell.model.iss;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ISSPass {

    private double duration;
    private long risetime;

    public double getDuration() {
        return duration;
    }

    public long getRisetime() {
        return risetime;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setRisetime(long risetime) {
        this.risetime = risetime;
    }
}
