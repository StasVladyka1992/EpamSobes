package Patterns.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class CommandStorage {
    private Map<String, Command> commands = new HashMap<>();

    public void add(String key, Command command) {
        commands.put(key, command);
    }

    public Command getCommand(String key){
        return commands.get(key);
    }

}
