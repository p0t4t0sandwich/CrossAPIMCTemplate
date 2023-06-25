package ca.sperrer.p0t4t0sandwich.template.velocity;

import ca.sperrer.p0t4t0sandwich.template.velocity.commands.VelocityTemplateCommand;
import ca.sperrer.p0t4t0sandwich.template.velocity.listeners.player.VelocityPlayerLoginListener;
import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.neuralnexus.template.common.TemplatePlugin;
import org.slf4j.Logger;

/**
 * The TaterAPI Velocity plugin.
 */
@Plugin(
        id = "taterapi",
        name = "TaterAPI",
        version = "1.0.0",
        authors = "p0t4t0sandwich",
        description = "A cross API code library for various generalizations used in the Tater* plugins",
        url = "https://github.com/p0t4t0sandwich/TaterAPI",
        dependencies = {}
)
public class VelocityTaterAPIPlugin implements TemplatePlugin {
    @Inject private ProxyServer server;
    @Inject private Logger logger;

    private static ProxyServer proxyServer;
    /**
     * Get the proxy server.
     * @return The proxy server.
     */
    public static ProxyServer getProxyServer() {
        return proxyServer;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Object pluginLogger() {
        return logger;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String pluginConfigPath() {
        return "plugins";
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getServerType() {
        return "Velocity";
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerHooks() {
        // Register LuckPerms hook
//        if (server.getPluginManager().getPlugin("LuckPerms").isPresent()) {
//            useLogger("LuckPerms detected, enabling LuckPerms hook.");
//            Template.addHook(new LuckPermsHook());
//        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerEventListeners() {
        EventManager eventManager = server.getEventManager();
        eventManager.register(this, new VelocityPlayerLoginListener());
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerCommands() {
        CommandManager commandManager = server.getCommandManager();
        commandManager.register("template", new VelocityTemplateCommand());
    }

    /**
     * Called when the proxy is initialized.
     * @param event The event.
     */
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxyServer = server;
        pluginStart();
    }

    /**
     * Called when the proxy is shutting down.
     * @param event The event.
     */
    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        pluginStop();
    }
}
