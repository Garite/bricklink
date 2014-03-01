/*
 * GPLv3
 */

package org.kleini.bricklink.selenium.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.kleini.bricklink.data.Condition;
import org.kleini.bricklink.data.Country;
import org.kleini.bricklink.data.GuideType;
import org.kleini.bricklink.data.ItemType;
import org.kleini.bricklink.data.PriceDetail;
import org.kleini.bricklink.data.PriceGuide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * {@link PriceGuidePage}
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public final class PriceGuidePage {

    private final WebDriver driver;

    public PriceGuidePage(WebDriver driver) {
        super();
        this.driver = driver;
        open();
    }

    private void open() {
        WebElement catalogTab = driver.findElement(By.linkText(" Catalog "));
        catalogTab.click();
        WebElement priceGuideTab = driver.findElement(By.linkText("Price Guide"));
        priceGuideTab.click();
    }

    public PriceGuide getPriceGuide(ItemType itemType, String itemID, int colorID, GuideType guideType, Condition condition, boolean details) throws Exception {
        // Fill all required input fields.
        WebElement itemTypeSelect = driver.findElement(By.xpath("//b[text()='View Price Guide Info:']/../..//select[@name='itemType']"));
        itemTypeSelect.findElement(By.xpath("option[@value='" + itemType.getId() + "']")).click();
        WebElement itemIDInput = driver.findElement(By.xpath("//b[text()='View Price Guide Info:']/../..//input[@name='itemNo']"));
        itemIDInput.sendKeys(itemID);
        WebElement colorIdSelect = driver.findElement(By.xpath("//b[text()='View Price Guide Info:']/../..//select[@name='colorID']"));
        colorIdSelect.findElement(By.xpath(".//option[@value='" + Integer.toString(colorID) + "']")).click();
        WebElement sortBySelect = driver.findElement(By.xpath("//select[@name='v']"));
        sortBySelect.findElement(By.xpath("option[@value='P']")).click();
        WebElement monthGroupCheckBox = driver.findElement(By.xpath("//input[@name='priceGroup']"));
        if (monthGroupCheckBox.isSelected()) {
            monthGroupCheckBox.click();
        }
        WebElement roundToSelect = driver.findElement(By.xpath("//select[@name='prDec']"));
        roundToSelect.findElement(By.xpath("option[@value='4']")).click();
        WebElement button = driver.findElement(By.xpath("//input[@value='View Price Guide Info']"));
        button.click();
        // Go to next page and fetch values
        WebElement myColumn = driver.findElement(By.xpath("//td[@width='25%'][position()=" + calculateColumn(guideType, condition) + ']'));
        PriceGuide retval = new PriceGuide();
        if (details) {
            List<WebElement> priceDetailColumns = myColumn.findElements(By.xpath(".//tr[@align='RIGHT' and count(td)=3 and position()>1]/td"));
            if (GuideType.STOCK == guideType) {
                List<WebElement> countryFlags = myColumn.findElements(By.xpath(".//tr[@align='RIGHT' and count(td)=3 and position()>1]/td/img[contains(@src, 'flagsS')]"));
                for (int i = 0; i < priceDetailColumns.size(); i+=3) {
                    parsePriceDetail(retval, priceDetailColumns.get(i + 1).getText(), priceDetailColumns.get(i + 2).getText(), countryFlags.get(i/3).getAttribute("src"));
                }
            } else {
                for (int i = 0; i < priceDetailColumns.size(); i+=3) {
                    parsePriceDetail(retval, priceDetailColumns.get(i + 1).getText(), priceDetailColumns.get(i + 2).getText(), null);
                }
            }
        }
        List<WebElement> priceDetailColumns = myColumn.findElements(By.xpath(".//tr[@align='RIGHT' and count(td)=2]/td"));
        for (int i = 0; i < priceDetailColumns.size(); i+=2) {
            parsePriceGuide(retval, priceDetailColumns.get(i).getText(), priceDetailColumns.get(i+1).getText());
        }
        return retval;
    }

    private static void parsePriceDetail(PriceGuide retval, String quantity, String price, String flagURL) throws Exception {
        PriceDetail detail = new PriceDetail();
        try {
            detail.setQuantity(Integer.parseInt(quantity));
            detail.setPrice(parseBigDecimal(price));
        } catch (NumberFormatException e) {
            throw new Exception("Can not parse \"" + quantity + "\" or \"" + price + "\".", e);
        }
        if (null != flagURL) {
            String countryCode = flagURL.substring(flagURL.lastIndexOf('/') + 1, flagURL.lastIndexOf('.')).toUpperCase(Locale.US);
            detail.setSellerCountry(Country.valueOf(countryCode));
        }
        List<PriceDetail> details = retval.getDetail();
        if (null == details) {
            details = new ArrayList<PriceDetail>();
            retval.setDetail(details);
        }
        details.add(detail);
    }

    /**
     * @param value "EUR 0.0743"
     */
    private static void parsePriceGuide(PriceGuide guide, String type, String value) throws Exception {
        try {
            if (type.startsWith("Times Sold:")) {
                guide.setUnits(Integer.parseInt(value));
            }
            if (type.startsWith("Total Qty:")) {
                guide.setQuantity(Integer.parseInt(value));
            }
            if (type.startsWith("Min Price:")) {
                guide.setMinPrice(parseBigDecimal(value));
            }
            if (type.startsWith("Avg Price:")) {
                guide.setAveragePrice(parseBigDecimal(value));
            }
            if (type.startsWith("Qty Avg Price:")) {
                guide.setQuantityAveragePrice(parseBigDecimal(value));
            }
            if (type.startsWith("Max Price:")) {
                guide.setMaxPrice(parseBigDecimal(value));
            }
        } catch (NumberFormatException e) {
            throw new Exception("Can not parse \"" + value + "\" of type " + type + ".", e);
        }
    }

    private static BigDecimal parseBigDecimal(String value) throws NumberFormatException {
        return new BigDecimal(value.substring(value.indexOf("EUR") + 4));
    }

    private static int calculateColumn(GuideType guideType, Condition condition) {
        //       N U
        // sold  1 2
        // stock 3 4
        return guideType.ordinal() * 2 + condition.ordinal() + 1;
    }
}