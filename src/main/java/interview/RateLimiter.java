package interview;

public class RateLimiter {
    private final long maxRequests;      // максимум запросов
    private final long timeWindowMs;     // временное окно (мс)
    private long count = 0;              // текущее количество
    private long windowStart = 0;        // начало окна

    public RateLimiter(long maxRequests, long timeWindowMs) {
        this.maxRequests = maxRequests;
        this.timeWindowMs = timeWindowMs;
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();

        // Если окно истекло - сбрасываем
        if (now - windowStart > timeWindowMs) {
            windowStart = now;
            count = 0;
        }

        // Проверяем лимит
        if (count < maxRequests) {
            count++;
            return true;  // разрешаем
        }

        return false;  // отклоняем
    }
}
