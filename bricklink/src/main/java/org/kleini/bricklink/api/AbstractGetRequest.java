/*
 * GPL v3
 */

package org.kleini.bricklink.api;

import static org.kleini.bricklink.api.Request.Method.GET;

/**
 * Common abstract implementations for GET requests.
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
abstract class AbstractGetRequest<T extends Response<?>> implements Request<T> {

    AbstractGetRequest() {
        super();
    }

    @Override
    public Method getMethod() {
        return GET;
    }

    @Override
    public String getBody() {
        throw new UnsupportedOperationException("HTTP method GET does not support request bodies.");
    }
}
