package Patterns.Command;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class TestCommand {
    private static CommandStorage storage = new CommandStorage();

    public static void main(String[] args) {
        storage.add("к1", new Command1());
        storage.add("к2", new Command2());

        storage.getCommand("к1").execute();
        storage.getCommand("к2").execute();
    }
}
