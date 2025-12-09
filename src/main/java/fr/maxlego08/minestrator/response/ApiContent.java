package fr.maxlego08.minestrator.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiContent<T>(
        String description,
        String endpoint,
        int code,
        T data,
        String error
) {

    public boolean isSuccess() {
        return this.code == 200;
    }

    public boolean isError(){
        return this.code != 200;
    }

}

