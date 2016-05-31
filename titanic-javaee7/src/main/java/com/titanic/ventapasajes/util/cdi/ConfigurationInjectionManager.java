package com.titanic.ventapasajes.util.cdi;

/**
 * Created by josediaz on 1/6/16.
 */
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
public class ConfigurationInjectionManager {
    static final String INVALID_KEY = "Invalid key '{0}'";
    static final String MANDATORY_PARAM_MISSING = "No definition found for a mandatory configuration parameter : '{0}'";
    private final String BUNDLE_FILE_NAME = "configuration";
    private final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_FILE_NAME);

    @Produces
    @InjectedConfiguration
    public String injectConfiguration(InjectionPoint ip) throws IllegalStateException {
        InjectedConfiguration param = ip.getAnnotated().getAnnotation(InjectedConfiguration.class);
        if (param.key() == null || param.key().length() == 0) {
            return param.defaultValue();
        }
        String value;
        try {
            value = bundle.getString(param.key());
            if (value == null || value.trim().length() == 0) {
                if (param.mandatory())
                    throw new IllegalStateException(MessageFormat.format(MANDATORY_PARAM_MISSING, new Object[]{param.key()}));
                else
                    return param.defaultValue();
            }
            return value;
        } catch (MissingResourceException e) {
            if (param.mandatory())
                throw new IllegalStateException(MessageFormat.format(MANDATORY_PARAM_MISSING, new Object[]{param.key()}));
            return MessageFormat.format(INVALID_KEY, new Object[]{param.key()});
        }
    }
}