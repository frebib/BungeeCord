package net.md_5.bungee.api.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.chat.ComponentSerializer;

/**
 * Event called when a server player sends a message to a player.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ServerChatEvent extends TargetedEvent implements Cancellable
{

    /**
     * Cancelled state.
     */
    private boolean cancelled;
    /**
     * Text contained in this chat.
     */
    private BaseComponent[] message;
    /**
     * Type of message/display location
     */
    private ChatMessageType position;

    public ServerChatEvent(Connection sender, Connection receiver, String json, byte position)
    {
        super( sender, receiver );
        this.message = ComponentSerializer.parse(json);
        this.position = ChatMessageType.values()[position];
    }
}
