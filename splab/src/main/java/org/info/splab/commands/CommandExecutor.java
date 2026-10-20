package org.info.splab.commands;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class CommandExecutor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final Map<String, String> requestStatuses = new ConcurrentHashMap<>();
    private final Map<String, Object> requestResults = new ConcurrentHashMap<>();

    public <T> T executeSync(Command<T> command) {
        return command.execute();
    }

    public <T> String executeAsync(Command<T> command) {
        String requestId = UUID.randomUUID().toString();
        requestStatuses.put(requestId, "PROCESSING");

        executorService.submit(() -> {
            try {
                T result = command.execute();
                requestResults.put(requestId, result);
                requestStatuses.put(requestId, "COMPLETED");
            } catch (Exception e) {
                requestStatuses.put(requestId, "FAILED: " + e.getMessage());
            }
        });

        return requestId;
    }

    public String getStatus(String requestId) {
        return requestStatuses.getOrDefault(requestId, "NOT_FOUND");
    }

    public Object getResult(String requestId) {
        return requestResults.get(requestId);
    }
}