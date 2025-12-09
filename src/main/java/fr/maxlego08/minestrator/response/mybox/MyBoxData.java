package fr.maxlego08.minestrator.response.mybox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyBoxData(
        MyBoxOffer offer,
        List<MyBoxDatabase> databases,
        List<MyBoxOption> options,
        List<MyBoxDedicatedIp> dedicated_ips,
        MyBoxDedicatedIpStatus dedicated_ip,
        List<MyBoxServer> servers,
        List<MyBoxWebhosting> webhostings,
        MyBoxPimp pimpmybox,
        MyBoxDetails mybox
) {
}
