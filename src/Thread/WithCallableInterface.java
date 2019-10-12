package Thread;

import java.util.concurrent.Callable;

/**
 * @project EpamSobes
 * author Stas Vladyka on 26.07.2019.
 */
public class WithCallableInterface implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "my callble thread";
    }
}
