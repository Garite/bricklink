/*
 * GPL v3
 */

package org.kleini.bricklink.api;

/**
 * List of possible property names in configuration file.
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public enum ConfigurationProperty {

    CONSUMER_KEY("org.kleini.bricklink.consumerKey"),
    CONSUMER_SECRET("org.kleini.bricklink.consumerSecret"),
    TOKEN_VALUE("org.kleini.bricklink.tokenValue"),
    TOKEN_SECRET("org.kleini.bricklink.tokenSecret"),
    COMMENT_REGEX("org.kleini.bricklink.commentRegex");

    private final String propertyName;

    ConfigurationProperty(String propertName) {
        this.propertyName = propertName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
