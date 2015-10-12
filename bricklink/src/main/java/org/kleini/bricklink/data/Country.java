/*
 * GPL v3
 */

package org.kleini.bricklink.data;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * {@link Country} lists ISO 3166-1 alpha-2 country codes.
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public enum Country {

    AD("Andorra"),
    AE("United Arab Emirates"),
    AF("Afghanistan"),
    AG("Antigua and Barbuda"),
    AI("Anguilla"),
    AL("Albania"),
    AM("Armenia"),
    AN("Netherlands Antilles"),
    AO("Angola"),
    AQ(null),
    AR("Argentina"),
    AS("American Samoa"),
    AT("Austria"),
    AU("Australia"),
    AW("Aruba"),
    AX(null),
    AZ("Azerbaijan"),
    BA(null),
    BB(null),
    BD(null),
    BE("Belgium"),
    BF(null),
    BG(null),
    BH(null),
    BI(null),
    BJ(null),
    BL(null),
    BM(null),
    BN(null),
    BO(null),
    BQ(null),
    BR("Brazil"),
    BS(null),
    BT(null),
    BV(null),
    BW(null),
    BY(null),
    BZ(null),
    CA("Canada"),
    CC(null),
    CD(null),
    CF(null),
    CG(null),
    CH("Switzerland"),
    CI(null),
    CK(null),
    CL(null),
    CM(null),
    CN("China"),
    CO(null),
    CR(null),
    CU(null),
    CV(null),
    CW(null),
    CX(null),
    CY(null),
    CZ("Czech Republic"),
    DE("Germany"),
    DJ(null),
    DK("Denmark"),
    DM(null),
    DO(null),
    DZ(null),
    EC(null),
    EE(null),
    EG(null),
    EH(null),
    ER(null),
    ES("Spain"),
    ET(null),
    FI("Finland"),
    FJ(null),
    FK(null),
    FM(null),
    FO(null),
    FR("France"),
    GA(null),
    GB(null),
    GD(null),
    GE(null),
    GF(null),
    GG(null),
    GH(null),
    GI(null),
    GL(null),
    GM(null),
    GN(null),
    GP(null),
    GQ(null),
    GR(null),
    GS(null),
    GT(null),
    GU(null),
    GW(null),
    GY(null),
    HK("Hong Kong"),
    HM(null),
    HN(null),
    HR("Croatia"),
    HT(null),
    HU("Hungary"),
    ID("Indonesia"),
    IE("Ireland"),
    IL(null),
    IM(null),
    IN(null),
    IO(null),
    IQ(null),
    IR(null),
    IS(null),
    IT("Italy"),
    JE(null),
    JM(null),
    JO(null),
    JP("Japan"),
    KE(null),
    KG(null),
    KH(null),
    KI(null),
    KM(null),
    KN(null),
    KP(null),
    KR("South Korea"),
    KW(null),
    KY(null),
    KZ(null),
    LA(null),
    LB(null),
    LC(null),
    LI(null),
    LK(null),
    LR(null),
    LS(null),
    LT("Lithuania"),
    LU("Luxembourg"),
    LV("Latvia"),
    LY(null),
    MA(null),
    MC(null),
    MD(null),
    ME(null),
    MF(null),
    MG(null),
    MH(null),
    MK("Macedonia"),
    ML(null),
    MM(null),
    MN(null),
    MO(null),
    MP(null),
    MQ(null),
    MR(null),
    MS(null),
    MT(null),
    MU(null),
    MV(null),
    MW(null),
    MX(null),
    MY(null),
    MZ(null),
    NA(null),
    NC(null),
    NE(null),
    NF(null),
    NG(null),
    NI(null),
    NL("Netherlands"),
    NO("Norway"),
    NP(null),
    NR(null),
    NU(null),
    NZ("New Zealand"),
    OM(null),
    PA(null),
    PE(null),
    PF(null),
    PG(null),
    PH(null),
    PK(null),
    PL("Poland"),
    PM(null),
    PN(null),
    PR(null),
    PS(null),
    PT("Portugal"),
    PW(null),
    PY(null),
    QA(null),
    RE(null),
    RO(null),
    RS(null),
    RU("Russia"),
    RW(null),
    SA(null),
    SB(null),
    SC(null),
    SD(null),
    SE("Sweden"),
    SG("Singapore"),
    SH(null),
    SI(null),
    SJ(null),
    SK("Slovakia"),
    SL(null),
    SM(null),
    SN(null),
    SO(null),
    SR(null),
    ST(null),
    SV(null),
    SX(null),
    SY(null),
    SZ(null),
    TC(null),
    TD(null),
    TF(null),
    TG(null),
    TH(null),
    TJ(null),
    TK(null),
    TL(null),
    TM(null),
    TN(null),
    TO(null),
    TR("Turkey"),
    TT(null),
    TV(null),
    TW("Taiwan"),
    TZ(null),
    UA(null),
    UG(null),
    UK("United Kingdom"),
    UM(null),
    US("United States of America"),
    UY(null),
    UZ(null),
    VA(null),
    VC(null),
    VE(null),
    VG(null),
    VI(null),
    VN(null),
    VU(null),
    WF(null),
    WS(null),
    YE(null),
    YT(null),
    ZA(null),
    ZM(null),
    ZW(null);

    private final String name;

    Country(String name) {
        this.name = name;
    }

    @JsonCreator
    public static Country forValue(String value) {
        return Country.valueOf(value.toUpperCase());
    }

    public String getName() {
        return name;
    }
}
