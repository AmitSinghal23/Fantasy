package org.game.fantasy.quest.util.marshaller;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.newInputStream;
import static java.nio.file.Files.newOutputStream;
import static java.nio.file.Files.notExists;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.game.fantasy.quest.context.GameContext;

public class StandardJavaMarshaller implements Marshaller {

    @Override
    public void marshall(GameContext gameContext, String path) {
        Path filePath = Paths.get(path);
        createFileIfNotExist(filePath);
        try (ObjectOutput output = new ObjectOutputStream(newOutputStream(filePath))) {
            output.writeObject(gameContext);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void createFileIfNotExist(Path path) {
        if (exists(path)) {
            return;
        }
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public GameContext unmarshall(String path) {
        Path filePath = Paths.get(path);
        if (notExists(filePath)) {
            throw new IllegalStateException("Either file does not exist or you are trying to load a game which was not saved before from this file"
            		+ "Path: " + filePath.toAbsolutePath().toString());
        }
        try (ObjectInput input = new ObjectInputStream(newInputStream(filePath))) {
            return (GameContext) input.readObject();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
