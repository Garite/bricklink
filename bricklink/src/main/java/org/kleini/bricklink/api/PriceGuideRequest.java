/*
 * GPL v3
 */

package org.kleini.bricklink.api;

import java.util.ArrayList;
import java.util.List;
import org.kleini.address.Country;
import org.kleini.bricklink.data.Condition;
import org.kleini.bricklink.data.Currency;
import org.kleini.bricklink.data.GuideType;
import org.kleini.bricklink.data.ItemType;

/**
 * {@link PriceGuideRequest}
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public final class PriceGuideRequest extends AbstractGetRequest<PriceGuideResponse> {

    private final ItemType type;
    private final String itemID;
    private final int colorID;
    private final GuideType guideType;
    private final Condition newOrUsed;
    private final Country country;

    public PriceGuideRequest(ItemType type, String itemID, int colorID, GuideType guideType, Condition newOrUsed, Country country) {
        super();
        this.type = type;
        this.itemID = itemID;
        this.colorID = colorID;
        this.guideType = guideType;
        this.newOrUsed = newOrUsed;
        this.country = country;
    }

    public PriceGuideRequest(ItemType type, String itemID, int colorID, GuideType guideType, Condition newOrUsed) {
        this(type, itemID, colorID, guideType, newOrUsed, null);
    }

    @Override
    public String getPath() {
        return "items/" + type.name().toLowerCase() + '/' + itemID + "/price";
    }

    @Override
    public Parameter[] getParameters() {
        List<Parameter> retval = new ArrayList<Parameter>();
        retval.add(new Parameter("color_id", colorID));
        retval.add(new Parameter("guide_type", guideType.getParamValue()));
        retval.add(new Parameter("new_or_used", newOrUsed.name()));
        retval.add(new Parameter("currency_code", Currency.EUR.name()));
        if (null != country) {
            retval.add(new Parameter("country_code", country.name()));
        }
        retval.add(new Parameter("vat", "Y")); // Vat option must be Y, N, or O
        return retval.toArray(new Parameter[retval.size()]);
    }

    @Override
    public PriceGuideParser getParser() {
        return new PriceGuideParser();
    }
}
