package net.md_5.bungee.chat;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.md_5.bungee.api.chat.ScoreComponent;

public class ScoreComponentSerializer extends BaseComponentSerializer implements JsonSerializer<ScoreComponent>, JsonDeserializer<ScoreComponent>
{

    @Override
    public ScoreComponent deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject object = element.getAsJsonObject();
        JsonObject score = object.get("score").getAsJsonObject();
        if ( !score.has( "name" ) || !score.has( "objective" ) )
        {
            throw new JsonParseException( "A score component needs at least a name and an objective" );
        }

        String name = score.get( "name" ).getAsString();
        String objective = score.get( "objective" ).getAsString();
        ScoreComponent component = new ScoreComponent( name, objective );
        if ( score.has( "value" ) && !score.get( "value" ).getAsString().isEmpty() )
        {
            component.setValue( score.get( "value" ).getAsString() );
        }

        deserialize( object, component, context );
        return component;
    }

    @Override
    public JsonElement serialize(ScoreComponent component, Type type, JsonSerializationContext context)
    {
        JsonObject root = new JsonObject();
        serialize( root, component, context );
        JsonObject json = new JsonObject();
        json.addProperty( "name", component.getName() );
        json.addProperty( "objective", component.getObjective() );

        String value = component.getValue();
        if ( value != null && !value.isEmpty() )
        {
            json.addProperty( "value", value);
        }
        root.add( "score", json );
        return root;
    }
}
