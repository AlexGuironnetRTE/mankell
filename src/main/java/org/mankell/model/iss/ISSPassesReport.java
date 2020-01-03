package org.mankell.model.iss;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ISSPassesReport {

    private String message;
    private ISSRequest request;
    private List<ISSPass> response; //TODO @Singular? Maybe change response to passes

    public String getMessage() {
        return message;
    }

    public ISSRequest getRequest() {
        return request;
    }

    public List<ISSPass> getResponse() {
        return response;
    }
}

