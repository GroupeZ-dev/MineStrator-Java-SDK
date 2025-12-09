package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxPermissions(
        List<String> mybox,
        List<MyBoxServerPermissions> servers
) {
}
