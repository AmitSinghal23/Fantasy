package org.game.fantasy.quest.util.marshaller;

import org.game.fantasy.quest.context.GameContext;

public interface Marshaller {
    void marshall(GameContext gameContext, String path);
    GameContext unmarshall(String path);
}
