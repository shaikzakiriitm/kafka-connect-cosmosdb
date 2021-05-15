package com.azure.cosmos.kafka.connect.sink.id.strategy;

import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class TemplateStrategyConfig extends AbstractIdStrategyConfig {
    public static final String TEMPLATE_CONFIG = "template";
    public static final String TEMPLATE_CONFIG_DEFAULT = "";
    public static final String TEMPLATE_CONFIG_DOC = "The template string to use for determining the `id`";
    public static final String TEMPLATE_CONFIG_DISPLAY = "Template";
    private final String template;

    public TemplateStrategyConfig(Map<String, ?> props) {
        this(getConfig(), props);
    }

    public TemplateStrategyConfig(ConfigDef definition, Map<String, ?> originals) {
        super(definition, originals);

        this.template = getString(TEMPLATE_CONFIG);
    }


    public static ConfigDef getConfig() {
        ConfigDef result = new ConfigDef();

        final String groupName = "Template Parameters";
        int groupOrder = 0;

        result.define(
                TEMPLATE_CONFIG,
                ConfigDef.Type.STRING,
                TEMPLATE_CONFIG_DEFAULT,
                ConfigDef.Importance.MEDIUM,
                TEMPLATE_CONFIG_DOC,
                groupName,
                groupOrder++,
                ConfigDef.Width.MEDIUM,
                TEMPLATE_CONFIG_DISPLAY
        );

        return result;
    }

    public String template() {
        return template;
    }
}
