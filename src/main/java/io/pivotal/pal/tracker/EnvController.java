package io.pivotal.pal.tracker;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceAddr;

    public EnvController(@Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr)
    {
this.port = port;
this.memoryLimit = memoryLimit;
this.cfInstanceIndex = cfInstanceIndex;
this.cfInstanceAddr = cfInstanceAddr;
    }
    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return Stream.of(new String[][] {
                { "PORT", port },
                { "MEMORY_LIMIT", memoryLimit },
                {"CF_INSTANCE_INDEX",cfInstanceIndex},
                {"CF_INSTANCE_ADDR", cfInstanceAddr}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    }
}
