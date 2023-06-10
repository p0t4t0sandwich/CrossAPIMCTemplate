package ca.sperrer.p0t4t0sandwich.template.bukkit.commands;

import ca.sperrer.p0t4t0sandwich.template.bukkit.BukkitMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicBoolean;

import static ca.sperrer.p0t4t0sandwich.template.common.Utils.ansiiParser;
import static ca.sperrer.p0t4t0sandwich.template.common.Utils.runTaskAsync;

public class BukkitTemplateCommand implements CommandExecutor {
    private final BukkitMain plugin = BukkitMain.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AtomicBoolean success = new AtomicBoolean(false);
        runTaskAsync(() -> {
            try {
                // Check if sender is a player
                if ((sender instanceof Player)) {
                    Player player = (Player) sender;

                    // Permission check
                    if (!player.hasPermission("template.command")) {
                        player.sendMessage("§cYou do not have permission to use this command.");
                        return;
                    }

                    String text = "";

                    player.sendMessage(text);
                } else {
                    plugin.getLogger().info(ansiiParser("§cYou must be a player to use this command."));
                }
                success.set(true);
            } catch (Exception e) {
                success.set(false);
                System.err.println(e);
                e.printStackTrace();
            }
        });
        return success.get();
    }
}
