package uk.firedev.cmihelper;

import com.Zrips.CMI.Containers.CMIUser;
import net.Zrips.CMILib.Colors.CMIChatColor;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class CMIHelper {

    /**
     * Checks if a player is in vanish.
     * @param player The player to check.
     * @return Whether a player is in vanish.
     */
    public boolean isVanished(@NotNull UUID player) {
        if (isPluginEnabled("CMI")) {
            return CMIUser.getUser(player).isCMIVanished();
        }
        return false;
    }

    /**
     * Sets whether a player is in vanish
     * @param player The player to update.
     * @param vanished Should the player should be in vanish.
     */
    public void setVanished(@NotNull UUID player, boolean vanished) {
        if (isPluginEnabled("CMI")) {
            CMIUser.getUser(player).setVanished(vanished, true);
        }
    }

    /**
     * Parses color codes, just like CMI does.
     * Requires CMILib.
     * @param message The message to parse
     * @return The parsed message
     */
    public String parseColors(@NotNull String message) {
        if (isPluginEnabled("CMILib")) {
            return CMIChatColor.colorize(message);
        }
        return message;
    }

    private boolean isPluginEnabled(@NotNull String plugin) {
        return Bukkit.getPluginManager().isPluginEnabled(plugin);
    }

}
