/*
 * GPLv3
 */

package org.kleini.bricklink.api;

import java.util.List;

/**
 * {@link ColorsResponse}
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public class ColorsResponse extends Response<List<Color>> {

    protected ColorsResponse(org.kleini.bricklink.data.Response<List<Color>> response) {
        super(response);
    }

    public List<Color> getColors() {
        return getResponse().getData();
    }
}
