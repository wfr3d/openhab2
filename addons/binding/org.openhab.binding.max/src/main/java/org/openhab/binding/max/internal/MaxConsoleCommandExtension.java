package org.openhab.binding.max.internal;

import java.util.Arrays;
import java.util.List;

import org.eclipse.smarthome.io.console.Console;
import org.eclipse.smarthome.io.console.extensions.AbstractConsoleCommandExtension;

public class MaxConsoleCommandExtension extends AbstractConsoleCommandExtension {

    public MaxConsoleCommandExtension() {
        super("max", "Additonal EQ3 MAX! commands.");
    }

    private static final String SUBCMD_RESET = "reset";
    private static final String SUBCMD_VACATION = "vacation";

    @Override
    public void execute(String[] args, Console console) {
        if (args.length > 0) {
            final String subCommand = args[0];
            switch (subCommand) {
                case SUBCMD_VACATION:

                    if (args.length > 2) {
                        String duration = args[2];
                        try {
                            console.println("Switching to vacation mode for " + duration + " min");

                            /*
                             * ThingUID thingUID = new ThingUID(args[1]);
                             * List<DiscoveryResult> results = inbox.get(new InboxFilterCriteria(thingUID, null));
                             * if (results.isEmpty()) {
                             * console.println("No matching inbox entry could be found.");
                             * return;
                             * }
                             * inbox.approve(thingUID, label);
                             */
                        } catch (Exception e) {
                            console.println(e.getMessage());
                        }
                    } else {
                        console.println("Specify device & duration");
                    }

                    break;
                /*
                 * case SUBCMD_IGNORE:
                 * if (args.length > 1) {
                 * try {
                 * ThingUID thingUID = new ThingUID(args[1]);
                 * PersistentInbox persistentInbox = (PersistentInbox) inbox;
                 * persistentInbox.setFlag(thingUID, DiscoveryResultFlag.IGNORED);
                 * } catch (IllegalArgumentException e) {
                 * console.println("'" + args[1] + "' is no valid thing UID.");
                 * }
                 * } else {
                 * console.println("Cannot approve thing as managed thing provider is missing.");
                 * }
                 * break;
                 * case SUBCMD_LIST_IGNORED:
                 * printInboxEntries(console, inbox.get(new InboxFilterCriteria(DiscoveryResultFlag.IGNORED)));
                 * break;
                 */
                case SUBCMD_RESET:
                    resetMaxCube(console);
                    break;
                default:
                    break;
            }
        } else {
            printMaxDevices(console);
        }
    }

    private void printMaxDevices(Console console) {
        console.println("Max devices list.... ");

    }

    private void resetMaxCube(Console console) {
        console.println("resetting...");
    }

    @Override
    public List<String> getUsages() {
        return Arrays
                .asList(new String[] {
                buildCommandUsage(SUBCMD_VACATION + " <thingUID> <duration>",
                        "Set thermostat in vacation mode for the given duration"),
                buildCommandUsage(SUBCMD_RESET, " <IP> reset cube") });
    }

}
