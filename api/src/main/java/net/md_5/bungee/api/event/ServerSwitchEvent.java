package net.md_5.bungee.api.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

/**
 * Called when a player has changed servers.
 */
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class ServerSwitchEvent extends Event
{

    /**
     * Player whom the server is for.
     */
    private final ProxiedPlayer player;

    /**
     * Servers the player is switching from
     */
    private final ServerInfo from;
    /**
     * Servers the player is switching to
     */
    @NonNull
    private final ServerInfo to;
}
