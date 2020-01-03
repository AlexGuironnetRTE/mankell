package org.mankell.model.iss;

import lombok.AllArgsConstructor;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRequest(ISSRequest request) {
        this.request = request;
    }

    public void setResponse(List<ISSPass> response) {
        this.response = response;
    }
}

