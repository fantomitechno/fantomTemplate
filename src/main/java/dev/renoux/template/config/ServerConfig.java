package dev.renoux.template.config;

import net.fabricmc.loader.api.FabricLoader;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.serializers.TomlSerializer;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import org.quiltmc.config.implementor_api.ConfigFactory;

import java.nio.file.Paths;

import static dev.renoux.template.Template.metadata;

public class ServerConfig extends ReflectiveConfig {
    static ServerConfig SINGLE_INSTANCE;


    public static ServerConfig getConfig() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = ConfigFactory.create(new ConfigEnvironment(FabricLoader.getInstance().getConfigDir(), TomlSerializer.INSTANCE), metadata.getId(), metadata.getId(), Paths.get(""), builder -> {}, ServerConfig.class, builder -> {});
        }

        return SINGLE_INSTANCE;
    }
}
