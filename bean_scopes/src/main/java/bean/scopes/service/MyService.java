package bean.scopes.service;

import bean.scopes.beans.MyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyService {

    private Map<String, MyRequest> requestMap = new HashMap<>();

    public void addRequest(MyRequest request) {
        requestMap.putIfAbsent(request.getParam(), request);
        log.info("New entry {} added. Current size is {}", request, requestMap.keySet().size());
        printMap("Printing from addRequest");
    }

    public int getSize() {
        return requestMap.keySet().size();
    }

    @Scheduled(fixedDelay = 10000)
    private void scheduled() {
        printMap("Printing from scheduler");
    }

    private void printMap(String msg) {
        StringBuilder sb = new StringBuilder(">>> " + msg + "\n");
        try {
            Set<Map.Entry> allEntries = requestMap.entrySet().stream()
                    .peek(entry -> {
                        sb.append("\tKey = " + entry.getKey() + ", Value = " + String.valueOf(entry.getValue()) + "\n");
                    })
                    .collect(Collectors.toSet());
            sb.append("\tTotal entries count: " + allEntries.size());
        } catch (Throwable th) {
            log.error("Printing failed\nType:{}\nMessage: {}", th.getClass(), th.getMessage());
        } finally {
            log.info(sb.toString());
        }
    }
}